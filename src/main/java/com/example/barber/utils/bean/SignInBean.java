package com.example.barber.utils.bean;

import com.example.barber.utils.exception.Trigger;

public class SignInBean implements GenericBean{

    private Trigger trigger = new Trigger();

    //TODO implementare controlli sintattici all'interno del bean
    protected String username;
    protected String password;
    protected String repeatPassword;
    protected String eMail;
    protected String repeatEmail;
    protected String ruolo;


    public SignInBean(){
    }

    public SignInBean(String username, String password, String eMail, String ruolo){
        this.username = username;
        this.password = password;
        this.eMail = eMail;
        this.ruolo = ruolo;

    }

    public String getUsername(){
        return username;
    }
    public String getPassword(){
        return password;
    }
    public String getEmail(){
        return eMail;
    }
    public String getRuolo(){
        return ruolo;
    }



    public void setUsername(String username){
        this.username = username;
    }
    public void setPassword(String password){
        this.password = password;
    }

    public void setEmail(String eMail){
        this.eMail = eMail;
    }
    public void setRuolo(String ruolo){
        this.ruolo = ruolo;
    }
}
