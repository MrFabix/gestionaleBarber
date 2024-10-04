package com.example.barber.utils.bean;

import com.example.barber.model.UserModel;
import com.example.barber.utils.exception.Trigger;

import java.time.LocalDate;

public class UserBean extends ProfileBean{
    private static  Trigger trigger= new Trigger();
    protected String surname;
    protected String gender;

    public UserBean(){};
    public UserBean(UserModel usermModel) {
          this.name = usermModel.getName();
          this.surname = usermModel.getSurname();
          this.gender = usermModel.getGender();
            this.id = usermModel.getId();
            this.email = usermModel.getEmail();
            this.username = usermModel.getUsername();



    }

    public UserBean(UserBean userBean) {
        this.name = userBean.getName();
        this.surname = userBean.getSurname();
        this.gender = userBean.getGender();
        this.id = userBean.getId();
        this.email = userBean.getEmail();
        this.username = userBean.getUsername();

    }

    public String getSurname() { return surname; }
    public String getGender() { return gender ; }

    public void setSurname(String surname) { this.surname = surname; }
    public void setGender(String gender) { this.gender=gender; }



}
