package com.example.barber.utils.bean;


public class ClientBean extends ProfileBean{



    protected String surname;
    protected String gender;


    public ClientBean(){
        //Costruttore
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
