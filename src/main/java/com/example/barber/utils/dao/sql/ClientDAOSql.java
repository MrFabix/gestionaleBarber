package com.example.barber.utils.dao.sql;

import com.example.barber.model.CredentialsModel;
import com.example.barber.model.ClientModel;
import com.example.barber.utils.dao.ClientDao;
import com.example.barber.utils.db.Query;
import com.example.barber.utils.exception.myexception.SystemException;

public class ClientDAOSql implements ClientDao {
    Query query = new Query();
    @Override
    public ClientModel getUserByUsername(String username) throws SystemException {
        return query.searchUserByUsername(username);
    }
    @Override
    public boolean checkUsername(String username) throws SystemException {
        return query.checkUsernameAlreadyTaken();
    }
    @Override
    public void addUser(CredentialsModel credentialModel, ClientModel clientModel) throws SystemException {
        query.insertCredentials(credentialModel);
        query.insertUser(clientModel);
    }
}
