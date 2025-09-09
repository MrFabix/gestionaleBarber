package com.example.barber.controller.appcontroller;

import com.example.barber.model.RequestAppointmentsModel;
import com.example.barber.utils.bean.RequestAppointmentsBean;
import com.example.barber.utils.dao.RequestAppointmentsDao;
import com.example.barber.utils.exception.myexception.SystemException;
import com.example.barber.utils.factory.daofactory.DaoFactory;
import com.example.barber.utils.managermode.ModeManager;
import com.example.barber.utils.observer.ManageRequestBeanList;
import com.example.barber.utils.observer.Observer;
import com.example.barber.utils.setterandgetter.SetterClass;
import com.example.barber.utils.enumeration.statorichieste.StatoRichieste;

import java.util.ArrayList;
import java.util.List;

public class CheckRequestAppController {


    private ManageRequestBeanList manageRequestBeanList;
    private SetterClass setterClass = new SetterClass();

    public void sendAppointments(RequestAppointmentsBean requestAppointmentsBean) throws SystemException{
        RequestAppointmentsModel requestAppointmentsModel = new RequestAppointmentsModel();
        setterClass.setRequestModelFromBean(requestAppointmentsModel, requestAppointmentsBean);

        DaoFactory daoFactory = DaoFactory.getFactory(ModeManager.get());
        RequestAppointmentsDao requestAppointments = daoFactory.requestAppointmentsDao();
        requestAppointments.addAppointments(requestAppointmentsModel);
    }


    public void manageRequestAppointments(Observer observer, int id, String role) throws SystemException{
        manageRequestBeanList = new ManageRequestBeanList(observer);
        manageRequestBeanList.addRequestsToList(searchRequestById(id, role));
    }

    public void setStateAppointments(RequestAppointmentsBean rBean, StatoRichieste state) throws SystemException {
        updateStateAppointments(rBean.getIdAppointement(), state);
    }


    public void addAppointmentsToList(RequestAppointmentsBean requestAppointmentsBean){
        manageRequestBeanList.addRequest(requestAppointmentsBean);
    }

    //tutte le richieste che ha mandato un utente
    private List<RequestAppointmentsBean> searchRequestById(int id, String role) throws SystemException {
        DaoFactory daoFactory = DaoFactory.getFactory(ModeManager.get());
        RequestAppointmentsDao requestAppointmentsDao = daoFactory.requestAppointmentsDao();
        List<RequestAppointmentsModel> list = requestAppointmentsDao.getAllRequestAppointments(id, role);
        List<RequestAppointmentsBean> listBean = new ArrayList<>();
        for(RequestAppointmentsModel requestAppointmentsModel : list){
            RequestAppointmentsBean bean = new RequestAppointmentsBean();
            setterClass.setRequestAppBeanFromModel(bean, requestAppointmentsModel);
            listBean.add(bean);
        }

        return listBean;
    }


    private void updateStateAppointments(int id, StatoRichieste state) throws SystemException{
        DaoFactory daoFactory = DaoFactory.getFactory(ModeManager.get());
        RequestAppointmentsDao requestAppointmentsDao = daoFactory.requestAppointmentsDao();
        requestAppointmentsDao.updateStateByIdApp(id, state.getId());
    }

}
