package org.app.company;


import org.app.company.model.Volunteer;
import org.app.company.services.VolunteerService;

public class MainTests {
    public static void main(String[] args) {
        VolunteerService service = new VolunteerService();

        Volunteer newVolunteer = new Volunteer();
        newVolunteer.setFirstName("Test User");
        newVolunteer.setEmail("test@example.com");
        newVolunteer.setPassword("12345");
        service.createToList(newVolunteer);

        Volunteer loggedVolunteer = service.checkLogin("test@example.com");
        if (loggedVolunteer != null) {
            System.out.println("Login bem-sucedido: " + loggedVolunteer.getFirstName());
        } else {
            System.out.println("Login falhou.");
        }
    }

}
