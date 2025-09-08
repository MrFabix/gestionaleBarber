package com.example.barber.model;

public class ClientModel extends ProfileModel {
    private String surname;
    private String gender;

    public ClientModel(){
        super();
    }



    //Setter
    public void setSurname(String surname) { this.surname = surname; }
    public void setGender(String gender) {this.gender=gender; }




    public String getSurname() { return surname;}
    public String getGender() { return gender; }

    }
