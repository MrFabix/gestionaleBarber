package com.example.barber.controller.appcontroller;

import com.example.barber.model.BarberModel;
import com.example.barber.model.CredentialsModel;
import com.example.barber.model.ClientModel;
import com.example.barber.utils.bean.BarberBean;
import com.example.barber.utils.bean.ClientBean;
import com.example.barber.utils.bean.CredentialsBean;
import com.example.barber.utils.dao.BarberDao;
import com.example.barber.utils.dao.ClientDao;
import com.example.barber.utils.exception.myexception.*;
import com.example.barber.utils.factory.daofactory.DaoFactory;
import com.example.barber.utils.managermode.ModeManager;
import com.example.barber.utils.setterandgetter.SetterClass;

public class SignInAppController {

    private SetterClass setterClass = new SetterClass();


    public void registerUser(ClientBean clientBean, CredentialsBean credentialsBean) throws SystemException {
        CredentialsModel credentialsModel = new CredentialsModel();
        setterClass.setCredentialsModelFromCredentialsBean(credentialsModel, credentialsBean);
        ClientModel clientModel = new ClientModel();
        setterClass.setClientModelFromClientBean(clientBean,clientModel);
        DaoFactory daoFactory = DaoFactory.getFactory(ModeManager.get());
        ClientDao clientDao = daoFactory.clientDao();
        clientDao.addUser(credentialsModel, clientModel);
    }



    public void registerBarber(BarberBean barberBean, CredentialsBean credentialsBean) throws SystemException{
        CredentialsModel credentialsModel = new CredentialsModel();
        setterClass.setCredentialsModelFromCredentialsBean(credentialsModel, credentialsBean);
        BarberModel barberModel = new BarberModel();
        setterClass.setBarberModelFromBarberBean(barberModel, barberBean);

        DaoFactory daoFactory = DaoFactory.getFactory(ModeManager.get());
        BarberDao barberDao = daoFactory.barberDao();
        barberDao.addBarber(credentialsModel, barberModel);
    }



}
