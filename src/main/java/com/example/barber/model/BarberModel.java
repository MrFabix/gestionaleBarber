package com.example.barber.model;

import com.example.barber.utils.bean.BarberBean;

public class BarberModel extends ProfileModel {
    private String city;
    private String address;
    public BarberModel() {
        super();
    }

    public BarberModel(BarberBean barberBean){
       super(barberBean.getUsername(),barberBean.getEmail(),barberBean.getId(),barberBean.getImg(),barberBean.getName());
       this.city = barberBean.getCity();
       this.address = barberBean.getAddress();
    }

    public String getCity() {
        return city;
    }

    public String getAddress() {
        return address;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setAddress(String address) {
        this.address = address;
    }


}