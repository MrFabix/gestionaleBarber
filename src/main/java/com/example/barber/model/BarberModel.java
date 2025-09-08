package com.example.barber.model;


public class BarberModel extends ProfileModel {
    private String city;
    private String address;
    private String description;
    private String orarioInizio;
    private String orarioFine;
    private ServiceModel services;
    private String[] reviews;

    // Costruttore di default
    public BarberModel() {
        super();
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


    public ServiceModel getServices() {
        return services;
    }

    public String[] getReviews() {
        return reviews;
    }

    public String getOrarioInizio() {
        return orarioInizio;
    }

    public String getOrarioFine() {
        return orarioFine;
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

    public void setOrarioInizio(String orarioInizio) {
        this.orarioInizio = orarioInizio;
    }

    public void setOrarioFine(String orarioFine) {
        this.orarioFine = orarioFine;
    }

    public void setServices(ServiceModel services) {
        this.services = services;
    }


    public void setReviews(String[] reviews) {
        this.reviews = reviews;
    }
}
