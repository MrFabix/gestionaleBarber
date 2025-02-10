package com.example.barber.utils.dao;

import com.example.barber.utils.db.Query;
import com.example.barber.utils.exception.myexception.SystemException;
import com.example.barber.model.CredentialsModel;


public class LoginDAO {
    Query query = new Query();
    public boolean checkIsRegistered(CredentialsModel credentialsModel) throws SystemException {
        System.out.println("LoginDAO.checkIsRegistered");
        return query.searchUserInLogged(credentialsModel);
    }
}
