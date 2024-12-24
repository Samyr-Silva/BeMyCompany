package org.app.company.model;

import java.util.ArrayList;
import java.util.List;

public class Beneficiary {

    private Integer id;
    private String firstName;
    private String lastName;
    private String image;
    private Integer age;
    private String password;
    private Integer phone;
    private String email;
    private String location;

    private List<String> myInterestsList = new ArrayList<>();

    //--------------------INTERESTS------------------------

    private boolean likesFootball;
    private boolean likesCinema;

    private boolean likesDomino;
    private boolean likesCrochet;
    private boolean likesCooking;

    // ----------------------------METHODS--------------------------------------
    public List<String> getMyInterestsList() {
        return myInterestsList;
    }

    public void populateMyInterestsList() {
        myInterestsList.add("Cinema");
        myInterestsList.add("Football");
        myInterestsList.add("Domino");
        myInterestsList.add("Crochet");
        myInterestsList.add("Cooking");
    }

    public Beneficiary() {
        populateMyInterestsList();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public Integer getPhone() {
        return phone;
    }

    public void setPhone(Integer phone) {
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
        this.likesFootball = likesFootball;
        if(!likesFootball){
            myInterestsList.remove("Football");
        }
    }

    public boolean likesCinema() {
        return likesCinema;
    }

    public void setLikesCinema(boolean likesCinema) {
        this.likesCinema = likesCinema;
        if(!likesCinema){
            myInterestsList.remove("Cinema");
        }
    }

    public boolean likesDomino() {
        return likesDomino;
    }

    public void setLikesDomino(boolean likesDomino) {
        this.likesDomino = likesDomino;
        if (!likesDomino) {
            myInterestsList.remove("Domino");
        }
    }

    public boolean likesCrochet() {
        return likesCrochet;
    }

    public void setLikesCrochet(boolean likesCrochet) {
        this.likesCrochet = likesCrochet;
        if (!likesCrochet) {
            myInterestsList.remove("Crochet");
        }
    }

    public boolean likesCooking() {
        return likesCooking;
    }

    public void setLikesCooking(boolean likesCooking) {
        this.likesCooking = likesCooking;
        if(!likesCooking){
            myInterestsList.remove("Cooking");
        }
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
