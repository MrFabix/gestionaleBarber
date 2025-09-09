package com.example.barber.controller.appcontroller;

import com.example.barber.model.BarberModel;
import com.example.barber.model.CredentialsModel;
import com.example.barber.model.ModeratorModel;
import com.example.barber.model.ClientModel;
import com.example.barber.utils.bean.CredentialsBean;
import com.example.barber.utils.dao.BarberDao;
import com.example.barber.utils.dao.ClientDao;
import com.example.barber.utils.dao.LoginDao;
import com.example.barber.utils.dao.sql.BarberDaoSql;
import com.example.barber.utils.dao.sql.ModeratorDAO;
import com.example.barber.utils.exception.myexception.*;
import com.example.barber.utils.Session;
import com.example.barber.utils.factory.daofactory.DaoFactory;
import com.example.barber.utils.managermode.ModeManager;
import com.example.barber.utils.setterandgetter.SetterClass;

public class LoginAppController {

    SetterClass setterClass = new SetterClass();

    public void login(CredentialsBean credentialsBean) throws EmptyInputException, UsernameAlreadyTakenException, EmailNotValidException, SystemException, WrongCredentialsException{
        CredentialsModel credentialsModel = new CredentialsModel();
        setterClass.setCredentialsModelFromCredentialsBean(credentialsModel, credentialsBean);


        DaoFactory daoFactory = DaoFactory.getFactory(ModeManager.get());
        LoginDao loginDao = daoFactory.loginDao();

        credentialsModel.setType(loginDao.getRole(credentialsModel));
        credentialsBean.setType(credentialsModel.getType());
        if(credentialsModel.getType() == null){
            throw new WrongCredentialsException();
        }else if (credentialsModel.getType().getRoleId().equals("CLIENTE")) {
            ClientModel clientModel = null;
            ClientDao clientDao = daoFactory.clientDao();
            clientModel = clientDao.getUserByUsername(credentialsBean.getUsername());
            Session.getInstance().setCredentials(credentialsModel);
            Session.getInstance().setUser(clientModel);
        } else if (credentialsModel.getType().getRoleId().equals("BARBIERE")) {
            BarberModel barberModel = null;
            BarberDao barberDao = daoFactory.barberDao();
            barberModel = barberDao.getBarberByUsername(credentialsBean.getUsername());
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



