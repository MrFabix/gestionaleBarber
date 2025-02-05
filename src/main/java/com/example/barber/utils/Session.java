package com.example.barber.utils;

import com.example.barber.model.AdminModel;
import com.example.barber.model.BarberModel;
import com.example.barber.model.UserModel;
import com.example.barber.utils.bean.BarberBean;
import com.example.barber.utils.bean.*;

public class Session {

    //TODO modificare da Admin a moderatore il nome del super utente a de angelis non piace
    //dichiarazione tipi di ruoli
    private static final String TYPE_USER= "User";
    private static final String TYPE_ADMIN= "Admin";
    private static final String TYPE_BARBER= "Barbers";


    private static Session session;
    private UserBean userBean;
    private AdminBean adminBean;
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

        public void setAdmin(AdminModel adminModel) {
            if (this.adminBean == null) {
                adminBean = new AdminBean(adminModel);
                type = TYPE_ADMIN;
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
