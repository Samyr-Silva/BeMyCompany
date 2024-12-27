package org.app.company.controllers;

import org.app.company.model.Beneficiary;
import org.app.company.model.Volunteer;
import org.app.company.services.BeneficiaryService;
import org.app.company.services.VolunteerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

@Controller
public class BeneficiaryController {

    @Autowired
    private BeneficiaryService beneficiaryService;

    @Autowired
    private VolunteerService volunteerService;

    @RequestMapping(method = RequestMethod.GET, path = {"/beneficiaryLogin", "/beneficiaryLogin/"})
    public String getLoginPage() {
        return "beneficiaryLogin";
    }

    @RequestMapping(method = RequestMethod.GET, path = {"/beneficiaryRegister", "/beneficiaryRegister/"})
    public String getRegister() {
        return "beneficiaryRegister";
    }

    @RequestMapping(method = RequestMethod.POST, path = {"/beneficiaryRegister", "/beneficiaryRegister/"})
    public String addBeneficiary(@RequestBody Beneficiary beneficiary) {
        beneficiaryService.addBeneficiary(beneficiary);
        return "beneficiaryProfile";
    }

    @RequestMapping(method = RequestMethod.POST, path = {"/beneficiaryProfile", "/beneficiaryProfile/"})
    public String getProfile(
            @RequestParam("email") String email,
            @RequestParam("password") String password,
            HttpSession session,
            Model model
    ) {
        Beneficiary beneficiary = beneficiaryService.checkLogin(email);

        if (beneficiary == null || !beneficiary.getPassword().equals(password)) {
            model.addAttribute("error", "Invalid email or password");
            return "beneficiaryLogin";
        }

        session.setAttribute("beneficiary", beneficiary);

        model.addAttribute("ben", beneficiary);
        model.addAttribute("volunteers", beneficiary.getMyVolunteers());

        return "beneficiaryProfile";
    }

    @RequestMapping(method = RequestMethod.GET, path = {"/beneficiaryProfile", "/beneficiaryProfile/"})
    public String getProfileGet(HttpSession session, Model model) {
        Beneficiary beneficiary = (Beneficiary) session.getAttribute("beneficiary");

        if (beneficiary == null) {
            return "redirect:/beneficiaryLogin";
        }

        model.addAttribute("ben", beneficiary);
        model.addAttribute("volunteers", beneficiary.getMyVolunteers());

        return "beneficiaryProfile";
    }

    @RequestMapping(method = RequestMethod.GET, path = {"/addSchedule", "/addSchedule/"})
    public String getSchedule(HttpSession session) {
        Beneficiary beneficiary = (Beneficiary) session.getAttribute("beneficiary");

        if (beneficiary != null) {
            beneficiaryService.addVolunteerToBeneficiary(beneficiary.getId(), volunteerService.list());
        }

        return "redirect:/beneficiaryProfile";
    }

    @RequestMapping(method = RequestMethod.GET, path = {"/beneficiaryCalendar/{id}", "/beneficiaryCalendar/{id}/"})
    public String getCalendar(
            @PathVariable int id,
            Model model) {
        Beneficiary beneficiary = beneficiaryService.findBeneficiaryById(id);
        model.addAttribute("ben", beneficiary);
        model.addAttribute("volunteers", beneficiary.getMyVolunteers());
        return "beneficiaryCalendar";
    }
}
