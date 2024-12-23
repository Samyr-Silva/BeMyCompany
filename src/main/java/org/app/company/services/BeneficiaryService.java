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
        beneficiary.setEmail("mariuso.santos@gmail.com");
        beneficiary.setPassword("mari");
        beneficiary.setImage("https://i.ibb.co/55vvfdz/beneficiary-man-1.png");
        beneficiary.setAge(68);
        beneficiary.setLocation("Lisboa");
        beneficiary.setLikesCrochet(false);
        beneficiary.setLikesFootball(false);


        Beneficiary beneficiary2 = new Beneficiary();
        beneficiary2.setFirstName("Romaria");
        beneficiary2.setEmail("roma.santos@gmail.com");
        beneficiary2.setImage("https://i.ibb.co/XYjJFLp/beneficiary-woman-3.png");
        beneficiary2.setPassword("roma");
        beneficiary2.setAge(78);
        beneficiary2.setLocation("Faro");
        beneficiary2.setLikesCrochet(false);
        beneficiary2.setLikesDomino(false);
        beneficiary2.setLikesCinema(false);
        beneficiary2.setLikesFootball(false);

        Beneficiary beneficiary3 = new Beneficiary();
        beneficiary3.setFirstName("Mauricio");
        beneficiary3.setEmail("bembem.santos@gmail.com");
        beneficiary3.setImage("https://i.ibb.co/HYprhCb/beneficiary-man-2.png");
        beneficiary3.setPassword("dobem");
        beneficiary3.setAge(98);
        beneficiary3.setLocation("Braga");
        beneficiary3.setLikesDomino(false);
        beneficiary3.setLikesCinema(false);
        beneficiary3.setLikesFootball(false);

        addBeneficiary(beneficiary);
        addBeneficiary(beneficiary2);
        addBeneficiary(beneficiary3);


    }
    public void addBeneficiary (Beneficiary beneficiary){
        beneficiaryList.add(beneficiary);
    }


    public Beneficiary checkLogin(String email){
        for (Beneficiary beneficiary : beneficiaryList) {
            if (beneficiary.getEmail().equals(email)) {
                return beneficiary;
            }
        }
        return null; // Retorna null se o voluntário não for encontrado
    }
    public List <Beneficiary> list(){
        return beneficiaryList;
    }

    public Beneficiary getBeneficiary(){
        return beneficiaryList.get((int)Math.floor(Math.random() * beneficiaryList.size()));
    }

    private List<String> commonInterestsList;

    public List<String> listCommonInterests(){
        return commonInterestsList;
    }

    public void cancelMondayMorningMeeting(Beneficiary beneficiary){
        beneficiary.setAvailableMondayMorning(true);
        beneficiary.setScheduledMondayMorning(false);
        beneficiary.setVolunteerMondayMorning(null);
    }

    public void cancelMondayAfternoonMeeting(Beneficiary beneficiary){
        beneficiary.setAvailableMondayAfternoon(true);
        beneficiary.setScheduledMondayAfternoon(false);
        beneficiary.setVolunteerMondayAfternoon(null);
    }

    public void cancelTuesdayMorningMeeting(Beneficiary beneficiary){
        beneficiary.setAvailableTuesdayMorning(true);
        beneficiary.setScheduledTuesdayMorning(false);
        beneficiary.setVolunteerTuesdayMorning(null);
    }

    public void cancelTuesdayAfternoonMeeting(Beneficiary beneficiary){
        beneficiary.setAvailableTuesdayAfternoon(true);
        beneficiary.setScheduledTuesdayAfternoon(false);
        beneficiary.setVolunteerTuesdayAfternoon(null);
    }

    public void cancelWednesdayMorningMeeting(Beneficiary beneficiary){
        beneficiary.setAvailableWednesdayMorning(true);
        beneficiary.setScheduledWednesdayMorning(false);
        beneficiary.setVolunteerWednesdayMorning(null);
    }

    public void cancelWednesdayAfternoonMeeting(Beneficiary beneficiary){
        beneficiary.setAvailableWednesdayAfternoon(true);
        beneficiary.setScheduledWednesdayAfternoon(false);
        beneficiary.setVolunteerWednesdayAfternoon(null);
    }

    public void cancelThursdayMorningMeeting(Beneficiary beneficiary){
        beneficiary.setAvailableThursdayMorning(true);
        beneficiary.setScheduledThursdayMorning(false);
        beneficiary.setVolunteerThursdayMorning(null);
    }

    public void cancelFridayMorningMeeting(Beneficiary beneficiary){
        beneficiary.setAvailableFridayMorning(true);
        beneficiary.setScheduledFridayMorning(false);
        beneficiary.setVolunteerFridayMorning(null);
    }

    public void cancelFridayAfternoonMeeting(Beneficiary beneficiary){
        beneficiary.setAvailableFridayAfternoon(true);
        beneficiary.setScheduledFridayAfternoon(false);
        beneficiary.setVolunteerFridayAfternoon(null);
    }

    public void cancelSaturdayMorningMeeting(Beneficiary beneficiary){
        beneficiary.setAvailableSaturdayMorning(true);
        beneficiary.setScheduledSaturdayMorning(false);
        beneficiary.setVolunteerSaturdayMorning(null);
    }

    public void cancelSaturdayAfternoonMeeting(Beneficiary beneficiary){
        beneficiary.setAvailableSaturdayAfternoon(true);
        beneficiary.setScheduledSaturdayAfternoon(false);
        beneficiary.setVolunteerSaturdayAfternoon(null);
    }

    public void cancelSundayMorningMeeting(Beneficiary beneficiary){
        beneficiary.setAvailableSundayMorning(true);
        beneficiary.setScheduledSundayMorning(false);
        beneficiary.setVolunteerSundayMorning(null);
    }

    public void cancelSundayAfternoonMeeting(Beneficiary beneficiary){
        beneficiary.setAvailableSundayAfternoon(true);
        beneficiary.setScheduledSundayAfternoon(false);
        beneficiary.setVolunteerSundayAfternoon(null);
    }
}