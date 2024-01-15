package com.example.barber.utlis.exception.myecxeption;

public class PasswordNotCompliantException extends Exception {
    public PasswordNotCompliantException() {
        super("The password must have a lenght of 8 chars at least.");
    }
}
