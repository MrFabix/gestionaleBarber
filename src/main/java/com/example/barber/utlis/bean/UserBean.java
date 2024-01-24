package com.example.barber.utlis.bean;

import com.example.barber.model.UserModel;
import com.example.barber.utlis.exception.Trigger;

import java.time.LocalDate;

public class UserBean extends ProfileBean{
    private static  Trigger trigger= new Trigger();

    //utente

    protected String name;
    protected String surname;
    protected LocalDate birthday;

    public UserBean(){};

    public UserBean(UserModel usermModel) {
        this.name = name;
        this.surname = surname;
        this.birthday = birthday;
    }


}
