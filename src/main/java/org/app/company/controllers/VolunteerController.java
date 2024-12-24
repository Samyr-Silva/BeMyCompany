package org.app.company.controllers;

import org.app.company.model.Volunteer;
import org.app.company.services.VolunteerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class VolunteerController {
    @Autowired
    private VolunteerService volunteerService;

    @RequestMapping(method = RequestMethod.GET, path = {"/volunteerLogin", "volunteerLogin/"})
    public String getLoginPage() {
        return "volunteerLogin";
    }

    @RequestMapping(method = RequestMethod.GET, path = {"/volunteerRegister", "/volunteerRegister/"})
    public String getRegister() {
        return "volunteerRegister";
    }

    @RequestMapping(method = RequestMethod.POST, path = {"/volunteerRegister", "volunteerRegister/"})
    public String addVolunteer(@RequestBody Volunteer volunteer) {
        volunteerService.addVolunteer(volunteer);
        return "redirect:/volunteerProfile";
    }

    @RequestMapping(method = RequestMethod.POST, path = {"/volunteerProfile", "/volunteerProfile/"})
    public String getProfile(
            @RequestParam("email") String email,
            @RequestParam("password") String password,
            Model model
    ) {
        // Verifica se o email existe no banco de dados
        Volunteer volunteer = volunteerService.checkLogin(email);

        if (volunteer == null || !volunteer.getPassword().equals(password)) {
            // Adiciona uma mensagem de erro ao modelo e redireciona para a página de login
            model.addAttribute("error", "Invalid email or password");
            return "volunteerLogin";
        }

        // Adiciona o voluntário ao modelo e carrega a página de perfil
        model.addAttribute("vol", volunteer);
        model.addAttribute("beneficiaries", volunteer.getMyBeneficiaries()); // Lista específica do voluntário
        return "volunteerProfile";
    }

    @RequestMapping(method = RequestMethod.GET, path = {"/volunteerProfile", "/volunteerProfile/"})
    public String getProfileGet() {
        return "volunteerProfile";
    }

    @RequestMapping(method = RequestMethod.GET, path = {"/beneficiarySchedule", "/beneficiarySchedule/"})
    public String getSchedule() {
        return "beneficiarySchedule";
    }

    @PostMapping("/delete/{volunteerId}/{beneficiaryId}")
    public String deleteBeneficiary(
            @PathVariable int volunteerId,
            @PathVariable int beneficiaryId,
            RedirectAttributes redirectAttributes
    ) {
        // Remove beneficiário da lista específica do voluntário
        boolean isRemoved = volunteerService.removeBeneficiaryFromVolunteer(volunteerId, beneficiaryId);

        if (isRemoved) {
            redirectAttributes.addFlashAttribute("message", "Beneficiary removed successfully!");
        } else {
            redirectAttributes.addFlashAttribute("error", "Failed to remove beneficiary.");
        }

        return "redirect:/volunteerProfile";
    }

    @RequestMapping(method = RequestMethod.GET, path = {"/volunteerCalendar/{id}", "/volunteerCalendar/{id}/"})
    public String getCalendar(
            @PathVariable int id,
            Model model) {
        Volunteer volunteer = volunteerService.findVolunteerById(id);
        model.addAttribute("vol", volunteer);
        model.addAttribute("beneficiaries", volunteer.getMyBeneficiaries());
        return "volunteerCalendar";
    }
}
