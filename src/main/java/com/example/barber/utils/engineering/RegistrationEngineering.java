package com.example.barber.utils.engineering;

import com.example.barber.utils.bean.UsernameBean;
import com.example.barber.utils.dao.sql.ClientDAOSql;
import com.example.barber.utils.exception.myexception.SystemException;

public class RegistrationEngineering {
    public boolean usernameAlreadyTaken(UsernameBean username) throws SystemException {
        ClientDAOSql userDAOSql = new ClientDAOSql();
        return userDAOSql.checkUsername(username.getUsername());
    }
}
