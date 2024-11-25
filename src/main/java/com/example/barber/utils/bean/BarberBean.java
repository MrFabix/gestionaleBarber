package com.example.barber.utils.bean;

import com.example.barber.model.BarberModel;
import com.example.barber.utils.exception.Trigger;

public class BarberBean extends ProfileBean {

    protected String address;
    protected String city;
    protected String phone;
    protected String hours;
    protected String description;
    protected String[] services;
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
        this.username = barberModel.getUsername();
        this.phone = barberModel.getPhone();
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
        this.phone = barberBean.getPhone();
        this.hours = barberBean.getHours();
        this.description = barberBean.getDescription();
        this.services = barberBean.getServices();
        this.reviews = barberBean.getReviews();
    }

    // Getter e Setter
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getHours() {
        return hours;
    }

    public void setHours(String hours) {
        this.hours = hours;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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
