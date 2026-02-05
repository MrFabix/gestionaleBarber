package com.example.barber.utils.dao.sql;

import com.example.barber.model.RecensioneModel;
import com.example.barber.utils.dao.RecensioneDao;
import com.example.barber.utils.db.Query;
import com.example.barber.utils.exception.myexception.SystemException;

import java.util.List;

public class RecensioneDaoSql implements RecensioneDao {
    Query query = new Query();
    public void insertRecensione(RecensioneModel recensioneModel) throws SystemException {
        query.insertRecensione(recensioneModel);
    }
    public List<RecensioneModel> getMyRecensioni(int id) throws SystemException {
        return query.getMyRecensioni(id);
    }

    public List<RecensioneModel> getMyRecensioniBarbiere(int id) throws SystemException {
        return query.getMyRecensioniBarbiere(id);
    }

    public void reportRecensione(int idRecensione) throws SystemException {
        query.reportRecensione(idRecensione);
    }

}
