package com.example.barber.utils;

import com.example.barber.model.BarberModel;
import com.example.barber.model.UserModel;
import com.example.barber.utils.bean.BarberBean;
import com.example.barber.utils.bean.*;

public class Session {
    //dichiarazione tipi di ruoli
    private static final String TYPE_USER= "User";
    private static final String TYPE_ADMIN= "Admin";
    private static final String TYPE_BARBER= "Barbers";

    private Session(){};

    private static Session session;
    private UserBean userBean;


    private BarberBean barberBean;
    private String type;


    public static Session getInstance(){
        if (session == null){
            session = new Session();
        }
        return session;
    }
    public UserBean getUser() {
        return userBean;
    }
    /*public BarberBean getBarber() {
        return barberBean;
    }*/

    public void setUser(UserModel userModel) {
        if (this.userBean == null) {
            userBean = new UserBean(userModel);
            type = TYPE_USER;
        }
    }

    public void setBarber(BarberModel barberModel) {
        if (this.barberBean == null) {
            barberBean = new BarberBean(barberModel);
            type = TYPE_BARBER;
        }
    }





    public void deleteSession() {
        //barberBean = null;
        userBean = null;
        type = "";
    }

    public String checkInstanceType() {
        return type;
    }










}
