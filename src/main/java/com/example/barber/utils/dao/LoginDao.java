package com.example.barber.utils.dao;

import com.example.barber.model.CredentialsModel;
import com.example.barber.utils.exception.myexception.SystemException;
import com.example.barber.utils.exception.myexception.WrongCredentialsException;
import com.example.barber.utils.enumeration.ruoli.Role;

public interface LoginDao {
    Role getRole(CredentialsModel credentialsModel) throws SystemException, WrongCredentialsException;
}
