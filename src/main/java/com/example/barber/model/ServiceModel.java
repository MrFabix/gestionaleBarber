package com.example.barber.model;

public class ServiceModel {
    private int id_barber;
    private String nome_servizio;
    private double prezzo;




    public String getNome_servizio() {
        return nome_servizio;
    }

    public void setNome_servizio(String nome_servizio) {
        this.nome_servizio = nome_servizio;
    }

    public int getId_barber() {
        return id_barber;
    }

    public void setId_barber(int id_barber) {
        this.id_barber = id_barber;
    }

    public double getPrezzo() {
        return prezzo;
    }

    public void setPrezzo(double prezzo) {
        this.prezzo = prezzo;
    }
}
