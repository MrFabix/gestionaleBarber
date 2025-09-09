package com.example.barber.utils.dao.demo;

import com.example.barber.model.RequestAppointmentsModel;
import com.example.barber.utils.dao.RequestAppointments;
import com.example.barber.utils.exception.myexception.SystemException;

import java.util.List;

public class RequestAppointmentsDaoDemo implements RequestAppointments {
    @Override
    public List<RequestAppointmentsModel> getAllRequestAppointments(int id, String role) throws SystemException{
        System.out.println("Restituisci lista appuntamenti");
        return null;
    }
    @Override
    public void addAppointments(RequestAppointmentsModel requestAppointmentsModel) throws SystemException{
        System.out.println("Aggiungi appuntamento");
    }

    @Override
    public void updateStateByIdApp(int idAppointemnts, String state) throws SystemException{
        System.out.println("Effettua aggiornamento stato appuntmamenti");
    }
}
