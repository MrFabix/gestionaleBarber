package com.example.barber.utils.bean;

import com.example.barber.model.BarberModel;
import com.example.barber.utils.exception.Trigger;
public class BarberBean extends ProfileBean {
    protected String address;
    protected String city;
    protected String phone;

    public final Trigger trigger = new Trigger();

    public BarberBean(){};

    public BarberBean(BarberModel barberModel){
        this.name = barberModel.getName();
        this.id = barberModel.getId();
        this.email = barberModel.getEmail();
        this.address = barberModel.getAddress();
        this.city = barberModel.getCity();
        this.username = barberModel.getUsername();

    }

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
}
