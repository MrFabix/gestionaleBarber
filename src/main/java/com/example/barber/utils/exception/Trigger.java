package com.example.barber.utils.exception;

import java.sql.SQLException;

import com.example.barber.utils.exception.myexception.*;


public class Trigger {
    public void throwDBConnectionFailedException(SQLException e) throws DBConnectionFailedException {
        DBConnectionFailedException exception = new DBConnectionFailedException();
        exception.initCause(e);
        throw exception;
    }


    public void throwInvalidDateException(String field) throws InvalidDateException{
        throw new InvalidDateException(field);
    }

    public void throwEmptyInputException(String field) throws EmptyInputException {
        throw new EmptyInputException(field);
    }


    public void throwUsernameAlreadyTakenException(String username) throws UsernameAlreadyTakenException {
        throw new UsernameAlreadyTakenException(username);
    }

    public void throwWrongCredentials() throws WrongCredentialsException {
        throw new WrongCredentialsException();
    }


}
