package com.example.barber.controller.appcontroller;

import com.example.barber.model.BarberModel;
import com.example.barber.model.CredentialsModel;
import com.example.barber.model.ClientModel;
import com.example.barber.utils.bean.BarberBean;
import com.example.barber.utils.bean.ClientBean;
import com.example.barber.utils.bean.CredentialsBean;
import com.example.barber.utils.dao.sql.BarberDAO;
import com.example.barber.utils.dao.sql.ClientDAOSql;
import com.example.barber.utils.exception.myexception.*;
import com.example.barber.utils.setterandgetter.SetterClass;

public class SignInAppController {

    private SetterClass setterClass = new SetterClass();


    public void registerUser(ClientBean clientBean, CredentialsBean credentialsBean) throws SystemException {
        CredentialsModel credentialsModel = new CredentialsModel();
        setterClass.setCredentialsModelFromCredentialsBean(credentialsModel, credentialsBean);
        ClientModel clientModel = new ClientModel();
        setterClass.setClientModelFromClientBean(clientBean,clientModel);
        ClientDAOSql userDAOSql = new ClientDAOSql();
        userDAOSql.addUser(credentialsModel, clientModel);
    }



    public void registerBarber(BarberBean barberBean, CredentialsBean credentialsBean) throws SystemException{
        CredentialsModel credentialsModel = new CredentialsModel();
        setterClass.setCredentialsModelFromCredentialsBean(credentialsModel, credentialsBean);
        BarberModel barberModel = new BarberModel();
        setterClass.setBarberModelFromBarberBean(barberModel, barberBean);
        BarberDAO barberDAO = new BarberDAO();
        barberDAO.addBarber(credentialsModel, barberModel);
    }

}
