package com.example.barber.controller.appcontroller;

import com.example.barber.model.BarberModel;
import com.example.barber.model.CredentialsModel;
import com.example.barber.model.ModeratorModel;
import com.example.barber.model.ClientModel;
import com.example.barber.utils.bean.CredentialsBean;
import com.example.barber.utils.dao.sql.BarberDAO;
import com.example.barber.utils.dao.sql.ModeratorDAO;
import com.example.barber.utils.dao.sql.ClientDAOSql;
import com.example.barber.utils.exception.Trigger;
import com.example.barber.utils.exception.myexception.SystemException;
import com.example.barber.utils.exception.myexception.WrongCredentialsException;
import com.example.barber.utils.dao.sql.LoginDAO;
import com.example.barber.utils.Session;

public class LoginAppController {

    Trigger trigger = new Trigger();

    public void login(CredentialsBean credentialsBean) throws WrongCredentialsException, SystemException {

        CredentialsModel credentialsModel = new CredentialsModel(credentialsBean);
        LoginDAO loginDAO = new LoginDAO();
        credentialsModel.setType(loginDAO.getRole(credentialsModel));
        credentialsBean.setType(credentialsModel.getType());
        if(credentialsModel.getType() == null){
            trigger.throwWrongCredentials();
            Session.getInstance().deleteSession();
        }else if (credentialsModel.getType().getRoleId().equals("CLIENTE")) {
            System.out.println("SEI DENTRO LOGINAPPCONTROLLER DEL CLIENTE PRIMA DI USERMODEL");
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



