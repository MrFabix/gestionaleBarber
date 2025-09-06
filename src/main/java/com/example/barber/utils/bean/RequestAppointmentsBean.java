package com.example.barber.utils.bean;

import com.example.barber.utils.exception.Trigger;
import com.example.barber.utils.exception.myexception.EmptyInputException;
import com.example.barber.utils.exception.myexception.InvalidDateException;
import com.example.barber.utils.statorichiesta.StatoRichieste;

import java.time.LocalDate;

public class RequestAppointmentsBean implements GenericBean{

    private Trigger trigger = new Trigger();
    protected int idAppointement;
    protected int idBarber;
    protected int idUser;
    protected String nameUser;
    protected String nameBarber;
    protected LocalDate date;
    protected String description;
    protected String addressBarber;
    protected String service;
    protected String phoneUser;
    protected StatoRichieste state;
    protected String orario;


   public int getIdAppointement() { return idAppointement; }

    public int getIdBarber() { return idBarber; }

    public int getIdUser() { return idUser; }

    public void setIdBarber(int idBarber) { this.idBarber = idBarber; }

    public void setIdUser(int idUser) { this.idUser = idUser; }

    public String getNameUser() { return nameUser; }

    public String getNameBarber() { return nameBarber; }

    public LocalDate getDate() { return date; }

    public void setDate(LocalDate date) throws InvalidDateException,EmptyInputException {
        if (date == null) {
            trigger.throwEmptyInputException("date");
        } else if (date.isBefore(LocalDate.now())) {
            trigger.throwInvalidDateException("date");
        } else {
            this.date = date;
        }
    }


    public void setDateRaw(LocalDate date) { this.date = date; }

    public String getDescription() { return description; }

    public String getAddressBarber() { return addressBarber; }

    public void setState(StatoRichieste state) { this.state = state; }

    public void setOrario(String orario) { this.orario = orario; }


    public String getService() { return service; }

    public String getPhoneUser() { return phoneUser; }

    public StatoRichieste getState() { return state; }

    public String getOrario() { return orario; }

    public void setIdAppointement(int idAppointement){ this.idAppointement=idAppointement; }


    public void setNameUser(String nameUser){
        this.nameUser = nameUser;
    }

    public void setNameBarber(String nameBarber) { this.nameBarber = nameBarber; }


    public void setDescription(String description) { this.description = description; }

    public void setAddressBarber(String addressBarber) { this.addressBarber = addressBarber;}

    public void setService(String service) { this.service = service;}

    public void setPhoneUser(String phoneUser){
        this.phoneUser = phoneUser;

    }


}
