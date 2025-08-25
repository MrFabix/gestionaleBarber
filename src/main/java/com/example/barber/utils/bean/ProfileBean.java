package com.example.barber.utils.bean;
import com.example.barber.utils.engineering.CheckEmailEngineering;
import com.example.barber.utils.engineering.RegistrationEngineering;
import com.example.barber.utils.exception.Trigger;
import com.example.barber.utils.exception.myexception.EmailNotValidException;
import com.example.barber.utils.exception.myexception.EmptyInputException;
import com.example.barber.utils.exception.myexception.SystemException;
import com.example.barber.utils.exception.myexception.UsernameAlreadyTakenException;

import java.io.File;
public class ProfileBean implements GenericBean {
    private final Trigger trigger = new Trigger();





    protected String name; //Nome dell utente oppure nome del BarberShop
    protected int id ;
    protected String email;
    protected String phone;
    protected String username;
    protected File img;

    protected ProfileBean(){

    }

    protected ProfileBean(int id, String username, String email,  File profileImg, String name, String phone){
        this.id = id;
        this.username = username;
        this.email = email;
        this.phone = phone;
        this.img = profileImg;
        this.name = name;
    }

    //Getter
    public int getId() {return id;}

    public String getEmail() {
        return email;
    }

    public String getUsername() {
        return username;
    }

    public File getImg(){return img;}

    public String getName() { return name; }

    public String getPhone(){ return phone; }



    //Setter
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


    public void setPhone(String phone) throws EmptyInputException{
        if(phone == null || phone.equals("")) {
            trigger.throwEmptyInputException("phone user");
        }else{
            this.phone = phone;
        }
    }


    public void setName(String name) throws EmptyInputException {
        if (name.equals(""))
            trigger.throwEmptyInputException("Name");
        this.name = name;
    }
}
