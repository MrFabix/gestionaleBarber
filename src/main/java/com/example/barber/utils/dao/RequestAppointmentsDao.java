package com.example.barber.utils.dao;

import com.example.barber.model.RequestAppointmentsModel;
import com.example.barber.utils.exception.myexception.SystemException;

import java.util.List;

public interface RequestAppointmentsDao {

    List<RequestAppointmentsModel> getAllRequestAppointments(int id, String role) throws SystemException;
    void addAppointments(RequestAppointmentsModel requestAppointmentsModel) throws SystemException;
    void updateStateByIdApp(int idAppointemnts, String state) throws SystemException;
}

