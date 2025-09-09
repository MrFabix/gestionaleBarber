package com.example.barber.utils.factory.daofactory;

import com.example.barber.utils.dao.*;
import com.example.barber.utils.dao.demo.*;

public class DemoDaoFactory extends DaoFactory{
    private final BarberDao barberDaoDemo = new BarberDaoDemo();
    private final ClientDao clientDaoDemo = new ClientDaoDemo();
    private final LoginDao loginDaoDemo = new LoginDaoDemo();
    private final RequestAppointments requestAppointmentsDaoDemo = new RequestAppointmentsDaoDemo();
    private final Service serviceDaoDemo = new ServiceDaoDemo();

    public BarberDao barberDao() { return barberDaoDemo; }
    public ClientDao clientDao() { return clientDaoDemo; }
    public LoginDao loginDao()  { return loginDaoDemo; }
    public RequestAppointments requestAppointmentsDao() { return requestAppointmentsDaoDemo; }
    public Service serviceDao(){ return serviceDaoDemo; }
}
