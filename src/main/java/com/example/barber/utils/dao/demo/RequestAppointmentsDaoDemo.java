package com.example.barber.utils.dao.demo;

import com.example.barber.model.RequestAppointmentsModel;
import com.example.barber.utils.dao.RequestAppointmentsDao;
import com.example.barber.utils.exception.myexception.SystemException;

import java.util.List;

public class RequestAppointmentsDaoDemo implements RequestAppointmentsDao {
    @Override
    public List<RequestAppointmentsModel> getAllRequestAppointments(int id, String role) throws SystemException{
        List<RequestAppointmentsModel> list = MemoryDemo.searchAllAppointmentsById(id, role);
        if(list == null){
            throw new SystemException("Lista appuntamenti vuota");
        }
        return list;
    }
    @Override
    public void addAppointments(RequestAppointmentsModel requestAppointmentsModel) throws SystemException{
        MemoryDemo.insertAppointments(requestAppointmentsModel);
    }

    @Override
    public void updateStateByIdApp(int idAppointemnts, String state) throws SystemException{
        MemoryDemo.updateAppointmentById(idAppointemnts, state);
    }
}
