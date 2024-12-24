package org.app.company.services;

import org.app.company.model.Beneficiary;
import org.app.company.model.Volunteer;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BeneficiaryService {

    private List<Beneficiary> beneficiaryList = new ArrayList<>();

    public BeneficiaryService(){
        Beneficiary beneficiary = new Beneficiary();
        beneficiary.setFirstName("Ze mariuso");
        beneficiary.setAge(68);
        beneficiary.setId(1);
        beneficiary.setLocation("Lisboa");
        beneficiary.setImage("https://i.ibb.co/55vvfdz/beneficiary-man-1.png");
        beneficiary.setEmail("mariuso.santos@gmail.com");
        beneficiary.setPassword("mari");
        beneficiary.setLikesCrochet(false);
        beneficiary.setLikesFootball(false);


        Beneficiary beneficiary2 = new Beneficiary();
        beneficiary2.setFirstName("Romaria");
        beneficiary2.setAge(78);
        beneficiary2.setId(2);
        beneficiary2.setLocation("Faro");
        beneficiary2.setImage("https://i.ibb.co/XYjJFLp/beneficiary-woman-3.png");
        beneficiary2.setEmail("roma.santos@gmail.com");
        beneficiary2.setPassword("roma");
        beneficiary2.setLikesCrochet(false);
        beneficiary2.setLikesDomino(false);
        beneficiary2.setLikesCinema(false);
        beneficiary2.setLikesFootball(false);

        Beneficiary beneficiary3 = new Beneficiary();
        beneficiary3.setFirstName("Mauricio");
        beneficiary3.setAge(98);
        beneficiary3.setId(3);
        beneficiary3.setLocation("Braga");
        beneficiary3.setImage("https://i.ibb.co/HYprhCb/beneficiary-man-2.png");
        beneficiary3.setEmail("bembem.santos@gmail.com");
        beneficiary3.setPassword("dobem");
        beneficiary3.setLikesDomino(false);
        beneficiary3.setLikesCinema(false);
        beneficiary3.setLikesFootball(false);

        addBeneficiary(beneficiary);
        addBeneficiary(beneficiary2);
        addBeneficiary(beneficiary3);

    }

    public Beneficiary checkLogin(String email){
        for (Beneficiary beneficiary : beneficiaryList) {
            if (beneficiary.getEmail().equals(email)) {
                return beneficiary;
            }
        }
        return null; // Retorna null se o voluntário não for encontrado
    }

    public void addBeneficiary (Beneficiary beneficiary){
        beneficiaryList.add(beneficiary);
    }

    public List<Beneficiary> getBeneficiaryList(){
        return beneficiaryList;
    }
}