package com.example.barber.utils.bean;

import com.example.barber.model.AppointmentsModel;
import com.example.barber.utils.exception.Trigger;
import com.example.barber.utils.exception.myexception.EmptyInputException;

import java.util.Date;

public class AppointmentsBean implements GenericBean{
    private Trigger trigger = new Trigger();
    protected int idAppointement;
    protected int idBarber;
    protected int idUser;
    protected String nameUser;
    protected String nameBarber;
    protected Date date;
    protected String description;
    protected String addressBarber;
    protected String service;

    public AppointmentsBean() {
        //Ignore
    }

    public AppointmentsBean(AppointmentsBean appointmentsBean) {
        this.idAppointement = appointmentsBean.getIdAppointement();
        this.idBarber = appointmentsBean.getIdBarber();
        this.idUser = appointmentsBean.getIdUser();
        this.date =appointmentsBean.getDate();
        this.nameUser = appointmentsBean.getNameUser();
        this.addressBarber = appointmentsBean.getAddressBarber();
        this.nameBarber = appointmentsBean.getNameBarber();
        this.description = appointmentsBean.getDescription();
        this.service = appointmentsBean.getService();
    }

    public AppointmentsBean(AppointmentsModel appointmentsModel) {
        this.idAppointement = appointmentsModel.getIdAppointement();
        this.idBarber = appointmentsModel.getIdBarber();
        this.idUser = appointmentsModel.getIdUser();
        this.date =appointmentsModel.getDate();
        this.nameUser = appointmentsModel.getNameUser();
        this.addressBarber = appointmentsModel.getAddressBarber();
        this.nameBarber = appointmentsModel.getNameBarber();
        this.description = appointmentsModel.getDescription();
        this.service = appointmentsModel.getService();
    }

    //Getter
    public int getIdAppointement() { return idAppointement; }

    public int getIdBarber() { return idBarber; }

    public int getIdUser() { return idUser; }

    public String getNameUser() { return nameUser; }

    public String getNameBarber() { return nameBarber; }

    public Date getDate() { return date; }

    public String getDescription() { return description; }

    public String getAddressBarber() { return addressBarber; }

    public String getService() { return service; }


    //Setter
    public void setIdAppointement(int idAppointement) { this.idAppointement = idAppointement; }

    public void setIdBarber(int idBarber) { this.idBarber = idBarber; }

    public void setIdUser(int idUser) { this.idUser = idUser; }

    public void setNameUser(String nameUser) throws EmptyInputException {
        if(nameUser.equals("")) {
            trigger.throwEmptyInputException("name");
        }
        this.nameUser = nameUser;
    }

    public void setNameBarber(String nameBarber) { this.nameBarber = nameBarber; }

    public void setDate(Date date) { this.date = date; }

    public void setDescription(String description) { this.description = description; }

    public void setAddressBarber(String addressBarber) { this.addressBarber = addressBarber;}

    public void setService(String service) { this.service = service;}
}
