package com.example.barber.utils.bean;

import com.example.barber.utils.exception.Trigger;
import com.example.barber.utils.exception.myexception.EmptyInputException;
import com.example.barber.utils.exception.myexception.PasswordNotCompliantException;

public class CredentialsBean {

    private Trigger trigger = new Trigger();

    public CredentialsBean() {
    }

    public CredentialsBean(String username, String password, String type){
        this.username = username;
        this.password = password;
        this.type = type;

    }

    protected String username;
    protected String password;
    protected String type;
    protected String confirmPassword;

    public String getUsername() {
        return username;
    }
    public String getPassword() {
        return password;
    }
    public String getType() {
        return type;
    }
    public String getConfirmPassword() {  return confirmPassword; }


    public void setConfirmPassword(String confirmPassword) { this.confirmPassword = confirmPassword; }

    public  void setUsername(String Username) throws EmptyInputException {

        if (Username.equals("")) {
            trigger.throwEmptyInputException("Username");
        } else {
            this.username = Username;
        }
    }

    public void setPassword(String Password) throws EmptyInputException, PasswordNotCompliantException {
        if (password.equals("")) {
            trigger.throwEmptyInputException("Password");
        } else if (password.length() < 8) {
            trigger.throwPasswordNotCompliantException();
        }else if(!password.equals(confirmPassword)){
            trigger.throwPasswordNotCompliantException();
        }else {
            this.password = Password;
        }
    }


    public void setType(String type) {
        this.type = type;
    }

}
