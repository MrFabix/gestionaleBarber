package com.example.barber.model;

import com.example.barber.utils.bean.BarberBean;

public class BarberModel extends ProfileModel {
    private String city;
    private String address;
    private String description;
    private String hours;
    private String[] services;
    private String[] reviews;

    // Costruttore di default
    public BarberModel() {
        super();
    }

    // Costruttore che copia i dati da un BarberBean
    public BarberModel(BarberBean barberBean) {
        super(barberBean.getId(), barberBean.getUsername(), barberBean.getEmail(), barberBean.getImg(), barberBean.getName(), barberBean.getPhone());
        this.city = barberBean.getCity();
        this.address = barberBean.getAddress();
        this.hours = barberBean.getHours();
        this.description = barberBean.getDescription();
        this.services = barberBean.getServices();
        this.reviews = barberBean.getReviews();
    }

    // Getter
    public String getCity() {
        return city;
    }

    public String getDescription() {
        return description;
    }

    public String getAddress() {
        return address;
    }

    public String getHours() { return hours; }

    public String[] getServices() {
        return services;
    }

    public String[] getReviews() {
        return reviews;
    }



    //Setter
    public void setCity(String city) {
        this.city = city;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setHours(String hours) {
        this.hours = hours;
    }

    public void setServices(String[] services) {
        this.services = services;
    }

    public void setReviews(String[] reviews) {
        this.reviews = reviews;
    }
}
