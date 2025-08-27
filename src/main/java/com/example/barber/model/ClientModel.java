package com.example.barber.model;

import com.example.barber.utils.bean.UserBean;


public class ClientModel extends ProfileModel {
    private String surname;
    private String gender;

    public ClientModel(){
        super();
    }

    public ClientModel(UserBean userbean){
        super(userbean.getId(), userbean.getUsername(), userbean.getEmail(), userbean.getImg(), userbean.getName(), userbean.getPhone());

        this.surname = userbean.getSurname();
        this.gender = userbean.getGender();
        this.name = userbean.getName();
    }


    //Setter
    public void setSurname(String surname) { this.surname = surname; }
    public void setGender(String gender) {this.gender=gender; }




    public String getSurname() { return surname;}
    public String getGender() { return gender; }

    }
