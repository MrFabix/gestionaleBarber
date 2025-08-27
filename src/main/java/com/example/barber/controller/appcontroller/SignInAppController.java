package com.example.barber.controller.appcontroller;

import com.example.barber.model.BarberModel;
import com.example.barber.model.CredentialsModel;
import com.example.barber.model.ClientModel;
import com.example.barber.utils.bean.BarberBean;
import com.example.barber.utils.bean.ClientBean;
import com.example.barber.utils.bean.CredentialsBean;
import com.example.barber.utils.dao.sql.BarberDAO;
import com.example.barber.utils.dao.sql.ClientDAOSql;
import com.example.barber.utils.exception.myexception.SystemException;

public class SignInAppController {

    public void registerUser(ClientBean clientBean, CredentialsBean credentialsBean) throws SystemException {
       CredentialsModel credentialsModel = new CredentialsModel(credentialsBean);
       ClientModel clientModel = new ClientModel(clientBean);
       ClientDAOSql userDAOSql = new ClientDAOSql();
       userDAOSql.addUser(credentialsModel, clientModel);
    }



    public void registerBarber(BarberBean barberBean, CredentialsBean credentialsBean) throws SystemException {
        System.out.println("Stai dentro il register barber");
        CredentialsModel credentialsModel = new CredentialsModel(credentialsBean);
        BarberModel barberModel = new BarberModel(barberBean);
        BarberDAO barberDAO = new BarberDAO();
        barberDAO.addBarber(credentialsModel, barberModel);
    }

}
