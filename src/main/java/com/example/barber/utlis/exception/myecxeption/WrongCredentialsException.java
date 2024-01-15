package com.example.barber.utlis.exception.myecxeption;

public class WrongCredentialsException extends Exception {
    public WrongCredentialsException( ){
        super("Username o password errati");
    }
}
