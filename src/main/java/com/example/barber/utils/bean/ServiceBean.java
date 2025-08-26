package com.example.barber.utils.bean;

import com.example.barber.model.ServiceModel;

import java.util.List;

public class ServiceBean {
    protected int id_barber;
    protected String nome_servizio;
    protected double prezzo;


    public ServiceBean(){

    }

    public ServiceBean(int id_barber, String nome_servizio, double prezzo) {
        this.id_barber = id_barber;
        this.nome_servizio = nome_servizio;
        this.prezzo = prezzo;
    }

    public ServiceBean(ServiceBean serviceBean) {
        this.id_barber = serviceBean.getId_barber();
        this.nome_servizio = serviceBean.getNome_servizio();
        this.prezzo = serviceBean.getPrezzo();
    }

    public ServiceBean(ServiceModel serviceModel) {
        this.id_barber = serviceModel.getId_barber();
        this.nome_servizio = serviceModel.getNome_servizio();
        this.prezzo = serviceModel.getPrezzo();
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

    public String getNome_servizio() {
        return nome_servizio;
    }

    public void setNome_servizio(String nome_servizio) {
        this.nome_servizio = nome_servizio;
    }


}
