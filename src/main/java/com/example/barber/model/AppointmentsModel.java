package com.example.barber.model;



import java.util.Date;
import com.example.barber.utils.bean.AppointmentsBean;
public class AppointmentsModel {



    protected int idAppointement;
    protected int idBarber;
    protected int idUser;
    protected String nameUser;
    protected String nameBarber;
    protected Date date;
    protected String description;
    protected String addressBarber;
    protected String service;

    public AppointmentsModel(){

    }

    public AppointmentsModel(AppointmentsBean appointmentsBean){
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

    public void setNameUser(String nameUser) { this.nameUser = nameUser;}

    public void setNameBarber(String nameBarber) { this.nameBarber = nameBarber; }

    public void setDate(Date date) { this.date = date; }

    public void setDescription(String description) { this.description = description; }

    public void setAddressBarber(String addressBarber) { this.addressBarber = addressBarber;}

    public void setService(String service) { this.service = service;}
}
