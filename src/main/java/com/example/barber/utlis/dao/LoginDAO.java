package com.example.barber.utlis.dao;

import com.example.barber.utlis.db.Query;
import com.example.barber.utlis.exception.myecxeption.SystemException;
import com.example.barber.model.CredentialsModel;


public class LoginDAO {
Query query = new Query();
    public boolean checkIsRegistered(CredentialsModel credentialsModel) throws SystemException {
        return query.searchUserInLogged(credentialsModel);
    }
}
