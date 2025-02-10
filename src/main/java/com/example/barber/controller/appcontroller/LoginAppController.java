package com.example.barber.controller.appcontroller;

import com.example.barber.model.BarberModel;
import com.example.barber.model.CredentialsModel;
import com.example.barber.model.ModeratorModel;
import com.example.barber.model.UserModel;
import com.example.barber.utils.bean.CredentialsBean;
import com.example.barber.utils.dao.BarberDAO;
import com.example.barber.utils.dao.ModeratorDAO;
import com.example.barber.utils.dao.UserDAO;
import com.example.barber.utils.exception.Trigger;
import com.example.barber.utils.exception.myexception.SystemException;
import com.example.barber.utils.exception.myexception.WrongCredentialsException;
import com.example.barber.utils.dao.LoginDAO;
import com.example.barber.utils.Session;
import com.example.barber.utils.switchPage.SwitchPage;

public class LoginAppController {

    Trigger trigger = new Trigger();
     SwitchPage sp = new SwitchPage();



    public void login(CredentialsBean credenialBeans) throws WrongCredentialsException, SystemException {

        LoginDAO loginDAO = new LoginDAO();


        if (credenialBeans.getType().equalsIgnoreCase("user")) {
            //creo il modello per l'utente
            UserModel userModel = null;
            //creo il modello per le credenziali
            CredentialsModel credentialsModel = new CredentialsModel(credenialBeans);
            //controllo se le credenziali sono registrate
            if (loginDAO.checkIsRegistered(credentialsModel)) {
                UserDAO userDAO = new UserDAO();
                userModel = userDAO.getUserByUsername(credenialBeans.getUsername());
                Session.getInstance().setUser(userModel);
            } else {
                trigger.throwWrongCredentials();
                Session.getInstance().deleteSession();
            }
        } else if(credenialBeans.getType().equalsIgnoreCase("barber")) {

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
        }else if (credenialBeans.getType().equalsIgnoreCase("moderator")) {
            System.out.println("Moderator");
            ModeratorModel moderatorModel = null;
            CredentialsModel credentialsModel = new CredentialsModel(credenialBeans);
            if (loginDAO.checkIsRegistered(credentialsModel)) {
                ModeratorDAO moderatorDAO = new ModeratorDAO();
                moderatorModel = moderatorDAO.searchModeratorByUsername(credenialBeans.getUsername());
                Session.getInstance().setModerator(moderatorModel);
            } else {
                trigger.throwWrongCredentials();
                Session.getInstance().deleteSession();
            }



        }



    }
}
