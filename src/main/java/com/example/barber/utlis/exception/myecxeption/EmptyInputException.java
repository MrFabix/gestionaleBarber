package com.example.barber.utlis.exception.myecxeption;

public class EmptyInputException extends Exception {
    public EmptyInputException(String field) {
        super("The field " + field + " can't be empty!" );
    }
}
