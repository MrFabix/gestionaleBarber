package com.example.barber.utils.dao;

import com.example.barber.utils.db.Query;
import com.example.barber.utils.exception.myexception.SystemException;
import com.example.barber.model.CredentialsModel;
import com.example.barber.utils.ruoli.Role;


public class LoginDAO {
    Query query = new Query();
    /*public boolean checkIsRegistered(CredentialsModel credentialsModel) throws SystemException {
        System.out.println("LoginDAO.checkIsRegistered");
        return query.searchUserInLogged(credentialsModel);
    }*/

    public Role getRole(CredentialsModel credentialsModel) throws SystemException {
        System.out.println("Restituisci Il ruolo di quell'utente");
        return query.getRoleByUsername(credentialsModel.getUsername(), credentialsModel.getPassword());
    }
}
