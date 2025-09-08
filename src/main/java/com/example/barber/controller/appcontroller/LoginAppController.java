package com.example.barber.controller.appcontroller;

import com.example.barber.model.BarberModel;
import com.example.barber.model.CredentialsModel;
import com.example.barber.model.ModeratorModel;
import com.example.barber.model.ClientModel;
import com.example.barber.utils.bean.CredentialsBean;
import com.example.barber.utils.dao.sql.BarberDAO;
import com.example.barber.utils.dao.sql.ModeratorDAO;
import com.example.barber.utils.dao.sql.ClientDAOSql;
import com.example.barber.utils.exception.myexception.*;
import com.example.barber.utils.dao.sql.LoginDAO;
import com.example.barber.utils.Session;
import com.example.barber.utils.setterandgetter.SetterClass;

public class LoginAppController {

    SetterClass setterClass = new SetterClass();

    public void login(CredentialsBean credentialsBean) throws EmptyInputException, UsernameAlreadyTakenException, EmailNotValidException, SystemException, WrongCredentialsException,PasswordNotCompliantException{
        CredentialsModel credentialsModel = new CredentialsModel();
        setterClass.setCredentialsModelFromCredentialsBean(credentialsModel, credentialsBean);

        LoginDAO loginDAO = new LoginDAO();
        credentialsModel.setType(loginDAO.getRole(credentialsModel));
        credentialsBean.setType(credentialsModel.getType());
        if(credentialsModel.getType() == null){
            throw new WrongCredentialsException();
        }else if (credentialsModel.getType().getRoleId().equals("CLIENTE")) {
            ClientModel clientModel = null;
            ClientDAOSql userDAOSql = new ClientDAOSql();
            clientModel = userDAOSql.getUserByUsername(credentialsBean.getUsername());
            Session.getInstance().setCredentials(credentialsModel);
            Session.getInstance().setUser(clientModel);
        } else if (credentialsModel.getType().getRoleId().equals("BARBIERE")) {
            BarberModel barberModel = null;
            BarberDAO barberDAO = new BarberDAO();
            barberModel = barberDAO.getBarberByUsername(credentialsBean.getUsername());
            Session.getInstance().setCredentials(credentialsModel);
            Session.getInstance().setBarber(barberModel);
        } else if (credentialsModel.getType().getRoleId().equals("MODERATORE")) {
            ModeratorModel moderatorModel = null;
            ModeratorDAO moderatorDAO = new ModeratorDAO();
            moderatorModel = moderatorDAO.searchModeratorByUsername(credentialsBean.getUsername());
            Session.getInstance().setCredentials(credentialsModel);
            Session.getInstance().setModerator(moderatorModel);
        }
    }
}



