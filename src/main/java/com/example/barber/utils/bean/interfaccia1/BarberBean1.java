package com.example.barber.utils.bean.interfaccia1;

import com.example.barber.utils.bean.BarberBean;
import com.example.barber.utils.exception.Trigger;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;



public class BarberBean1 extends BarberBean {



        private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("HH:mm");

        public void setInizio(String inizio) throws IllegalArgumentException {
            try {
                LocalTime parsed = LocalTime.parse(inizio, FORMATTER);

                if (parsed.isBefore(LocalTime.of(7,0))) {
                    throw new IllegalArgumentException("L'orario di inizio deve essere dopo le 7:00 del mattino ");
                }
                super.orarioInizio = parsed.format(FORMATTER);

            } catch (DateTimeParseException e) {
                throw new IllegalArgumentException("Formato orario non valido. Usa HH:mm (es. 09:30)", e);
            }
        }

        public void setFine(String fine) throws IllegalArgumentException {
            try {
                LocalTime parsed = LocalTime.parse(fine, FORMATTER);
                LocalTime orarioInizio = LocalTime.parse(super.orarioInizio, FORMATTER);

                if (parsed.isBefore(LocalTime.MIDNIGHT) || parsed.isAfter(LocalTime.of(22, 00))) {
                    throw new IllegalArgumentException("L'orario di fine deve essere compreso tra 00:00 e 23:59");
                }

                if (super.orarioInizio != null && parsed.isBefore(orarioInizio)) {
                    throw new IllegalArgumentException("L'orario di fine non può essere minore dell'orario di inizio");
                }

                super.orarioFine = parsed.format(FORMATTER);

            } catch (DateTimeParseException e) {
                throw new IllegalArgumentException("Formato orario non valido. Usa HH:mm (es. 18:45)", e);
            }
        }



}
