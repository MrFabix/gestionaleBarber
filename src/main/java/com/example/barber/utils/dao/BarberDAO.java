package com.example.barber.utils.dao;

import com.example.barber.model.BarberModel;
import com.example.barber.utils.bean.BarberBean;
import com.example.barber.utils.db.Query;
import com.example.barber.utils.exception.myecxeption.SystemException;

public class BarberDAO {
    Query query = new Query();

    public BarberModel getBarberByUsername(String username) throws SystemException {
        return query.searchBarberByUsername(username);
    }



}
