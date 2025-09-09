package com.example.barber.utils.engineering;

import com.example.barber.utils.bean.UsernameBean;
import com.example.barber.utils.dao.ClientDao;
import com.example.barber.utils.exception.myexception.SystemException;
import com.example.barber.utils.factory.daofactory.DaoFactory;
import com.example.barber.utils.managermode.ModeManager;

public class RegistrationEngineering {
    public boolean usernameAlreadyTaken(UsernameBean username) throws SystemException {
        DaoFactory daoFactory = DaoFactory.getFactory(ModeManager.get());
        ClientDao clientDao = daoFactory.clientDao();
        return clientDao.checkUsername(username.getUsername());
    }
}
