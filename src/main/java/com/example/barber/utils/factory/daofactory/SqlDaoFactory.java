package com.example.barber.utils.factory.daofactory;

import com.example.barber.utils.dao.*;
import com.example.barber.utils.dao.sql.*;

public class SqlDaoFactory extends DaoFactory {
    private final BarberDao barberDao = new BarberDaoSql();
    private final ClientDao clientDao = new ClientDaoSql();
    private final LoginDao loginDao = new LoginDaoSql();
    private final RequestAppointments requestAppointmentsDao = new RequestAppointmentsDaoSql();
    private final Service service = new ServiceDaoSql();

    public BarberDao barberDao() { return barberDao; }
    public ClientDao clientDao() { return clientDao; }
    public LoginDao loginDao()  { return loginDao; }
    public RequestAppointments requestAppointmentsDao() { return requestAppointmentsDao; }
    public Service serviceDao(){ return service; }

}

