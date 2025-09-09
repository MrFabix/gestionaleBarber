package com.example.barber.utils.dao.sql;

import com.example.barber.model.RequestAppointmentsModel;
import com.example.barber.utils.dao.RequestAppointmentsDao;
import com.example.barber.utils.db.Query;
import com.example.barber.utils.exception.myexception.SystemException;

import java.util.List;

public class RequestAppointmentsDaoSql implements RequestAppointmentsDao {
    Query query = new Query();

    @Override
    public List<RequestAppointmentsModel> getAllRequestAppointments(int id, String role) throws SystemException {
        return query.searchAllAppointmentsById(id, role);
    }

    @Override
    public void addAppointments(RequestAppointmentsModel requestAppointmentsModel) throws SystemException {
        query.insertAppointments(requestAppointmentsModel);
    }

    @Override
    public void updateStateByIdApp(int idAppointemnts, String state) throws SystemException {
        query.updateAppointmentById(idAppointemnts, state);
    }


}
