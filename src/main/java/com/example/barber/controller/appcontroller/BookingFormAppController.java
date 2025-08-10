package com.example.barber.controller.appcontroller;

import com.example.barber.model.RequestAppointmentsModel;
import com.example.barber.utils.bean.IdBean;
import com.example.barber.utils.bean.RequestAppointmentsBean;
import com.example.barber.utils.bean.UserBean;
import com.example.barber.utils.dao.RequestAppointmentsDAO;
import com.example.barber.utils.dao.UserDAO;
import com.example.barber.utils.exception.ErrorDialog;
import com.example.barber.utils.exception.myexception.SystemException;
import com.example.barber.utils.observer.ManageRequestBeanList;
import com.example.barber.utils.observer.Observer;


import java.util.List;

public class BookingFormAppController {

    public void sendAppointments(RequestAppointmentsBean requestAppointmentsBean) {
        System.out.println("Nome del barbiere: "+requestAppointmentsBean.getPhoneUser());
        System.out.println("Sei nel BookingFormAppController stai per aggiungere al db ");
        RequestAppointmentsModel requestAppointmentsModel = new RequestAppointmentsModel(requestAppointmentsBean);
        RequestAppointmentsDAO requestAppointmentsDAO = new RequestAppointmentsDAO();
      try{
          requestAppointmentsDAO.addAppointments(requestAppointmentsModel);
      }catch (SystemException e){
          ErrorDialog.getInstance().handleException(e);
      }
    }

    public void manageRequestAppointments(Observer observer, IdBean idBean){
        ManageRequestBeanList list = new ManageRequestBeanList(observer);
        list.addRequestsToList((searchRequestByIdUser(idBean.getId())));

    }

    //tutte le richieste che ha mandato un utente
    private List<RequestAppointmentsBean> searchRequestByIdUser(IdBean idBean){
        RequestAppointmentsDAO requestAppointmentsDAO = new RequestAppointmentsDAO();
        List<RequestAppointmentsModel> list = requestAppointmentsDAO.getAllRequestAppointments()
    }






}
