package com.example.barber.utils.dao;

import com.example.barber.model.RecensioneModel;
import com.example.barber.utils.exception.myexception.SystemException;

public interface  RecensioneDao {
     void insertRecensione(RecensioneModel recensioneModel) throws SystemException;

}
