package com.example.barber.utils.exception.myecxeption;


public class UsernameAlreadyTakenException extends Exception {
    public UsernameAlreadyTakenException(String username) {
        super("The username " + username + " is already taken.");
    }
}
