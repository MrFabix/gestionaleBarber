package com.example.barber.controller.appcontroller;

import com.example.barber.model.RequestAppointmentsModel;
import com.example.barber.utils.bean.IdBean;
import com.example.barber.utils.bean.RequestAppointmentsBean;
import com.example.barber.utils.dao.RequestAppointmentsDAO;
import com.example.barber.utils.exception.ErrorDialog;
import com.example.barber.utils.exception.myexception.SystemException;
import com.example.barber.utils.observer.ManageRequestBeanList;
import com.example.barber.utils.observer.Observer;
import com.example.barber.utils.observer.Subject;
import javafx.beans.Observable;


public class BookingAppController{
    public void sendAppointments(RequestAppointmentsBean requestAppointmentsBean) {
        RequestAppointmentsModel requestAppointmentsModel = new RequestAppointmentsModel(requestAppointmentsBean);
        RequestAppointmentsDAO requestAppointmentsDAO = new RequestAppointmentsDAO();
        try{
          requestAppointmentsDAO.addAppointments(requestAppointmentsModel);
      }catch (SystemException e){
          ErrorDialog.getInstance().handleException(e);
      }
    }
    public void addToList(CheckRequestAppController checkRequestAppController, RequestAppointmentsBean rBean)  {
       checkRequestAppController.addAppointmentsToList(rBean);
    }








}
