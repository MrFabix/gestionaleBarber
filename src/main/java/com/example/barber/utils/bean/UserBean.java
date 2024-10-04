package com.example.barber.utils.bean;

import com.example.barber.model.UserModel;
import com.example.barber.utils.exception.Trigger;

import java.time.LocalDate;

public class UserBean extends ProfileBean{
    private static  Trigger trigger= new Trigger();
    protected String name;
    protected String surname;
    protected String gender;

    public UserBean(){};
    public UserBean(UserModel usermModel) {
          this.name = usermModel.getName();
          this.surname = usermModel.getSurname();
          this.gender = usermModel.getGender();

    }

    public UserBean(UserBean userBean) {
        this.name = userBean.getName();
        this.surname = userBean.getSurname();
        this.gender = userBean.getGender();
    }

    public String getName() { return name; }
    public String getSurname() { return surname; }
    public String getGender() { return gender ; }

    public void setName(String name) { this.name = name; }
    public void setSurname(String surname) { this.surname = surname; }
    public void setGender(String gender) { this.gender=gender; }



}
