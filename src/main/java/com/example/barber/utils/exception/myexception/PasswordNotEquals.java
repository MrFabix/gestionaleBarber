package com.example.barber.utils.exception.myexception;

import java.util.concurrent.ExecutionException;

public class PasswordNotEquals extends Exception {

    public PasswordNotEquals() {
        super("Password Not Euquals");
    }
}
