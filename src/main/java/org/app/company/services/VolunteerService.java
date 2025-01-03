package org.app.company.services;

import org.app.company.model.Beneficiary;
import org.app.company.model.Volunteer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

@Service
public class VolunteerService {


    @Autowired
    private BeneficiaryService beneficiaryService = new BeneficiaryService();
    private List<Volunteer> volunteerList = new ArrayList<>();

    public VolunteerService(){
        Volunteer volunteer = new Volunteer();
        volunteer.setFirstName("Mariuson");
        volunteer.setPassword("samyr");
        volunteer.setAge(28);
        volunteer.setId(1);
        volunteer.setLocation("Lisboa");
        volunteer.setImage("https://i.ibb.co/RhhLrMG/volunteer-man-2.png");
        volunteer.setEmail("maumau.silva@gmail.com");
        volunteer.setLikesCinema(false);
        volunteer.setLikesFootball(false);
        volunteer.setLikesDomino(false);

        List<Beneficiary> beneficiaries = beneficiaryService.getBeneficiaryList();
        if (!beneficiaries.isEmpty()) {
            volunteer.addBeneficiary(beneficiaries.get(0));
            volunteer.addBeneficiary(beneficiaries.get(1));// Adicionando o primeiro beneficiário (por exemplo)
            volunteer.addBeneficiary(beneficiaries.get(2));
            volunteer.addBeneficiary(beneficiaries.get(3));
        }

        Volunteer volunteer2 = new Volunteer();
        volunteer2.setFirstName("Felicity");
        volunteer2.setAge(18);
        volunteer2.setId(2);
        volunteer2.setLocation("Porto");
        volunteer2.setImage("https://i.ibb.co/5crktcj/volunteer-woman-3.png");
        volunteer2.setEmail("felicity.silva@gmail.com");
        volunteer2.setPassword("gato");
        volunteer2.setLikesCrochet(false);
        volunteer2.setLikesFootball(false);


        Volunteer volunteer3 = new Volunteer();
        volunteer3.setFirstName("Rui");
        volunteer3.setAge(29);
        volunteer3.setId(3);
        volunteer3.setLocation("Braga");
        volunteer3.setImage("https://i.ibb.co/cx9c4zG/volunteer-man-1.png");
        volunteer3.setEmail("andrezinho.silva@gmail.com");
        volunteer3.setPassword("outstanding");
        volunteer3.setLikesFootball(false);

        List<Beneficiary> beneficiariesOther = beneficiaryService.getBeneficiaryList();
        if (!beneficiaries.isEmpty()) {
            volunteer3.addBeneficiary(beneficiariesOther.get(0));
            volunteer3.addBeneficiary(beneficiariesOther.get(1));
            volunteer3.addBeneficiary(beneficiariesOther.get(2));
            volunteer3.addBeneficiary(beneficiariesOther.get(3));
        }


        Volunteer volunteer4 = new Volunteer();
        volunteer4.setFirstName("Suzana");
        volunteer4.setAge(23);
        volunteer4.setId(4);
        volunteer4.setLocation("Aveiro");
        volunteer4.setImage("https://i.ibb.co/5crktcj/volunteer-woman-3.png");
        volunteer4.setEmail("suzana.silva@gmail.com");
        volunteer4.setPassword("suzan");
        volunteer4.setLikesFootball(false);
        volunteer4.setLikesCrochet(false);
        volunteer4.setLikesDomino(false);
        volunteer4.setLikesCinema(false);
        List<Beneficiary> beneficiariesOtherAnother = beneficiaryService.getBeneficiaryList();
        volunteer4.addBeneficiary(beneficiariesOtherAnother.get(0));
        volunteer4.addBeneficiary(beneficiariesOtherAnother.get(1));
        volunteer4.addBeneficiary(beneficiariesOtherAnother.get(2));

        Volunteer volunteer5 = new Volunteer();
        volunteer5.setFirstName("Fernanda");
        volunteer5.setAge(28);
        volunteer5.setId(5);
        volunteer5.setLocation("Coimbra");
        volunteer5.setImage("https://i.ibb.co/5crktcj/volunteer-woman-3.png");
        volunteer5.setEmail("fer.silva@gmail.com");
        volunteer5.setPassword("nanda");
        volunteer5.setLikesFootball(false);


        addVolunteer(volunteer);
        addVolunteer(volunteer2);
        addVolunteer(volunteer3);
        addVolunteer(volunteer4);
        addVolunteer(volunteer5);
    }

    public void addVolunteer (Volunteer volunteer){
        volunteerList.add(volunteer);
    }

    public Volunteer checkLogin(String email) {
        for (Volunteer volunteer : volunteerList) {
            if (volunteer.getEmail().equals(email)) {
                return volunteer;
            }
        }
        return null; // Retorna null se o voluntário não for encontrado
    }

    public List <Volunteer> list(){
        return volunteerList;
    }


    public boolean addBeneficiaryToVolunteer(int volunteerId, Beneficiary beneficiary) {
        Volunteer volunteer = findVolunteerById(volunteerId);
        if (volunteer != null) {
            volunteer.addBeneficiary(beneficiary);
            return true;
        }
        return false;
    }

    public boolean removeBeneficiaryFromVolunteer(int volunteerId, int beneficiaryId) {
        Volunteer volunteer = findVolunteerById(volunteerId);
        if (volunteer != null) {
            return volunteer.removeBeneficiaryById(beneficiaryId);
        }
        return false;
    }

    public Volunteer findVolunteerById(int id) {
        for (Volunteer volunteer : volunteerList) {
            if (volunteer.getId() == id) {
                return volunteer;
            }
        }
        return null; // Retorna null se não encontrar o voluntário
    }

    public void createToList(Volunteer volunteer){
        volunteerList.add(volunteer);
    }
}