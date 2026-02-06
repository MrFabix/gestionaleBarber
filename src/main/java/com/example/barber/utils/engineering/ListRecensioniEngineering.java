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
    private final SetterClass setterClass = new SetterClass();


    private List<RecensioneBean> convertToBeanList(List<RecensioneModel> modelList) {
        List<RecensioneBean> beanList = new ArrayList<>();
        for (RecensioneModel recensioneModel : modelList) {
            RecensioneBean recensioneBean = new RecensioneBean();
            setterClass.setRecensioneBeanFromModel(recensioneBean, recensioneModel);
            beanList.add(recensioneBean);
        }
        return beanList;
    }

    public List<RecensioneBean> convertModelListToBeanList(List<RecensioneModel> modelList) {
        return convertToBeanList(modelList);
    }

    public List<RecensioneBean> getMyRecensioni(int id) throws SystemException {
        DaoFactory daoFactory = DaoFactory.getFactory(ModeManager.get());
        RecensioneDao recensioneDao = daoFactory.recensioneDao();
        List<RecensioneModel> list = recensioneDao.getMyRecensioni(id);
        return convertToBeanList(list);
    }

    public List<RecensioneBean> getMyRecensioniBarbiere(int id) throws SystemException {
        DaoFactory daoFactory = DaoFactory.getFactory(ModeManager.get());
        RecensioneDao recensioneDao = daoFactory.recensioneDao();
        List<RecensioneModel> list = recensioneDao.getMyRecensioniBarbiere(id);
        return convertToBeanList(list);
    }



}
