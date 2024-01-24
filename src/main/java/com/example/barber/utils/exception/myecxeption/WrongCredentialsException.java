package com.example.barber.utils.exception.myecxeption;

public class WrongCredentialsException extends Exception {
    public WrongCredentialsException( ){
        super("Username o password errati");
    }
}
