package com.example.barber.utils.bean;

import com.example.barber.model.ClientModel;

public class ClientBean extends ProfileBean{



    protected String surname;
    protected String gender;



    public ClientBean(){}

    public ClientBean(ClientModel clientModel) {
        this.name = clientModel.getName();
        this.surname = clientModel.getSurname();
        this.gender = clientModel.getGender();
        this.id = clientModel.getId();
        this.email = clientModel.getEmail();
        this.username = clientModel.getUsername();
        this.phone = clientModel.getPhone();
    }

    public ClientBean(ClientBean clientBean) {
        this.name = clientBean.getName();
        this.surname = clientBean.getSurname();
        this.gender = clientBean.getGender();
        this.id = clientBean.getId();
        this.email = clientBean.getEmail();
        this.username = clientBean.getUsername();
        this.phone = clientBean.getPhone();

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
        return "ClientBean{" +
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
