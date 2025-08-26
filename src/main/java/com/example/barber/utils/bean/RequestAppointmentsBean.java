package com.example.barber.utils.bean;

import com.example.barber.model.RequestAppointmentsModel;
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

    public RequestAppointmentsBean() {
        //Ignore
    }

    public RequestAppointmentsBean(RequestAppointmentsBean requestAppointmentsBean) {
        this.idAppointement = requestAppointmentsBean.getIdAppointement();
        this.idBarber = requestAppointmentsBean.getIdBarber();
        this.idUser = requestAppointmentsBean.getIdUser();
        this.date = requestAppointmentsBean.getDate();
        this.nameUser = requestAppointmentsBean.getNameUser();
        this.addressBarber = requestAppointmentsBean.getAddressBarber();
        this.nameBarber = requestAppointmentsBean.getNameBarber();
        this.description = requestAppointmentsBean.getDescription();
        this.service = requestAppointmentsBean.getService();
        this.phoneUser = requestAppointmentsBean.getPhoneUser();
        this.state = requestAppointmentsBean.getState();
        this.orario = requestAppointmentsBean.getOrario();
    }

    public RequestAppointmentsBean(RequestAppointmentsModel requestAppointmentsModel) {
        this.idAppointement = requestAppointmentsModel.getIdAppointement();
        this.idBarber = requestAppointmentsModel.getIdBarber();
        this.idUser = requestAppointmentsModel.getIdUser();
        this.date = requestAppointmentsModel.getDate();
        this.nameUser = requestAppointmentsModel.getNameUser();
        this.addressBarber = requestAppointmentsModel.getAddressBarber();
        this.nameBarber = requestAppointmentsModel.getNameBarber();
        this.description = requestAppointmentsModel.getDescription();
        this.service = requestAppointmentsModel.getService();
        this.orario = requestAppointmentsModel.getOrario();
        this.state = requestAppointmentsModel.getState();
        this.orario = requestAppointmentsModel.getOrario();
    }

    //Getter
   public int getIdAppointement() { return idAppointement; }

    public int getIdBarber() { return idBarber; }

    public int getIdUser() { return idUser; }

    public String getNameUser() { return nameUser; }

    public String getNameBarber() { return nameBarber; }

    public LocalDate getDate() { return date; }

    public String getDescription() { return description; }

    public String getAddressBarber() { return addressBarber; }



    public String getService() { return service; }

    public String getPhoneUser() { return phoneUser; }

    public StatoRichieste getState() { return state; }

    public String getOrario() { return orario; }

    public void setIdAppointement(int idAppointement){ this.idAppointement=idAppointement; }

    public void setIdBarber(int idBarber) { this.idBarber = idBarber; }

    public void setIdUser(int idUser) { this.idUser = idUser; }

    public void setNameUser(String nameUser){
        this.nameUser = nameUser;
    }

    public void setNameBarber(String nameBarber) { this.nameBarber = nameBarber; }


    public void setDate(LocalDate date) throws InvalidDateException,EmptyInputException {
        if (date == null) {
            trigger.throwEmptyInputException("date");
        } else if (date.isBefore(LocalDate.now())) {
            trigger.throwInvalidDateException("date");
        } else {
            this.date = date;
        }
    }

    public void setDescription(String description) { this.description = description; }

    public void setAddressBarber(String addressBarber) { this.addressBarber = addressBarber;}

    public void setService(String service) { this.service = service;}

    public void setPhoneUser(String phoneUser){
        this.phoneUser = phoneUser;

    }

    public void setState(StatoRichieste state) { this.state = state; }

    public void setOrario(String orario) { this.orario = orario; }
}
