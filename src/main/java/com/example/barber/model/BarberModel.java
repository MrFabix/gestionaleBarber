package com.example.barber.model;

import com.example.barber.utils.bean.BarberBean;

public class BarberModel extends ProfileModel {
    private String city;
    private String address;

    private String phone;
    public BarberModel() {
        super();
    }

    public BarberModel(BarberBean barberBean){
       super(barberBean.getUsername(),barberBean.getEmail(),barberBean.getId(),barberBean.getImg(),barberBean.getName());
       this.city = barberBean.getCity();
       this.address = barberBean.getAddress();
         this.phone = barberBean.getPhone();
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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }


}