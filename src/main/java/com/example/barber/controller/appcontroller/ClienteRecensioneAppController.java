package com.example.barber.controller.appcontroller;

import com.example.barber.model.RecensioneModel;
import com.example.barber.utils.bean.RecensioneBean;
import com.example.barber.utils.dao.RecensioneDao;
import com.example.barber.utils.exception.myexception.SystemException;
import com.example.barber.utils.factory.daofactory.DaoFactory;
import com.example.barber.utils.managermode.ModeManager;

import java.sql.Timestamp;

public class ClienteRecensioneAppController {

    public void inviaRecensione(RecensioneBean recensioneBean) throws SystemException {
        RecensioneModel recensioneModel = new RecensioneModel();
        recensioneModel.setIdCliente(recensioneBean.getIdCliente());
        recensioneModel.setIdAppuntamento(recensioneBean.getIdAppuntamento());
        recensioneModel.setVoto(recensioneBean.getVoto());
        recensioneModel.setTesto(recensioneBean.getTesto());
        recensioneModel.setCreatedAt(new Timestamp(System.currentTimeMillis()) );
        DaoFactory daoFactory = DaoFactory.getFactory(ModeManager.get());
        RecensioneDao recensioneDao = daoFactory.recensioneDao();
        recensioneDao.insertRecensione(recensioneModel);




    }
}
