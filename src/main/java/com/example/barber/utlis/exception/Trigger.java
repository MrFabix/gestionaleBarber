package com.example.barber.utlis.exception;

import java.sql.SQLException;

import com.example.barber.utlis.exception.myecxeption.*;
public class Trigger {
    public void throwDBConnectionFailedException(SQLException e) throws DBConnectionFailedException {
        DBConnectionFailedException exception = new DBConnectionFailedException();
        exception.initCause(e);
        throw exception;
    }

    public void throwEmptyInputException(String field) throws EmptyInputException {
        throw new EmptyInputException(field);
    }
    public void throwPasswordNotCompliantException() throws PasswordNotCompliantException {
        throw new PasswordNotCompliantException();
    }

}
