package com.example.barber.controller.appcontroller;

import com.example.barber.model.RequestAppointmentsModel;
import com.example.barber.utils.bean.RequestAppointmentsBean;
import com.example.barber.utils.dao.sql.RequestAppointmentsDAO;
import com.example.barber.utils.exception.ErrorDialog;
import com.example.barber.utils.exception.myexception.SystemException;



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
}
