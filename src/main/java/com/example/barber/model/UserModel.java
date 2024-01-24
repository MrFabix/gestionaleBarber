package com.example.barber.model;

import com.example.barber.utlis.bean.UserBean;

import java.io.File;

public class UserModel extends ProfileModel {

private String name;
private String surname;
private String gender;
private File img;
private String address;
public UserModel(){
    super();
}

public UserModel(UserBean userbean){
    super(userbean.getUsername(), userbean.getEmail(), userbean.getId(), userbean.getImg());
    this.name = userbean.getName();
    this.surname = userbean.getSurname();

}



}
