package com.example.barber.utils.engineering;

import com.example.barber.utils.bean.UsernameBean;
import com.example.barber.utils.dao.UserDAO;
import com.example.barber.utils.exception.myexception.SystemException;

public class RegistrationEngineering {
    public boolean usernameAlreadyTaken(UsernameBean username) throws SystemException {
        UserDAO userDAO = new UserDAO();
        return userDAO.checkUsername(username.getUsername());
    }
}
