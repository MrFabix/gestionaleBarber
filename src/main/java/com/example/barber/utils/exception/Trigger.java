package com.example.barber.utils.exception;

import java.sql.SQLException;

import com.example.barber.utils.exception.myexception.*;

import javax.naming.Name;

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
    public void throwPasswordNotEquals() throws PasswordNotEquals{
        throw new PasswordNotEquals();
    }


    public void throwUsernameAlreadyTakenException(String username) throws UsernameAlreadyTakenException {
        throw new UsernameAlreadyTakenException(username);
    }

    public void throwWrongCredentials() throws WrongCredentialsException {
        throw new WrongCredentialsException();
    }


}
