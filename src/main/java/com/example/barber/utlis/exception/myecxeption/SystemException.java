package com.example.barber.utlis.exception.myecxeption;

public class SystemException extends Exception{

    public SystemException() {
        super("A technical error occurred.");
    }

    public SystemException(String message) {
        super("A technical error occurred.\n" + message);
    }
}
