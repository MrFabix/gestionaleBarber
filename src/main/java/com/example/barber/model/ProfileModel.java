package com.example.barber.model;
import java.io.File;
public abstract class ProfileModel {
    /*
        Questo è il Model del profilo, cioè contiene le informazioni IN COMUNE per gli Users
        e i Barber
     */

protected int id ;
protected String email;
protected String phone;
protected String username;
protected File profileImg;
protected String name; //Nome dell utente oppure nome del BarberShop
protected ProfileModel() {}


protected ProfileModel(String username) {
this.username = username;
}

protected ProfileModel(int id, String username, String email,  File profileImg, String name, String phone) {
this.username = username;
this.email = email;
this.id = id;
this.profileImg = profileImg;
this.name = name;
this.phone = phone;
}

    //Getter
    public int getId() { return id; }

    public File getProfileImg() {
        return profileImg;
    }

    public String getUsername() {
        return username;
    }

    public String getPhone() {return phone;}

    public String getName() {return name;}

    public String getEmail() { return email; }


    //Setter
    public void setProfileImg(File profileImg) {
    this.profileImg = profileImg;
    }

    public void setEmail(String email) {
    this.email = email;
    }

    public void setUsername(String username) {
    this.username = username;
    }

    public void setName(String name) { this.name = name; }

    public void setPhone(String telephone) { this.phone = telephone; }

    public void setId(int id) { this.id = id; }
}

