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

    //TODO implementare switch tra le pagine
    public void login(CredentialsBean credenialBeans) throws WrongCredentialsException, SystemException {

        LoginDAO loginDAO = new LoginDAO();

        if (credenialBeans.getType().equalsIgnoreCase("user")) {
            //creo il modello per l'utente
            UserModel userModel = null;
            //creo il modello per le credenziali
            CredentialsModel credentialsModel = new CredentialsModel(credenialBeans);
            //controllo se le credenziali sono registrate
            if (loginDAO.checkIsRegistered(credentialsModel)) {
                System.out.println("Utente registrato");
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
        //in base al tipo di utente ritorno la pagina corrispondente
        if (credenialBeans.getType().equalsIgnoreCase("user")) {
            //ritorno la pagina dell'utente
            System.out.println("Utente");
        } else {
            //ritorno la pagina del barbiere
            System.out.println("Barbiere");
        }



    }
}
