package com.example.barber.utils.bean;

import com.example.barber.model.BarberModel;
import com.example.barber.model.ServiceModel;
import com.example.barber.utils.exception.Trigger;

public class BarberBean extends ProfileBean {
    protected String orarioInizio;
    protected String orarioFine;
    protected String address;
    protected String city;
    protected String description;
    protected ServiceModel services;
    protected String[] reviews;



    public final Trigger trigger = new Trigger();

    // Costruttore di default
    public BarberBean() {}

    // Costruttore che copia i dati da BarberModel
    public BarberBean(BarberModel barberModel) {
        this.name = barberModel.getName();
        this.id = barberModel.getId();
        this.email = barberModel.getEmail();
        this.address = barberModel.getAddress();
        this.city = barberModel.getCity();
        this.phone = barberModel.getPhone();
        this.username = barberModel.getUsername();
        this.description = barberModel.getDescription();
        this.services = barberModel.getServices();
        this.reviews = barberModel.getReviews();
    }

    // Costruttore che copia i dati da un altro BarberBean
    public BarberBean(BarberBean barberBean) {

        this.name = barberBean.getName();
        this.id = barberBean.getId();
        this.email = barberBean.getEmail();
        this.address = barberBean.getAddress();
        this.city = barberBean.getCity();
        this.username = barberBean.getUsername();
        this.description = barberBean.getDescription();
        this.services = barberBean.getServices();
        this.reviews = barberBean.getReviews();
        this.phone = barberBean.getPhone();
    }




    //getter

    public String getAddress() {
        return address;
    }

    public String getCity() {
        return city;
    }

    public String getOrarioInizio() {
        return orarioInizio;
    }

    public String getOrarioFine() {
        return orarioFine;
    }

    public String getDescription() {
        return description;
    }

    public ServiceModel getServices() {
        return services;
    }

    public String[] getReviews() {
        return reviews;
    }


    //Setter


    public void setAddress(String address) {
        this.address = address;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setOrarioInizio(String orarioInizio) {
        this.orarioInizio = orarioInizio;
    }

    public void setOrarioFine(String orarioFine) {
        this.orarioFine = orarioFine;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setServices(ServiceModel services) {
        this.services = services;
    }

    public void setReviews(String[] reviews) {
        this.reviews = reviews;
    }

    // Metodo toString per il debug
    @Override
    public String toString() {
        return "BarberBean{"+
                "name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", city='" + city + '\'' +
                ", phone='" + phone + '\'' +
                ", hours='" + orarioInizio + '\'' +
                ", hours='" + orarioFine + '\'' +
                 "phone"+ phone + '\'' +
                ", description='" + description + '\'' +
                ", services=" + (services != null ? String.join(", ", services.getNome_servizio()) : "No services available") +
                ", reviews=" + (reviews != null ? String.join(", ", reviews) : "No reviews available") +
                '}';
    }

}
