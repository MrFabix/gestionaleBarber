package com.example.barber.utils.dao;

import com.example.barber.model.RequestAppointmentsModel;
import com.example.barber.utils.bean.RequestAppointmentsBean;
import com.example.barber.utils.db.Query;
import com.example.barber.utils.exception.myexception.SystemException;
import com.example.barber.utils.statorichiesta.StatoRichieste;

import java.util.List;

public class RequestAppointmentsDAO {
    Query query = new Query();
    public List<RequestAppointmentsModel> getAllRequestAppointments(int idUser, StatoRichieste stato) throws SystemException {
        return query.searchAllAppointments(idUser, stato);
    }

    public void addAppointments(RequestAppointmentsModel requestAppointmentsModel) throws SystemException {
        System.out.println("Sei nel RequestAppointmentsDAO");
        query.insertAppointments(requestAppointmentsModel);
    }



}
