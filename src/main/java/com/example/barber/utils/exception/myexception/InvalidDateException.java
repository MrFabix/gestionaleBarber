package com.example.barber.utils.exception.myexception;

import java.time.LocalDate;

public class InvalidDateException extends RuntimeException {
    public InvalidDateException(String field) {
      super("Inserisci una data valida " + field + "ricorda non puoi inserire una data minore di quella ordierna " + LocalDate.now());
    }
}
