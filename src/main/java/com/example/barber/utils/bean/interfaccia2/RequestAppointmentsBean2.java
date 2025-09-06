package com.example.barber.utils.bean.interfaccia2;


import com.example.barber.utils.bean.RequestAppointmentsBean;
import com.example.barber.utils.exception.myexception.EmptyInputException;

import java.time.LocalDate;
import java.util.Objects;


public class RequestAppointmentsBean2 extends RequestAppointmentsBean {



    public void setDate(String DD, String MM, String YY) throws EmptyInputException{
        // 1) null/blank
        String dStr = Objects.requireNonNull(DD, "Giorno nullo").trim();
        String mStr = Objects.requireNonNull(MM, "Mese nullo").trim();
        String yStr = Objects.requireNonNull(YY, "Anno nullo").trim();
        if (dStr.isEmpty() || mStr.isEmpty() || yStr.isEmpty()) {
            throw new IllegalArgumentException("Giorno, mese e anno sono obbligatori.");
        }

        int day;
        int month;
        int year;

        try {
            day = Integer.parseInt(dStr);
            month = Integer.parseInt(mStr);
            year = Integer.parseInt(yStr);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Giorno, mese e anno devono essere numeri interi.", e);
        }

        if (month < 1 || month > 12) {
            throw new IllegalArgumentException("Il mese deve essere compreso tra 1 e 12.");
        }
        int maxDay;
        switch (month) {
            case 1, 3, 5, 7, 8, 10, 12 -> maxDay = 31;
            case 2 -> maxDay = 28; // voluto: ignoriamo anni bisestili
            default -> maxDay = 30;
        }
        if (day < 1 || day > maxDay) {
            throw new IllegalArgumentException("Giorno fuori range per il mese specificato (1-" + maxDay + ").");
        }
        LocalDate today = LocalDate.now();
        if (year < today.getYear()) {
            throw new IllegalArgumentException("L'anno non può essere minore dell'anno corrente.");
        }

        LocalDate newDate = LocalDate.of(year, month, day);
        if (newDate.isBefore(today)) {
            throw new IllegalArgumentException("La data non può essere nel passato.");
        }

        super.setDate(newDate);
    }

}
