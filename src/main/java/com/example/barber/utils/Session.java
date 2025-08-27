package com.example.barber.utils;

import com.example.barber.model.CredentialsModel;
import com.example.barber.model.ModeratorModel;
import com.example.barber.model.BarberModel;
import com.example.barber.model.ClientModel;
import com.example.barber.utils.bean.BarberBean;
import com.example.barber.utils.bean.*;

public class Session {




    private static Session session;
    private CredentialsBean credentialsBean;
    private ClientBean clientBean;
    private ModeratorBean moderatorBean;
    private BarberBean barberBean;

    public static Session getInstance(){
        if (session == null){
            session = new Session();
        }
        return session;
    }
    public ClientBean getUser() {
        return clientBean;
    }

    public BarberBean getBarber() {
        return barberBean;
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
    public void setUser(ClientModel clientModel) {
        if (this.clientBean == null) {
            clientBean = new ClientBean(clientModel);
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
        clientBean = null;
    }











}
