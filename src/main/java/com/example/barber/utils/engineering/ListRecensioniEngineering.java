package com.example.barber.utils.engineering;

import com.example.barber.model.RecensioneModel;
import com.example.barber.utils.bean.RecensioneBean;
import com.example.barber.utils.dao.RecensioneDao;
import com.example.barber.utils.exception.myexception.SystemException;
import com.example.barber.utils.factory.daofactory.DaoFactory;
import com.example.barber.utils.managermode.ModeManager;
import com.example.barber.utils.setterandgetter.SetterClass;

import java.util.ArrayList;
import java.util.List;

public class ListRecensioniEngineering {
    private SetterClass setterClass = new SetterClass();


    public List<RecensioneBean> getMyRecensioni(int id) throws SystemException {
        List< RecensioneModel> list = null;
        List< RecensioneBean> listBean = null;
        DaoFactory daoFactory = DaoFactory.getFactory(ModeManager.get());
        RecensioneDao recensioneDao = daoFactory.recensioneDao();
        list = recensioneDao.getMyRecensioni(id);
        listBean = new ArrayList<>();
        for(RecensioneModel recensioneModel : list){
            RecensioneBean recensioneBean = new RecensioneBean();
            setterClass.setRecensioneBeanFromModel(recensioneBean, recensioneModel);
            listBean.add(recensioneBean);
        }
        return listBean;
    }

    public List<RecensioneBean> getMyRecensioniBarbiere(int id) throws SystemException {
        List< RecensioneModel> list = null;
        List< RecensioneBean> listBean = null;
        DaoFactory daoFactory = DaoFactory.getFactory(ModeManager.get());
        RecensioneDao recensioneDao = daoFactory.recensioneDao();
        list = recensioneDao.getMyRecensioniBarbiere(id);
        listBean = new ArrayList<>();
        for(RecensioneModel recensioneModel : list){
            RecensioneBean recensioneBean = new RecensioneBean();
            setterClass.setRecensioneBeanFromModel(recensioneBean, recensioneModel);
            listBean.add(recensioneBean);
        }
        return listBean;
    }



}
