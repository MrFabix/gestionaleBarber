package com.example.barber.controller.appcontroller;

import com.example.barber.utlis.bean.CredentialsBean;
import com.example.barber.utlis.exception.Trigger;
import com.example.barber.utlis.exception.myecxeption.SystemException;
import com.example.barber.utlis.exception.myecxeption.WrongCredentialsException;
import com.example.barber.utlis.dao.LoginDAO;
public class LoginAppController {

    Trigger trigger = new Trigger();

    public void login(CredentialsBean credenialBeans) throws WrongCredentialsException, SystemException {

        LoginDAO loginDAO = new LoginDAO();

    }
}
