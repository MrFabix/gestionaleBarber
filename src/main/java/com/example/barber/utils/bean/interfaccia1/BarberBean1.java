package com.example.barber.utils.bean.interfaccia1;

import com.example.barber.utils.bean.BarberBean;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;



public class BarberBean1 extends BarberBean {





    public void setFine(String testoFine) throws IllegalArgumentException {
        try {
            if (super.orarioInizio == null) {
                throw new IllegalArgumentException("Imposta prima l'orario di inizio");
            }

            LocalTime orarioFineParse = LocalTime.parse(testoFine, FORMATTER);
            LocalTime orarioInizioParse = LocalTime.parse(super.orarioInizio, FORMATTER);

            // controllo relazione con orario di inizio
            if (orarioFineParse.isBefore(orarioInizioParse)) {
                throw new IllegalArgumentException("L'orario di fine non può essere minore dell'orario di inizio");
            }

            // controllo range massimo consentito (fino alle 22:00)
            if (orarioFineParse.isAfter(LocalTime.of(22, 0))) {
                throw new IllegalArgumentException("L'orario di fine non può andare oltre le 22:00");
            }

            super.orarioFine = orarioFineParse.format(FORMATTER);

        } catch (DateTimeParseException e) {
            throw new IllegalArgumentException("Formato orario non valido. Usa HH:mm (es. 18:45)", e);
        }
    }

    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("HH:mm");

    public void setInizio(String testoInizio) throws IllegalArgumentException {
        try {
            LocalTime orarioParse = LocalTime.parse(testoInizio, FORMATTER);

            // prima controllo il formato logico (>=07:00)
            if (orarioParse.isBefore(LocalTime.of(7, 0))) {
                throw new IllegalArgumentException("L'orario di inizio deve essere dopo le 07:00 del mattino");
            }

            // se tutto ok salvo
            super.orarioInizio = orarioParse.format(FORMATTER);

        } catch (DateTimeParseException e) {
            throw new IllegalArgumentException("Formato orario non valido. Usa HH:mm (es. 09:30)", e);
        }
    }



}
