package com.example.barber.controller.appcontroller;

import com.example.barber.model.RecensioneModel;

import com.example.barber.utils.bean.RecensioneBean;
import com.example.barber.utils.dao.RecensioneDao;
import com.example.barber.utils.engineering.ListRecensioniEngineering;
import com.example.barber.utils.exception.myexception.SystemException;
import com.example.barber.utils.factory.daofactory.DaoFactory;
import com.example.barber.utils.managermode.ModeManager;
import com.example.barber.utils.observer.GenericBeanList;
import com.example.barber.utils.observer.Observer;

import java.sql.Timestamp;
import java.util.List;

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


    public void addToList(Observer ob, int id) throws SystemException {
        ListRecensioniEngineering listRecensioni = new ListRecensioniEngineering();
        // Ottengo la lista delle recensioni
        List<RecensioneBean> listBean = listRecensioni.getMyRecensioni(id);
        // Aggiungo le recensioni all'osservatore
        GenericBeanList list1 = new GenericBeanList(ob);
        list1.addRecensioniToList(listBean);
    }

}
