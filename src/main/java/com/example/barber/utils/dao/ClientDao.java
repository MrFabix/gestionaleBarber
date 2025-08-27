package com.example.barber.utils.dao;

import com.example.barber.model.CredentialsModel;
import com.example.barber.model.ClientModel;
import com.example.barber.utils.exception.myexception.SystemException;

public interface ClientDao {
    ClientModel getUserByUsername(String username) throws SystemException;
    boolean checkUsername(String username) throws SystemException;
    void addUser(CredentialsModel credentialModel, ClientModel clientModel) throws SystemException;


}
