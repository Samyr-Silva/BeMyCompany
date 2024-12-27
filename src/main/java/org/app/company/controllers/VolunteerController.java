package org.app.company.controllers;

import org.app.company.model.Volunteer;
import org.app.company.services.VolunteerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;

@Controller
public class VolunteerController {
    @Autowired
    private VolunteerService volunteerService;

    @RequestMapping(method = RequestMethod.POST, path = {"/volunteerLogin", "volunteerLogin/"})
    public String getLoginPage() {
        return "volunteerLogin";
    }
    @RequestMapping(method = RequestMethod.GET, path = {"/volunteerLogin", "volunteerLogin/"})
    public String getLoginPageA() {
        return "volunteerLogin";
    }

    @RequestMapping(method = RequestMethod.GET, path = {"/volunteerRegister", "/volunteerRegister/"})
    public String getRegister() {
        return "volunteerRegister";
    }

    // Process the form and create a new volunteer
    @RequestMapping(method = RequestMethod.POST, path = {"/volunteerRegister", "/volunteerRegister/"})
    public String createVolunteer(
            @RequestParam("firstname") String firstName,
            @RequestParam("lastname") String lastName,
            @RequestParam("age") int age,
            @RequestParam("phone") String phone,
            @RequestParam("email") String email,
            @RequestParam("password") String password,
            @RequestParam("location") String location,
            Model model,
            HttpSession session
    ) {
        // Criação de um novo voluntário
        Volunteer newVolunteer = new Volunteer();
        newVolunteer.setFirstName(firstName);
        newVolunteer.setLastName(lastName);
        newVolunteer.setAge(age);
        newVolunteer.setId(volunteerService.list().size() + 2); // Gerando ID
        newVolunteer.setPhone(phone);
        newVolunteer.setEmail(email);
        newVolunteer.setPassword(password);
        newVolunteer.setLocation(location);

        // Salva o voluntário na lista
        volunteerService.createToList(newVolunteer);

        // Armazena o voluntário na sessão
        session.setAttribute("volunteer", newVolunteer);

        // Redireciona para a página de perfil após a criação
        return "redirect:/volunteerProfile"; // Redireciona para a página de perfil
    }


    @RequestMapping(method = RequestMethod.POST, path = {"/volunteerProfile", "/volunteerProfile/"})
    public String getProfile(
            @RequestParam("email") String email,
            @RequestParam("password") String password,
            HttpSession session,
            Model model
    ) {
        // Verifica se o email existe no banco de dados
        Volunteer volunteer = volunteerService.checkLogin(email);

        if (volunteer == null || !volunteer.getPassword().equals(password)) {
            // Adiciona uma mensagem de erro ao modelo e redireciona para a página de login
            model.addAttribute("error", "Invalid email or password");
            return "volunteerLogin";
        }

        session.setAttribute("volunteer", volunteer);

        // Adiciona o voluntário ao modelo e carrega a página de perfil
        model.addAttribute("vol", volunteer);
        model.addAttribute("beneficiaries", volunteer.getMyBeneficiaries()); // Lista específica do voluntário
        return "redirect:/volunteerProfile";
    }

    @RequestMapping(method = RequestMethod.GET, path = {"/volunteerProfile", "/volunteerProfile/"})
    public String getProfileGet(Model model, HttpSession session) {
        Volunteer volunteer = (Volunteer) session.getAttribute("volunteer");

        if (volunteer == null) {
            model.addAttribute("error", "No volunteer found in session. Please log in.");
            return "redirect:/volunteerLogin";
        }

        model.addAttribute("vol", volunteer);
        model.addAttribute("beneficiaries", volunteer.getMyBeneficiaries());
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
