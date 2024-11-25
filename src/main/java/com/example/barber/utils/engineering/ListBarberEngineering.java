package com.example.barber.utils.engineering;

import com.example.barber.model.BarberModel;
import com.example.barber.utils.bean.BarberBean;
import com.example.barber.utils.dao.BarberDAO;
import com.example.barber.utils.exception.myexception.SystemException;
import com.example.barber.utils.observer.GenericBeanList;
import com.example.barber.utils.observer.Observer;

import java.util.ArrayList;
import java.util.List;

public class ListBarberEngineering {


    public void listBarber(Observer observer ) throws SystemException {
        GenericBeanList list = new GenericBeanList(observer);
        list.addBarbersToList(getAllBarber());

    }

    public List<BarberBean> getAllBarber() throws SystemException {

        List<BarberModel> list = null;
        List<BarberBean> listBean = null;
        BarberDAO barberDAO = new BarberDAO();
        list = barberDAO.getAllBarber();
        listBean = new ArrayList<>();
        for(BarberModel barberModel : list){
            BarberBean bean = new BarberBean(barberModel);
            listBean.add(bean);
        }
        return listBean;
    }
    public List<BarberBean> getBarberByName(String name) throws SystemException {
        List<BarberModel> list = null;
        List<BarberBean> listBean = null;
        BarberDAO barberDAO = new BarberDAO();
        list = barberDAO.searchBarber(name);
        listBean = new ArrayList<>();
        for(BarberModel barberModel : list){
            BarberBean bean = new BarberBean(barberModel);
            listBean.add(bean);
        }
        return listBean;
    }




}
