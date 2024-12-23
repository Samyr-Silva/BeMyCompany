package org.app.company;


import org.app.company.model.Volunteer;
import org.app.company.services.VolunteerService;

public class MainTests {
    public static void main(String[] args) {
        VolunteerService volunteerService = new VolunteerService();
        Volunteer volunteer = volunteerService.checkLogin("felicity.silva@gmail.com");
        System.out.println(volunteer.getFirstName());
    }
}
