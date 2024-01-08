package com.example.barber.utlis.exception.myecxeption;

public class DBConnectionFailedException extends SystemException {

    public DBConnectionFailedException() {
        super("Connection to database failed");
    }
}
