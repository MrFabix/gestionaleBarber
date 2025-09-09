package com.example.barber.model;

import com.example.barber.utils.enumeration.ruoli.Role;

public class CredentialsModel {
    private String username;
    private String password;
    private Role type;





    public  void setPassword(String password){this.password =password; }
    public void setUsername(String username) {
        this.username = username;
    }
    public void setType(Role type) {this.type = type;}

    public String getUsername() {
        return this.username;
    }
    public  String getPassword(){return this.password;}
    public Role getType() {
        return this.type;
    }

}
