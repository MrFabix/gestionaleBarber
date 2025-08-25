package com.example.barber.utils.engineering;

import com.example.barber.model.RequestAppointmentsModel;
import com.example.barber.utils.bean.RequestAppointmentsBean;
import com.example.barber.utils.dao.RequestAppointmentsDAO;
import com.example.barber.utils.exception.myexception.SystemException;

import java.util.ArrayList;
import java.util.List;

//Lista appuntamenti che verrà chiamata da HomePageRequestAppointents come cazzo lho chiamato vattelo a pesca mannaggia a me
public class ListAppointmentsEngineering {
    public List<RequestAppointmentsBean> getAllAppointments(int idUser) throws SystemException{
        List<RequestAppointmentsModel> list = null;
        List<RequestAppointmentsBean> listBean = new ArrayList<>();
        RequestAppointmentsDAO requestAppointmentsDAO = new RequestAppointmentsDAO();
        list = requestAppointmentsDAO.getAllRequestAppointments(idUser);
        for (RequestAppointmentsModel model : list) {
            RequestAppointmentsBean bean = new RequestAppointmentsBean(model);
            listBean.add(bean);
        }
        return listBean;



    }

}
