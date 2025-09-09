package com.example.barber.utils.dao.demo;

import com.example.barber.model.CredentialsModel;
import com.example.barber.utils.dao.LoginDao;
import com.example.barber.utils.enumeration.ruoli.Role;
import com.example.barber.utils.exception.myexception.SystemException;

public class LoginDaoDemo implements LoginDao {
    @Override
    public Role getRole(CredentialsModel credentialsModel) throws SystemException {
       return MemoryDemo.getRole(credentialsModel);
    }
}
