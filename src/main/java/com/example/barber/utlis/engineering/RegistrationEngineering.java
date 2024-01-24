package com.example.barber.utlis.engineering;

import com.example.barber.utlis.bean.UsernameBean;
import com.example.barber.utlis.dao.UserDAO;
import com.example.barber.utlis.exception.myecxeption.SystemException;

public class RegistrationEngineering {
    public boolean usernameAlreadyTaken(UsernameBean username) throws SystemException {
        UserDAO userDAO = new UserDAO();
        return userDAO.checkUsername(username.getUsername());
    }
}
