package com.example.barber.model;
import com.example.barber.utils.bean.RequestAppointmentsBean;
import com.example.barber.utils.statorichiesta.StatoRichieste;

import java.time.LocalDate;

public class RequestAppointmentsModel {



    //protected int idAppointement;
    protected int idBarber;
    protected int idUser;
    protected String nameUser;
    protected String nameBarber;
    protected LocalDate date;
    protected String description;
    protected String addressBarber;
    protected String service;
    protected String phone;
    protected StatoRichieste state;
    protected String orario;

    public RequestAppointmentsModel(){

    }

    public RequestAppointmentsModel(RequestAppointmentsBean requestAppointmentsBean){
       // this.idAppointement = requestAppointmentsBean.getIdAppointement();
        this.idBarber = requestAppointmentsBean.getIdBarber();
        this.idUser = requestAppointmentsBean.getIdUser();
        this.date = requestAppointmentsBean.getDate();
        this.nameUser = requestAppointmentsBean.getNameUser();
        this.addressBarber = requestAppointmentsBean.getAddressBarber();
        this.nameBarber = requestAppointmentsBean.getNameBarber();
        this.description = requestAppointmentsBean.getDescription();
        this.service = requestAppointmentsBean.getService();
        this.phone = requestAppointmentsBean.getPhoneUser();
        this.state= requestAppointmentsBean.getState();
        this.orario = requestAppointmentsBean.getOrario();
    }

    //Getter
    //public int getIdAppointement() { return idAppointement; }

    public int getIdBarber() { return idBarber; }

    public int getIdUser() { return idUser; }

    public String getNameUser() { return nameUser; }

    public String getNameBarber() { return nameBarber; }

    public LocalDate getDate() { return date; }

    public String getDescription() { return description; }

    public String getAddressBarber() { return addressBarber; }

    public String getService() { return service; }


    public String getPhone() {
        return phone;
    }

    public StatoRichieste getState() {
        return state;
    }

    public String getOrario() {
        return orario;
    }

    //Setter
    //public void setIdAppointement(int idAppointement) { this.idAppointement = idAppointement; }

    public void setIdBarber(int idBarber) { this.idBarber = idBarber; }

    public void setIdUser(int idUser) { this.idUser = idUser; }

    public void setNameUser(String nameUser) { this.nameUser = nameUser;}

    public void setNameBarber(String nameBarber) { this.nameBarber = nameBarber; }

    public void setDate(LocalDate date) { this.date = date; }

    public void setDescription(String description) { this.description = description; }

    public void setAddressBarber(String addressBarber) { this.addressBarber = addressBarber;}

    public void setService(String service) { this.service = service;}

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setState(StatoRichieste state) {
        this.state = state;
    }

    public void setOrario(String orario) {
        this.orario = orario;
    }
}
