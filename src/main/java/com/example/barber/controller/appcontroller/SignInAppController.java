package com.example.barber.controller.appcontroller;

import com.example.barber.model.BarberModel;
import com.example.barber.model.CredentialsModel;
import com.example.barber.model.UserModel;
import com.example.barber.utils.bean.BarberBean;
import com.example.barber.utils.bean.CredentialsBean;
import com.example.barber.utils.bean.UserBean;
import com.example.barber.utils.dao.BarberDAO;
import com.example.barber.utils.dao.UserDAO;
import com.example.barber.utils.exception.myexception.SystemException;

public class SignInAppController {

    public void registerUser(UserBean userBean, CredentialsBean credentialsBean) throws SystemException {
       CredentialsModel credentialsModel = new CredentialsModel(credentialsBean);
       UserModel userModel = new UserModel(userBean);
       UserDAO userDAO = new UserDAO();
       userDAO.addUser(credentialsModel, userModel);
    }

    public void registerBarber(BarberBean barberBean, CredentialsBean credentialsBean) throws SystemException {
        System.out.println("Stai dentro il register barber");
        CredentialsModel credentialsModel = new CredentialsModel(credentialsBean);
        BarberModel barberModel = new BarberModel(barberBean);
        BarberDAO barberDAO = new BarberDAO();
        barberDAO.addBarber(credentialsModel, barberModel);
    }

}
