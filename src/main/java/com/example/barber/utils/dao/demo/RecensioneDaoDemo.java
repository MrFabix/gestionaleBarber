package com.example.barber.utils.dao.demo;

import com.example.barber.model.RecensioneModel;
import com.example.barber.utils.dao.RecensioneDao;
import com.example.barber.utils.exception.myexception.SystemException;

import java.util.List;

public class RecensioneDaoDemo implements RecensioneDao {
    @Override
    public void insertRecensione(RecensioneModel recensioneModel) throws SystemException {
        MemoryDemo.insertRecensione(recensioneModel);
    }

    @Override
    public List<RecensioneModel> getMyRecensioni(int id) throws SystemException {
        return MemoryDemo.getMyRecensioni(id);
    }

    @Override
    public List<RecensioneModel> getMyRecensioniBarbiere(int id) throws SystemException {
        return MemoryDemo.getMyRecensioniBarbiere(id);
    }

    @Override
    public void reportRecensione(int idRecensione) throws SystemException {
        MemoryDemo.reportRecensione(idRecensione);
    }

    @Override
    public List<RecensioneModel> getReportedRecensioni() throws SystemException {
        return MemoryDemo.getReportedRecensioni();
    }

    @Override
    public void approveRecensione(int idRecensione) throws SystemException {
        MemoryDemo.approveRecensione(idRecensione);
    }

    @Override
    public void deleteRecensione(int idRecensione) throws SystemException {
        MemoryDemo.deleteRecensione(idRecensione);
    }
}
