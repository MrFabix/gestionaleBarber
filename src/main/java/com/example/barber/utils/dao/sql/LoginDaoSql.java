package com.example.barber.utils.dao.sql;

import com.example.barber.utils.dao.LoginDao;
import com.example.barber.utils.db.Query;
import com.example.barber.utils.exception.myexception.SystemException;
import com.example.barber.utils.exception.myexception.WrongCredentialsException;
import com.example.barber.model.CredentialsModel;
import com.example.barber.utils.enumeration.ruoli.Role;


public class LoginDaoSql implements LoginDao {
    Query query = new Query();

    @Override
    public Role getRole(CredentialsModel credentialsModel) throws SystemException, WrongCredentialsException {
        return query.getRoleByUsername(credentialsModel.getUsername(), credentialsModel.getPassword());
    }
}
