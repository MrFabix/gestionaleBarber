package com.example.barber.utils.engineering;

import com.example.barber.model.RequestAppointmentsModel;
import com.example.barber.utils.bean.RequestAppointmentsBean;
import com.example.barber.utils.dao.sql.RequestAppointmentsDAO;
import com.example.barber.utils.exception.myexception.EmptyInputException;
import com.example.barber.utils.exception.myexception.SystemException;
import com.example.barber.utils.setterandgetter.SetterClass;

import java.util.ArrayList;
import java.util.List;

public class ListAppointmentsEngineering {

    private SetterClass setterClass = new SetterClass();

    public List<RequestAppointmentsBean> getAllAppointments(int id, String role) throws SystemException, EmptyInputException{
        List<RequestAppointmentsModel> list = null;
        List<RequestAppointmentsBean> listBean = new ArrayList<>();
        RequestAppointmentsDAO requestAppointmentsDAO = new RequestAppointmentsDAO();
        list = requestAppointmentsDAO.getAllRequestAppointments(id,role);
        for (RequestAppointmentsModel model : list) {
            RequestAppointmentsBean bean = new RequestAppointmentsBean();
            setterClass.setRequestAppBeanFromModel(bean, model);
            listBean.add(bean);
        }
        return listBean;
    }

}
