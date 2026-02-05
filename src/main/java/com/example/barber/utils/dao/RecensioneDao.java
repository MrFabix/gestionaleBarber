package com.example.barber.utils.dao;

import com.example.barber.model.RecensioneModel;
import com.example.barber.utils.exception.myexception.SystemException;

import java.util.List;

public interface  RecensioneDao {
     void insertRecensione(RecensioneModel recensioneModel) throws SystemException;
     List<RecensioneModel> getMyRecensioni(int id) throws SystemException;
}
