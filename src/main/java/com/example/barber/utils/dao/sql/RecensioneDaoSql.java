package com.example.barber.utils.dao.sql;

import com.example.barber.model.RecensioneModel;
import com.example.barber.utils.dao.RecensioneDao;
import com.example.barber.utils.db.Query;
import com.example.barber.utils.exception.myexception.SystemException;

public class RecensioneDaoSql implements RecensioneDao {
    Query query = new Query();
    public void insertRecensione(RecensioneModel recensioneModel) throws SystemException {

        query.insertRecensione(recensioneModel);
    }

}
