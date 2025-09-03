package com.example.barber.utils.bean.interfaccia2;

import com.example.barber.utils.bean.BarberBean;

public class BarberBean2 extends BarberBean{



    public void setAddress(String street, String civico) {
        String s = street == null ? "" : street.trim();
        String c = civico == null ? "" : civico.trim();

        if (!s.isEmpty() && !s.matches("(?i)^(via|piazza)\\b.*")) {
            throw new IllegalArgumentException("L'indirizzo deve iniziare con 'via' o 'piazza'.");
        }

        // Unisci con uno spazio solo se servono entrambi
        String joined = (s + " " + c).trim().replaceAll("\\s+", " ");
        this.address = joined;
    }
}
