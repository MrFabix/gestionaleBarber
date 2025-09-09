package com.example.barber.utils.dao.sql;

import com.example.barber.model.BarberModel;
import com.example.barber.model.CredentialsModel;
import com.example.barber.utils.dao.BarberDao;
import com.example.barber.utils.db.Query;
import com.example.barber.utils.exception.myexception.SystemException;

import java.util.List;

public class BarberDaoSql implements BarberDao {
    Query query = new Query();

    @Override
    public void addBarber(CredentialsModel credentialModel, BarberModel barberModel) throws SystemException {
        query.insertCredentials(credentialModel);
        query.insertBarber(barberModel);
    }

    @Override
    public BarberModel getBarberByUsername(String username) throws SystemException {
        return query.searchBarberByUsername(username);
    }
    @Override
    public List<BarberModel> getAllBarber() throws SystemException {
        return query.searchAllBarber();
    }
    @Override
    public List<BarberModel> searchBarber(String name) throws SystemException {
        return query.searchBarberbyName(name);
    }
    @Override
    public BarberModel getBarberById(int id) throws SystemException {
        return query.searchBarberById(id);
    }

    @Override
    public void updateOrarioDB(BarberModel barberModel) throws SystemException{
        query.updateOrarioDB(barberModel);
    }





}
