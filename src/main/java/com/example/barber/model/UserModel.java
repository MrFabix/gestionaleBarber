package com.example.barber.model;

import com.example.barber.utils.bean.UserBean;

import java.io.File;

public class UserModel extends ProfileModel {

private String surname;
private String gender;

public UserModel(){
    super();
}

public UserModel(UserBean userbean){
    super(userbean.getUsername(), userbean.getEmail(), userbean.getId(), userbean.getImg(), userbean.getName());
    this.surname = userbean.getSurname();
    this.gender = userbean.getGender();
}

public void setSurname(String surname) { this.surname = surname; }
public void setGender(String gender) {this.gender=gender; }

public String getSurname() { return surname;}
public String getGender() { return gender; }


}
