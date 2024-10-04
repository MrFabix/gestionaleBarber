package com.example.barber.model;
import java.io.File;
public abstract class ProfileModel {
    /*
        Questo è il Model del profilo, cioè contiene le informazioni IN COMUNE per gli Users
        e i Barber
     */

protected int id ;
protected String email;
protected String username;
protected File profileImg;
protected String name; //Nome dell utente oppure nome del BarberShop
protected ProfileModel() {

}
public String getEmail() {
return email;
}

protected ProfileModel(String username) {
this.username = username;
}

protected ProfileModel(String username, String email, int id, File profileImg, String name) {
this.username = username;
this.email = email;
this.id = id;
this.profileImg = profileImg;
this.name = name;
}

public int getId() {
return id;
}

public void setId(int id) {
this.id = id;
}

public File getProfileImg() {
return profileImg;
}

public void setProfileImg(File profileImg) {
this.profileImg = profileImg;
}

public void setEmail(String email) {
this.email = email;
}

public String getUsername() {
return username;
}

public void setUsername(String username) {
this.username = username;
}
public String getName() {return name;}

public void setName(String name) {this.name = name;}
}

