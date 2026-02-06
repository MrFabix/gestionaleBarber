package com.example.barber.controller.appcontroller;

import com.example.barber.model.RecensioneModel;

import com.example.barber.utils.bean.IdBean;
import com.example.barber.utils.bean.RecensioneBean;
import com.example.barber.utils.dao.RecensioneDao;
import com.example.barber.utils.engineering.ListRecensioniEngineering;
import com.example.barber.utils.exception.ErrorDialog;
import com.example.barber.utils.exception.myexception.SystemException;
import com.example.barber.utils.factory.daofactory.DaoFactory;
import com.example.barber.utils.managermode.ModeManager;
import com.example.barber.utils.observer.GenericBeanList;
import com.example.barber.utils.observer.Observer;
import com.example.barber.utils.setterandgetter.SetterClass;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class RecensioneAppController {

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
    public void addToListClient(Observer ob, int id) throws SystemException {
        ListRecensioniEngineering listRecensioni = new ListRecensioniEngineering();
        // Ottengo la lista delle recensioni
        List<RecensioneBean> listBean = listRecensioni.getMyRecensioni(id);
        // Aggiungo le recensioni all'osservatore
        GenericBeanList list1 = new GenericBeanList(ob);
        list1.addRecensioniToList(listBean);
    }

    public void addToListbarber(Observer ob, int id) throws SystemException {
        ListRecensioniEngineering listRecensioni = new ListRecensioniEngineering();
        // Ottengo la lista delle recensioni
        List<RecensioneBean> listBean = listRecensioni.getMyRecensioniBarbiere(id);
        // Aggiungo le recensioni all'osservatore
        GenericBeanList list1 = new GenericBeanList(ob);
        list1.addRecensioniToList(listBean);
    }

    public void reportRecensione(IdBean idRecensione)  {
        DaoFactory daoFactory = DaoFactory.getFactory(ModeManager.get());
        RecensioneDao recensioneDao = daoFactory.recensioneDao();
        int id = idRecensione.getId();
        try{
            recensioneDao.reportRecensione(id); //chiamo la query per segnalare la recensione
        } catch (SystemException e) {
            ErrorDialog.getInstance().handleException(e);
        }
    }

    public List<RecensioneBean> getReportedRecensioni() throws SystemException {
        DaoFactory daoFactory = DaoFactory.getFactory(ModeManager.get());
        RecensioneDao recensioneDao = daoFactory.recensioneDao();
        List<RecensioneModel> recensioneModels = recensioneDao.getReportedRecensioni();
        
        SetterClass setterClass = new SetterClass();
        List<RecensioneBean> recensioneBeans = new ArrayList<>();
        for (RecensioneModel model : recensioneModels) {
            RecensioneBean bean = new RecensioneBean();
            setterClass.setRecensioneBeanFromModel(bean, model);
            recensioneBeans.add(bean);
        }
        return recensioneBeans;
    }

    public void approveRecensione(IdBean idRecensione) throws SystemException {
        DaoFactory daoFactory = DaoFactory.getFactory(ModeManager.get());
        RecensioneDao recensioneDao = daoFactory.recensioneDao();
        recensioneDao.approveRecensione(idRecensione.getId());
    }

    public void deleteRecensione(IdBean idRecensione) throws SystemException {
        DaoFactory daoFactory = DaoFactory.getFactory(ModeManager.get());
        RecensioneDao recensioneDao = daoFactory.recensioneDao();
        recensioneDao.deleteRecensione(idRecensione.getId());
    }


}
