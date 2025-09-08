package com.example.barber.utils.bean;


public class ServiceBean {
    protected int idBarber;
    protected String nomeServizio;
    protected double prezzo;


    public ServiceBean(){
        //Costruttore
    }

    public int getIdBarber() {
        return idBarber;
    }

    public void setIdBarber(int idBarber) {
        this.idBarber = idBarber;
    }

    public double getPrezzo() {
        return prezzo;
    }

    public void setPrezzo(double prezzo) {
        this.prezzo = prezzo;
    }

    public String getNomeServizio() {
        return nomeServizio;
    }

    public void setNomeServizio(String nomeServizio1) {
        this.nomeServizio = nomeServizio1;
    }


}
