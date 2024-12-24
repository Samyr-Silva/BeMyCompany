package org.app.company.services;

import org.app.company.model.Beneficiary;
import org.app.company.model.Volunteer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class VolunteerService {

    @Autowired
    private BeneficiaryService beneficiaryService;
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
        volunteer.setLikesCrochet(false);
        volunteer.setLikesFootball(false);
        volunteer.setLikesDomino(false);

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
        volunteer3.setFirstName("aNDRE");
        volunteer3.setAge(39);
        volunteer3.setId(3);
        volunteer3.setLocation("Braga");
        volunteer3.setImage("https://i.ibb.co/cx9c4zG/volunteer-man-1.png");
        volunteer3.setEmail("andrezinho.silva@gmail.com");
        volunteer3.setPassword("outstanding");
        volunteer3.setLikesFootball(false);


        addVolunteer(volunteer);
        addVolunteer(volunteer2);
        addVolunteer(volunteer3);
    }

    public void addVolunteer (Volunteer volunteer){
        volunteerList.add(volunteer);
    }

    public Volunteer checkLogin(String email) {
        for (Volunteer volunteer : volunteerList) {
            if (volunteer.getEmail().equals(email)) { // Use equals para comparar Strings
                return volunteer;
            }
        }
        return null; // Retorna null se o voluntário não for encontrado
    }

    public List <Volunteer> list(){
        return volunteerList;
    }

    public List<Beneficiary> listOfBeneficiaries(){
        return beneficiaryService.getBeneficiaryList();
    }

    public boolean removeBeneficiary(int id) {
        if(listOfBeneficiaries().removeIf(beneficiary -> beneficiary.getId() == id)){
            return true;
        }
        else{
            return false;
        }
    }

    public List<Beneficiary> myList(int id){
        for (Volunteer volunteer : volunteerList){
            if (volunteer.getId() == id){
                return volunteer.getMyBeneficiaries();
            }
        }
        return null;
    }
}