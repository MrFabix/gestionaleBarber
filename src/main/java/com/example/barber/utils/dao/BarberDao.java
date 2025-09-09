package com.example.barber.utils.dao;

import com.example.barber.model.BarberModel;
import com.example.barber.model.CredentialsModel;
import com.example.barber.utils.exception.myexception.SystemException;

import java.util.List;

public interface BarberDao {
    void addBarber(CredentialsModel credentialModel, BarberModel barberModel) throws SystemException;
    BarberModel getBarberByUsername(String username) throws SystemException;
    List<BarberModel> getAllBarber() throws SystemException;
    List<BarberModel> searchBarber(String name) throws SystemException;
    BarberModel getBarberById(int id) throws SystemException;
    void updateOrarioDB(BarberModel barberModel) throws SystemException;
}
