package com.example.barber.utils.factory.daofactory;

import com.example.barber.utils.dao.*;
import com.example.barber.utils.dao.sql.*;

public class SqlDaoFactory extends DaoFactory {

    public BarberDao barberDao() { return new BarberDaoSql(); }
    public ClientDao clientDao() { return new ClientDaoSql(); }
    public LoginDao loginDao()  { return new LoginDaoSql(); }
    public RequestAppointmentsDao requestAppointmentsDao() { return new RequestAppointmentsDaoSql(); }
    public ServiceDao serviceDao(){ return new ServiceDaoSql(); }
    public RecensioneDao recensioneDao() { return new RecensioneDaoSql(); }
}

