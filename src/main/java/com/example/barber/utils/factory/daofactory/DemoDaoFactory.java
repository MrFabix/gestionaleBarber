package com.example.barber.utils.factory.daofactory;

import com.example.barber.utils.dao.*;
import com.example.barber.utils.dao.demo.*;

public class DemoDaoFactory extends DaoFactory{



    public BarberDao barberDao() { return new BarberDaoDemo(); }
    public ClientDao clientDao() { return new ClientDaoDemo(); }
    public LoginDao loginDao()  { return new LoginDaoDemo(); }
    public RequestAppointmentsDao requestAppointmentsDao() { return new RequestAppointmentsDaoDemo(); }
    public ServiceDao serviceDao(){ return new ServiceDaoDemo(); }
}
