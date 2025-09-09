package com.example.barber.utils.factory.daofactory;

import com.example.barber.utils.dao.*;
import com.example.barber.utils.managermode.Mode;

public abstract class DaoFactory {
  
    public static DaoFactory getFactory(Mode mode) {
        return (mode == Mode.DEMO) ? new DemoDaoFactory() : new SqlDaoFactory();
    }

    public abstract BarberDao barberDao();
    public abstract ClientDao clientDao();
    public abstract LoginDao loginDao();
    public abstract RequestAppointments requestAppointmentsDao();
    public abstract Service serviceDao();
}
