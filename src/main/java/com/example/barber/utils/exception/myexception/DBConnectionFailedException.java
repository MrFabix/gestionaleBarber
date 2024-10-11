package com.example.barber.utils.exception.myexception;

public class DBConnectionFailedException extends SystemException {

    public DBConnectionFailedException() {
        super("Connection to database failed");
    }
}
