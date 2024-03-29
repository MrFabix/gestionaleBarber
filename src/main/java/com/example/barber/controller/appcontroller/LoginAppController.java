package com.example.barber.controller.appcontroller;

import com.example.barber.model.BarberModel;
import com.example.barber.model.CredentialsModel;
import com.example.barber.model.UserModel;
import com.example.barber.utils.bean.CredentialsBean;
import com.example.barber.utils.dao.BarberDAO;
import com.example.barber.utils.dao.UserDAO;
import com.example.barber.utils.exception.Trigger;
import com.example.barber.utils.exception.myecxeption.SystemException;
import com.example.barber.utils.exception.myecxeption.WrongCredentialsException;
import com.example.barber.utils.dao.LoginDAO;
import com.example.barber.utils.Session;
public class LoginAppController {

    Trigger trigger = new Trigger();

    public void login(CredentialsBean credenialBeans) throws WrongCredentialsException, SystemException {

        LoginDAO loginDAO = new LoginDAO();

        if (credenialBeans.getType().equalsIgnoreCase("user")) {
            UserModel userModel = null;
            CredentialsModel credentialsModel = new CredentialsModel(credenialBeans);
            if (loginDAO.checkIsRegistered(credentialsModel)) {
                UserDAO userDAO = new UserDAO();
                userModel = userDAO.getUserByUsername(credenialBeans.getUsername());
                Session.getInstance().setUser(userModel);
            } else {
                trigger.throwWrongCredentials();
                Session.getInstance().deleteSession();
            }
        } else {

            BarberModel barberModel = null;
            CredentialsModel credentialsModel = new CredentialsModel(credenialBeans);

            if (loginDAO.checkIsRegistered(credentialsModel)) {
                BarberDAO barberDAO = new BarberDAO();
                barberModel = barberDAO.getBarberByUsername(credenialBeans.getUsername());
                Session.getInstance().setBarber(barberModel);

            } else {
                trigger.throwWrongCredentials();
                Session.getInstance().deleteSession();
            }
        }
    }
}
