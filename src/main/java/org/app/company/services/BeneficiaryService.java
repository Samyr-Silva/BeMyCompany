package org.app.company.services;


import org.app.company.model.Beneficiary;
import org.app.company.model.Volunteer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.List;

@Service
public class BeneficiaryService {

    private List<Beneficiary> beneficiaryList = new ArrayList<>();

    @Autowired
    private VolunteerService volunteerService;


    public BeneficiaryService() {
        Beneficiary beneficiary = new Beneficiary();
        beneficiary.setFirstName("João");
        beneficiary.setAge(68);
        beneficiary.setId(1);
        beneficiary.setLocation("Braga");
        beneficiary.setImage("https://i.ibb.co/55vvfdz/beneficiary-man-1.png");
        beneficiary.setEmail("mariuso.santos@gmail.com");
        beneficiary.setPassword("mari");
        beneficiary.setLikesFootball(false);

        Beneficiary beneficiary4 = new Beneficiary();
        beneficiary4.setFirstName("Helena");
        beneficiary4.setAge(88);
        beneficiary4.setId(4);
        beneficiary4.setLocation("Lisboa");
        beneficiary4.setImage("https://i.ibb.co/XYjJFLp/beneficiary-woman-3.png");
        beneficiary4.setEmail("helena.santos@gmail.com");
        beneficiary4.setPassword("hel");
        beneficiary4.setLikesFootball(false);


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
        addBeneficiary(beneficiary4);

    }

    public Beneficiary checkLogin(String email) {
        for (Beneficiary beneficiary : beneficiaryList) {
            if (beneficiary.getEmail().equals(email)) {
                return beneficiary;
            }
        }
        return null; // Retorna null se o voluntário não for encontrado
    }

    public Beneficiary findBeneficiaryById(int id) {
        for (Beneficiary beneficiary : beneficiaryList) {
            if (beneficiary.getId() == id) {
                return beneficiary;
            }
        }
        return null; // Retorna null se não encontrar o voluntário
    }

    public void addVolunteerToBeneficiary(int beneficiaryId, List<Volunteer> volunteerList) {
        // Encontra o beneficiário pelo ID
        Beneficiary beneficiary = findBeneficiaryById(beneficiaryId);
        if (beneficiary != null) {
            for (Volunteer volunteer : volunteerList){
                if((volunteer.getMyInterestsList().size() == beneficiary.getMyInterestsList().size())){
                    beneficiary.addVolunteer(volunteer);
                }
            }
        }
    }

    public boolean removeVolunteerFromBeneficiary(int volunteerId, int beneficiaryId) {
        Beneficiary beneficiary = findBeneficiaryById(beneficiaryId);
        if (beneficiary != null) {
            return beneficiary.removeVolunteerById(volunteerId);
        }
        return false;
    }

    public void createToList(Beneficiary beneficiary) {
        beneficiaryList.add(beneficiary);
    }

    public void addBeneficiary(Beneficiary beneficiary) {
        beneficiaryList.add(beneficiary);
    }

    public List<Beneficiary> getBeneficiaryList() {
        return beneficiaryList;
    }

}