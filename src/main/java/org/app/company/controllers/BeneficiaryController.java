package org.app.company.controllers;

import org.app.company.model.Beneficiary;
import org.app.company.model.Volunteer;
import org.app.company.services.BeneficiaryService;
import org.app.company.services.VolunteerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class BeneficiaryController {

    @Autowired
    private VolunteerService volunteerService;

    @Autowired
    private BeneficiaryService beneficiaryService;
    @RequestMapping(method = RequestMethod.GET, path = {"/beneficiaryLogin", "/beneficiaryLogin/"})
    public String getLoginPage() {
        return "beneficiaryLogin";
    }

    @RequestMapping(method = RequestMethod.GET, path = {"/beneficiaryRegister", "/beneficiaryRegister/"})
    public String getRegister() {
        return "beneficiaryRegister";
    }

    @RequestMapping(method = RequestMethod.POST, path = {"/beneficiaryRegister", "beneficiaryRegister/"})
    public String addBeneficiary(@RequestBody Beneficiary beneficiary) {
        beneficiaryService.addBeneficiary(beneficiary);
        return "beneficiaryProfile";
    }

    @RequestMapping(method = RequestMethod.POST, path = {"/beneficiaryProfile", "/beneficiaryProfile/"})
    public String getProfile(
            @RequestParam("email") String email,
            @RequestParam("password") String password,
            Model model
    ) {
        // Verifica se o email existe no banco de dados
        Beneficiary beneficiary = beneficiaryService.checkLogin(email);

        if (beneficiary == null || !beneficiary.getPassword().equals(password)) {
            // Adiciona uma mensagem de erro ao modelo e redireciona para a página de login
            model.addAttribute("error", "Invalid email or password");
            return "beneficiaryLogin";
        }

        // Adiciona o voluntário ao modelo e carrega a página de perfil
        model.addAttribute("ben", beneficiary);
        return "beneficiaryProfile";
    }

    @RequestMapping(method = RequestMethod.GET, path = {"/beneficiaryProfile", "/beneficiaryProfile/"})
    public String getProfileGet() {
        return "beneficiaryProfile";
    }

}
