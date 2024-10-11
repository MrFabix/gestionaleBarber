package com.example.barber.utils.dao;

import com.example.barber.model.UserModel;
import com.example.barber.utils.db.Query;
import com.example.barber.utils.exception.myexception.SystemException;

public class UserDAO {
Query query = new Query();
    public UserModel getUserByUsername(String username) throws SystemException {
        return query.searchUserByUsername(username);
    }
    public boolean checkUsername(String username) throws SystemException {
        return query.checkUsernameAlreadyTaken(username);
    }


}
