package com.example.barber.utlis.exception.myecxeption;

public class EmailNotValidException extends Exception {
    public EmailNotValidException(String email) {
        super("The email " + email + " inserted is not valid!");
    }

}
