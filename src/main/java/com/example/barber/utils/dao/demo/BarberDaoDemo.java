package com.example.barber.utils.dao.demo;

import com.example.barber.model.BarberModel;
import com.example.barber.model.CredentialsModel;
import com.example.barber.utils.dao.BarberDao;
import com.example.barber.utils.exception.myexception.SystemException;

import java.util.List;

public class BarberDaoDemo implements BarberDao {
    @Override
    public void addBarber(CredentialsModel credentialModel, BarberModel barberModel) throws SystemException{
        MemoryDemo.addBarber(barberModel);
        MemoryDemo.addCredentials(credentialModel);
    }


    @Override
    public BarberModel getBarberByUsername(String username) throws SystemException{
        return MemoryDemo.getBarber(username);
    }

    @Override
    public List<BarberModel> getAllBarber() throws SystemException{
        return MemoryDemo.getAllBarber();
    }
    @Override
    public List<BarberModel> searchBarber(String name){
        return MemoryDemo.searchBarber(name);
    }

    @Override
    public BarberModel getBarberById(int id) throws SystemException{
        return MemoryDemo.searchBarberById(id);
    }
    @Override
    public void updateOrarioDB(BarberModel barberModel) throws SystemException{
        MemoryDemo.updateOrario(barberModel);
    }
}
