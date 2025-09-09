package com.example.barber.utils;

import com.example.barber.model.CredentialsModel;
import com.example.barber.model.ModeratorModel;
import com.example.barber.model.BarberModel;
import com.example.barber.model.ClientModel;
import com.example.barber.utils.bean.BarberBean;
import com.example.barber.utils.bean.*;
import com.example.barber.utils.exception.myexception.*;
import com.example.barber.utils.setterandgetter.SetterClass;

public class Session {



    private SetterClass setterClass = new SetterClass();
    private static Session session;
    private CredentialsBean credentialsBean;
    private ClientBean clientBean = new ClientBean();
    private ModeratorBean moderatorBean = new ModeratorBean();
    private BarberBean barberBean = new BarberBean();

    private Session(){

    }


    public static synchronized Session getInstance(){
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

    public void setCredentials(CredentialsModel credentialsModel) throws EmptyInputException{
        if(this.credentialsBean == null){
            this.credentialsBean = new CredentialsBean();
        }
        setterClass.setCredentialsBeanFromCredentialsModel(this.credentialsBean, credentialsModel);
    }

    public void setUser(ClientModel clientModel) throws EmptyInputException, UsernameAlreadyTakenException, EmailNotValidException, SystemException  {
        if (this.clientBean == null) {
            this.clientBean = new ClientBean();
        }
        setterClass.setClientBeanFromModel(this.clientBean, clientModel);
    }

    public void setBarber(BarberModel barberModel) throws EmptyInputException, UsernameAlreadyTakenException, EmailNotValidException, SystemException{
        if (this.barberBean == null) {
            this.barberBean = new BarberBean();
        }
        setterClass.setBarberBeanFromModel(this.barberBean, barberModel);
    }

    public void setModerator(ModeratorModel moderatorModel) {
        if (this.moderatorBean == null) {
            moderatorBean = new ModeratorBean(moderatorModel);
        }
    }

    public void deleteSession() {
        clientBean = null;
    }











}
