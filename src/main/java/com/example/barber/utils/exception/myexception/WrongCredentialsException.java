package com.example.barber.utils.exception.myexception;

public class WrongCredentialsException extends Exception {
    public WrongCredentialsException( ){
        super("Username o password errati");
    }
}
