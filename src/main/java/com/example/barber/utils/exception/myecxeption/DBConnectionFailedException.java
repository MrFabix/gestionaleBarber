package com.example.barber.utils.exception.myecxeption;

public class DBConnectionFailedException extends SystemException {

    public DBConnectionFailedException() {
        super("Connection to database failed");
    }
}
