package com.example.barber.model;

import com.example.barber.utils.bean.BarberBean;

public class BarberModel extends ProfileModel {
    private String city;
    private String address;
    private String phone;
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
        super(barberBean.getUsername(), barberBean.getEmail(), barberBean.getId(), barberBean.getImg(), barberBean.getName());
        this.city = barberBean.getCity();
        this.address = barberBean.getAddress();
        this.phone = barberBean.getPhone();
        this.hours = barberBean.getHours();
        this.description = barberBean.getDescription();
        this.services = barberBean.getServices();
        this.reviews = barberBean.getReviews();
    }

    // Getter e Setter
    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getHours() {
        return hours;
    }

    public void setHours(String hours) {
        this.hours = hours;
    }

    public String[] getServices() {
        return services;
    }

    public void setServices(String[] services) {
        this.services = services;
    }

    public String[] getReviews() {
        return reviews;
    }

    public void setReviews(String[] reviews) {
        this.reviews = reviews;
    }
}
