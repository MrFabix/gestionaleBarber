package com.example.barber.utils.bean;

import com.example.barber.model.BarberModel;
import com.example.barber.utils.exception.Trigger;

public class BarberBean extends ProfileBean {

    protected String barberShopName;
    protected String address;
    protected String city;
    protected String hours;
    protected String description;
    protected String[] services;
    protected String[] reviews;



    protected String username;

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
        this.username = barberModel.getUsername();
        this.hours = barberModel.getHours();
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
        this.hours = barberBean.getHours();
        this.description = barberBean.getDescription();
        this.services = barberBean.getServices();
        this.reviews = barberBean.getReviews();
    }

    // Getter e Setter



    //getter
    public String getAddress() {
        return address;
    }

    public String getCity() {
        return city;
    }

    public String getHours() {
        return hours;
    }

    public String getDescription() {
        return description;
    }

    public String[] getServices() {
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

    public void setHours(String hours) {
        this.hours = hours;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setServices(String[] services) {
        this.services = services;
    }

    public void setReviews(String[] reviews) {
        this.reviews = reviews;
    }

    // Metodo toString per il debug
    @Override
    public String toString() {
        return "BarberBean{" +
                "name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", city='" + city + '\'' +
                ", phone='" + phone + '\'' +
                ", hours='" + hours + '\'' +
                ", description='" + description + '\'' +
                ", services=" + (services != null ? String.join(", ", services) : "No services available") +
                ", reviews=" + (reviews != null ? String.join(", ", reviews) : "No reviews available") +
                '}';
    }

}
