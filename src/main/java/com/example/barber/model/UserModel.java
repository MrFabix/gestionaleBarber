package com.example.barber.model;

import com.example.barber.utils.bean.UserBean;


public class UserModel extends ProfileModel {




    private String surname;
    private String gender;

    public UserModel(){
        super();
    }

    public UserModel(UserBean userbean){
        super(userbean.getId(), userbean.getUsername(), userbean.getEmail(), userbean.getImg(), userbean.getName(), userbean.getPhone());

        this.surname = userbean.getSurname();
        this.gender = userbean.getGender();
        this.name = userbean.getName();
        //TODO manca immagine del profilo da vedere se farla, manca nel bean, nel guiController e qui :)
    }


    //Setter
    public void setSurname(String surname) { this.surname = surname; }
    public void setGender(String gender) {this.gender=gender; }

    //TODO public void setImgProfile(FILE imgProf) {this.imgProf = imgProf;}
    //Getter


    public String getSurname() { return surname;}
    public String getGender() { return gender; }
    //TODO FILE getImgProfile(){ return imgProf; }

    }
