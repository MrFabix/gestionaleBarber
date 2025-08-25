package com.example.barber.utils.bean;

import com.example.barber.model.UserModel;

public class UserBean extends ProfileBean{



    protected String surname;
    protected String gender;



    public UserBean(){}

    public UserBean(UserModel userModel) {
        this.name = userModel.getName();
        this.surname = userModel.getSurname();
        this.gender = userModel.getGender();
        this.id = userModel.getId();
        this.email = userModel.getEmail();
        this.username = userModel.getUsername();
        this.phone = userModel.getPhone();
    }

    public UserBean(UserBean userBean) {
        this.name = userBean.getName();
        this.surname = userBean.getSurname();
        this.gender = userBean.getGender();
        this.id = userBean.getId();
        this.email = userBean.getEmail();
        this.username = userBean.getUsername();
        this.phone = userBean.getPhone();

    }

    //Getter
    public String getSurname() { return surname; }

    public String getGender() { return gender ; }





    //Setter
    public void setSurname(String surname) { this.surname = surname; }

    public void setGender(String gender) { this.gender=gender; }


    //toString
    @Override
    public String toString() {
        return "UserBean{" +
                "surname='" + surname + '\'' +
                ", gender='" + gender + '\'' +
                ", name='" + name + '\'' +
                ", id=" + id +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", username='" + username + '\'' +
                ", img=" + img +
                '}';
    }



}
