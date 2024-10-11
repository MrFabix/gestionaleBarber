package com.example.barber.utils.bean;

import com.example.barber.utils.exception.Trigger;
import com.example.barber.utils.exception.myexception.EmptyInputException;
import com.example.barber.utils.exception.myexception.PasswordNotCompliantException;

public class CredentialsBean {

    private Trigger trigger = new Trigger();

    public CredentialsBean() {
    }

    public CredentialsBean(String Username, String Password, String type){
        this.Username = Username;
        this.Password = Password;
        this.type = type;

    }

    protected String Username;
    protected String Password;
    protected String type;

    public String getUsername() {
        return Username;
    }
    public String getPassword() {
        return Password;
    }
    public String getType() {
        return type;
    }
    public  void setUsername(String Username) throws EmptyInputException {

        if (Username.equals("")) {
            trigger.throwEmptyInputException("Username");
        } else {
            this.Username = Username;
        }
    }

    public void setPassword(String Password) throws EmptyInputException, PasswordNotCompliantException {
        if (Password.equals("")) {
            trigger.throwEmptyInputException("Password");
        } else if (Password.length() < 8) {
            trigger.throwPasswordNotCompliantException();
        } else {
            this.Password = Password;
        }
    }

    public void setType(String type) {
        this.type = type;
    }

}
