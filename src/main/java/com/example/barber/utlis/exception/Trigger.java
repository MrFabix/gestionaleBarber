package com.example.barber.utlis.exception;

import java.sql.SQLException;

import com.example.barber.utlis.exception.myecxeption.*;
public class Trigger {
    public void throwDBConnectionFailedException(SQLException e) throws DBConnectionFailedException {
        DBConnectionFailedException exception = new DBConnectionFailedException();
        exception.initCause(e);
        throw exception;
    }
}
