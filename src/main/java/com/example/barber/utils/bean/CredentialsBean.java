package com.example.barber.utils.bean;

import com.example.barber.utils.exception.Trigger;
import com.example.barber.utils.exception.myexception.EmptyInputException;
import com.example.barber.utils.enumeration.ruoli.Role;

public class CredentialsBean {

    private Trigger trigger = new Trigger();

    public CredentialsBean() {
    }


    public CredentialsBean(String username, String password, Role type){
        this.username = username;
        this.password = password;
        this.type = type;
    }

    @Override
    public String toString() {
        return "CredentialsBean{" +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", type=" + type +
                '}';
    }

    protected String username;
    protected String password;
    protected Role type;


    public String getUsername() {
        return username;
    }
    public String getPassword() {
        return password;
    }
    public Role getType() {
        return type;
    }




   public  void setUsername(String username) throws EmptyInputException {
        if (username.equals("")) {
            trigger.throwEmptyInputException("Username");
        } else {
            this.username = username;
        }
    }

    public void setPassword(String password) throws EmptyInputException{
       if (password.equals("")) {
            trigger.throwEmptyInputException("Password");
        }else {
            this.password = password;
        }
    }

    public void setType(Role type) {
        this.type = type;
    }

}
