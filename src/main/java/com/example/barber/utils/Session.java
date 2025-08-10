package com.example.barber.utils;

import com.example.barber.model.CredentialsModel;
import com.example.barber.model.ModeratorModel;
import com.example.barber.model.BarberModel;
import com.example.barber.model.UserModel;
import com.example.barber.utils.bean.BarberBean;
import com.example.barber.utils.bean.*;
import com.example.barber.utils.exception.myexception.PasswordNotCompliantException;
import com.example.barber.utils.ruoli.Role;

public class Session {




    private static Session session;
    private CredentialsBean credentialsBean;
    private UserBean userBean;
    private ModeratorBean moderatorBean;
    private BarberBean barberBean;

    public static Session getInstance(){
        if (session == null){
            session = new Session();
        }
        return session;
    }
    public UserBean getUser() {
        return userBean;
    }


    public CredentialsBean getCredentials() {
        return credentialsBean;
    }

    public void setCredentials(CredentialsModel credentialsModel) {
        try{
            credentialsBean = new CredentialsBean(credentialsModel);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    public void setUser(UserModel userModel) {
        if (this.userBean == null) {
            userBean = new UserBean(userModel);
        }
    }

    public void setBarber(BarberModel barberModel) {
        if (this.barberBean == null) {
            barberBean = new BarberBean(barberModel);
        }
    }

    public void setModerator(ModeratorModel moderatorModel) {
        if (this.moderatorBean == null) {
            moderatorBean = new ModeratorBean(moderatorModel);
        }
    }

    public void deleteSession() {
        //barberBean = null;
        userBean = null;
    }











}
