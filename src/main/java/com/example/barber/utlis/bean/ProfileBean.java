package com.example.barber.utlis.bean;
import com.example.barber.utlis.engineering.CheckEmailEngineering;
import com.example.barber.utlis.engineering.RegistrationEngineering;
import com.example.barber.utlis.exception.Trigger;
import com.example.barber.utlis.exception.myecxeption.EmailNotValidException;
import com.example.barber.utlis.exception.myecxeption.EmptyInputException;
import com.example.barber.utlis.exception.myecxeption.SystemException;
import com.example.barber.utlis.exception.myecxeption.UsernameAlreadyTakenException;

import java.io.File;
public class ProfileBean {
    private final Trigger trigger = new Trigger();
    protected int id ;
    protected String email;

    protected String username;
    protected File img;

    public int getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public String getUsername() {
        return username;
    }

    public File getImg(){return img;}


    public void setId(int id) {
        this.id = id;
    }
    public void setEmail(String email) throws EmptyInputException, EmailNotValidException {
        if(email.isEmpty())
            trigger.throwEmptyInputException("email");
        CheckEmailEngineering checkEmailEngineering = new CheckEmailEngineering();
        EmailBean emailBean = new EmailBean();
        emailBean.setEmail(email);
        boolean correctFormat = checkEmailEngineering.validate(emailBean);
        if(correctFormat)
            this.email = email;
        else
            throw new EmailNotValidException(email);
    }
    public void setImg(File img) throws EmptyInputException {
        if (img == null) {
            trigger.throwEmptyInputException("Image");
        } else {
            this.img = img;
        }
    }
    public void setUsername(String username) throws EmptyInputException, UsernameAlreadyTakenException, SystemException {

        RegistrationEngineering engineering = new RegistrationEngineering();
        if (username.equals("")) {
            trigger.throwEmptyInputException("Username");
        } else if (engineering.usernameAlreadyTaken(new UsernameBean(username))) {
            trigger.throwUsernameAlreadyTakenException(username);
        } else {
            this.username = username;
        }
    }

}
