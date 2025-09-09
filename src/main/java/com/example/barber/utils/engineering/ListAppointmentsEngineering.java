package com.example.barber.utils.engineering;

import com.example.barber.model.RequestAppointmentsModel;
import com.example.barber.utils.bean.RequestAppointmentsBean;
import com.example.barber.utils.dao.RequestAppointmentsDao;

import com.example.barber.utils.exception.myexception.SystemException;
import com.example.barber.utils.factory.daofactory.DaoFactory;
import com.example.barber.utils.managermode.ModeManager;
import com.example.barber.utils.setterandgetter.SetterClass;

import java.util.ArrayList;
import java.util.List;

public class ListAppointmentsEngineering {

    private SetterClass setterClass = new SetterClass();

    public List<RequestAppointmentsBean> getAllAppointments(int id, String role) throws SystemException{
        List<RequestAppointmentsModel> list = null;
        List<RequestAppointmentsBean> listBean = new ArrayList<>();

        DaoFactory daoFactory = DaoFactory.getFactory(ModeManager.get());
        RequestAppointmentsDao requestAppointmentsDao = daoFactory.requestAppointmentsDao();
        list = requestAppointmentsDao.getAllRequestAppointments(id,role);
        for (RequestAppointmentsModel model : list) {
            RequestAppointmentsBean bean = new RequestAppointmentsBean();
            setterClass.setRequestAppBeanFromModel(bean, model);
            listBean.add(bean);
        }
        return listBean;
    }

}
