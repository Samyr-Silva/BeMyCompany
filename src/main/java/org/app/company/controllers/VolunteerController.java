package org.app.company.controllers;

import org.app.company.model.Volunteer;
import org.app.company.services.VolunteerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

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
        return "volunteerProfile";
    }
    @RequestMapping(method = RequestMethod.GET, path = {"/volunteerProfile", "/volunteerProfile/"})
    public String getProfileGet() {
        return "volunteerProfile";
    }

}
