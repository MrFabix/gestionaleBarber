package com.example.barber.utils.bean;

import com.example.barber.model.BarberModel;
import com.example.barber.utils.exception.Trigger;
public class BarberBean extends ProfileBean {

    public final Trigger trigger = new Trigger();

    public BarberBean(){};

    public BarberBean(BarberModel barberModel){

    }


}
