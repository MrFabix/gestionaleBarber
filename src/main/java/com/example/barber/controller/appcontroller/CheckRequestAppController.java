package com.example.barber.controller.appcontroller;

import com.example.barber.model.RequestAppointmentsModel;
import com.example.barber.utils.bean.RequestAppointmentsBean;
import com.example.barber.utils.dao.sql.RequestAppointmentsDaoSql;
import com.example.barber.utils.exception.ErrorDialog;
import com.example.barber.utils.exception.myexception.SystemException;
import com.example.barber.utils.observer.ManageRequestBeanList;
import com.example.barber.utils.observer.Observer;
import com.example.barber.utils.setterandgetter.SetterClass;
import com.example.barber.utils.enumeration.statorichieste.StatoRichieste;

import java.util.ArrayList;
import java.util.List;

public class CheckRequestAppController {


    private ManageRequestBeanList manageRequestBeanList;
    private SetterClass setterClass = new SetterClass();

    public void sendAppointments(RequestAppointmentsBean requestAppointmentsBean) {
        RequestAppointmentsModel requestAppointmentsModel = new RequestAppointmentsModel();
        setterClass.setRequestModelFromBean(requestAppointmentsModel, requestAppointmentsBean);
        RequestAppointmentsDaoSql requestAppointmentsDaoSql = new RequestAppointmentsDaoSql();
        try{
            requestAppointmentsDaoSql.addAppointments(requestAppointmentsModel);
        }catch (SystemException e){
            ErrorDialog.getInstance().handleException(e);
        }
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
        RequestAppointmentsDaoSql requestAppointmentsDaoSql = new RequestAppointmentsDaoSql();
        List<RequestAppointmentsModel> list = requestAppointmentsDaoSql.getAllRequestAppointments(id, role);
        List<RequestAppointmentsBean> listBean = new ArrayList<>();
        for(RequestAppointmentsModel requestAppointmentsModel : list){
            RequestAppointmentsBean bean = new RequestAppointmentsBean();
            setterClass.setRequestAppBeanFromModel(bean, requestAppointmentsModel);
            listBean.add(bean);
        }

        return listBean;
    }


    private void updateStateAppointments(int id, StatoRichieste state) throws SystemException{
        RequestAppointmentsDaoSql requestAppointmentsDaoSql = new RequestAppointmentsDaoSql();
        requestAppointmentsDaoSql.updateStateByIdApp(id, state.getId());
    }

}
