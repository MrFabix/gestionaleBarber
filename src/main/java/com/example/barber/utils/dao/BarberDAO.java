package com.example.barber.utils.dao;

import com.example.barber.model.BarberModel;
import com.example.barber.utils.db.Query;
import com.example.barber.utils.exception.myexception.SystemException;

import java.util.List;

public class BarberDAO {
    Query query = new Query();

    public BarberModel getBarberByUsername(String username) throws SystemException {
        return query.searchBarberByUsername(username);
    }

    public List<BarberModel> getAllBarber() throws SystemException {
        return query.searchAllBarber();
    }



}
