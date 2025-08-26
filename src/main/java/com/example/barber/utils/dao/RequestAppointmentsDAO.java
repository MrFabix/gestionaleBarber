package com.example.barber.utils.dao;

import com.example.barber.model.RequestAppointmentsModel;
import com.example.barber.utils.db.Query;
import com.example.barber.utils.exception.myexception.SystemException;

import java.util.List;

public class RequestAppointmentsDAO {
    Query query = new Query();
    public List<RequestAppointmentsModel> getAllRequestAppointments(int id, String role) throws SystemException {
        return query.searchAllAppointmentsByUser(id, role);
    }



    public void addAppointments(RequestAppointmentsModel requestAppointmentsModel) throws SystemException {
        query.insertAppointments(requestAppointmentsModel);
    }

    public void updateStateByIdApp(int idAppointemnts, String state) throws SystemException {
        query.updateAppointmentById(idAppointemnts, state);
    }


}
