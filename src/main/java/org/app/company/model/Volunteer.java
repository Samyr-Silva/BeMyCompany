package org.app.company.model;

import org.app.company.services.VolunteerService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


public class Volunteer {

    private Integer id;
    private String firstName;
    private String lastName;
    private String image;
    private Integer age;
    private String phone;
    private String email;
    private String password;
    private List<String> myInterestsList = new ArrayList<>();
    private Set<Beneficiary> myBeneficiaries;
    private String location;


    //--------------------INTERESTS------------------------

    private boolean likesFootball;
    private boolean likesCinema;
    private boolean likesDomino;
    private boolean likesCrochet;
    private boolean likesCooking;

//----------------------METHODS-----------------------------
    public Volunteer(){
        this.myBeneficiaries = new HashSet<>();
        populateMyInterestsList();
    }

    public Set<Beneficiary> getMyBeneficiaries() {
        return myBeneficiaries;
    }

    public void addBeneficiary(Beneficiary beneficiary) {
        for (String interest : beneficiary.getMyInterestsList()) {
            for (String myInterest : myInterestsList) {
                if ((beneficiary.getMyInterestsList().size() == myInterestsList.size()) && interest.equals(myInterest)) {
                    myBeneficiaries.add(beneficiary); // HashSet evita duplicatas automaticamente
                }
            }
        }
    }

    public boolean removeBeneficiaryById(int id) {
        return this.myBeneficiaries.removeIf(beneficiary -> beneficiary.getId() == id);
    }

    public void populateMyInterestsList() {
        myInterestsList.add("Cinema");
        myInterestsList.add("Football");
        myInterestsList.add("Domino");
        myInterestsList.add("Crochet");
        myInterestsList.add("Cooking");
    }
    public List<String> getMyInterestsList() {
        return myInterestsList;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean likesFootball() {
        return likesFootball;
    }

    public void setLikesFootball(boolean likesFootball) {
        if(!likesFootball){
            myInterestsList.remove("Football");
        }

        this.likesFootball = likesFootball;
    }

    public boolean likesCinema() {
        return likesCinema;
    }

    public void setLikesCinema(boolean likesCinema) {
        if(!likesCinema){
            myInterestsList.remove("Cinema");
        }

        this.likesCinema = likesCinema;
    }

    public boolean likesDomino() {
        return likesDomino;
    }

    public void setLikesDomino(boolean likesDomino) {
        if(!likesDomino){
            myInterestsList.remove("Domino");
        }

        this.likesDomino = likesDomino;
    }

    public boolean likesCrochet() {
        return likesCrochet;
    }

    public void setLikesCrochet(boolean likesCrochet) {
        if(!likesCrochet){
            myInterestsList.remove("Crochet");
        }

        this.likesCrochet = likesCrochet;
    }

    public boolean likesCooking() {
        return likesCooking;
    }

    public void setLikesCooking(boolean likesCooking) {
        if(!likesCooking){
            myInterestsList.remove("Cooking");
        }

        this.likesCooking = likesCooking;
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}


