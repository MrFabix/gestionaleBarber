package com.example.barber.utils.bean;

import com.example.barber.model.ClientModel;

public class UserBean extends ProfileBean{



    protected String surname;
    protected String gender;



    public UserBean(){}

    public UserBean(ClientModel clientModel) {
        this.name = clientModel.getName();
        this.surname = clientModel.getSurname();
        this.gender = clientModel.getGender();
        this.id = clientModel.getId();
        this.email = clientModel.getEmail();
        this.username = clientModel.getUsername();
        this.phone = clientModel.getPhone();
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
