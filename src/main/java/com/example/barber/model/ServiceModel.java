package com.example.barber.model;

public class ServiceModel {
    private int idBarber;
    private String nomeServizio;
    private double prezzo;

    public ServiceModel(){

    }

    public ServiceModel(double prezzo, String nomeServizio, int idBarber) {
        this.prezzo = prezzo;
        this.nomeServizio = nomeServizio;
        this.idBarber = idBarber;
    }



    public String getNomeServizio() {
        return nomeServizio;
    }

    public void setNomeServizio(String nomeServizio) {
        this.nomeServizio = nomeServizio;
    }

    public int getIdBarber() {
        return idBarber;
    }

    public void setIdBarber(int idBar) {
        this.idBarber = idBar;
    }

    public double getPrezzo() {
        return prezzo;
    }

    public void setPrezzo(double prezzo) {
        this.prezzo = prezzo;
    }
}
