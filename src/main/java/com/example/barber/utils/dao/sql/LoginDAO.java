package com.example.barber.utils.dao.sql;

import com.example.barber.utils.db.Query;
import com.example.barber.utils.exception.myexception.SystemException;
import com.example.barber.model.CredentialsModel;
import com.example.barber.utils.ruoli.Role;


public class LoginDAO {
    Query query = new Query();

    public Role getRole(CredentialsModel credentialsModel) throws SystemException {
        return query.getRoleByUsername(credentialsModel.getUsername(), credentialsModel.getPassword());
    }
}
