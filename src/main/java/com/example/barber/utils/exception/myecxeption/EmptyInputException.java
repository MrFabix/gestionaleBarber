package com.example.barber.utils.exception.myecxeption;

public class EmptyInputException extends Exception {
    public EmptyInputException(String field) {
        super("The field " + field + " can't be empty!" );
    }
}
