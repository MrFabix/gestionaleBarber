package com.example.barber.utils.dao.demo;

import com.example.barber.model.ClientModel;
import com.example.barber.model.CredentialsModel;
import com.example.barber.utils.dao.ClientDao;
import com.example.barber.utils.exception.myexception.SystemException;

public class ClientDaoDemo implements ClientDao {


    @Override
    public ClientModel getUserByUsername(String username) throws SystemException{
        return MemoryDemo.getClient(username);
    }
    @Override
    public boolean checkUsername(String username) throws SystemException{
        return MemoryDemo.checkUsername(username);
    }
    @Override
    public void addUser(CredentialsModel credentialModel, ClientModel clientModel) throws SystemException {
        MemoryDemo.addClient( clientModel);
        MemoryDemo.addCredentials(credentialModel);
    }
}
