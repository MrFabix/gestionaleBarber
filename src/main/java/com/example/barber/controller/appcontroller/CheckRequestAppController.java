package com.example.barber.controller.appcontroller;

import com.example.barber.model.RequestAppointmentsModel;
import com.example.barber.utils.bean.RequestAppointmentsBean;
import com.example.barber.utils.dao.RequestAppointmentsDAO;
import com.example.barber.utils.exception.myexception.SystemException;
import com.example.barber.utils.observer.ManageRequestBeanList;
import com.example.barber.utils.observer.Observer;
import com.example.barber.utils.statorichiesta.StatoRichieste;

import java.util.ArrayList;
import java.util.List;

public class CheckRequestAppController {

    private Observer observer;
    private ManageRequestBeanList manageRequestBeanList;



    public void manageRequestAppointments(Observer observer, int idUser) throws SystemException {
        this.observer = observer;
        this.manageRequestBeanList = new ManageRequestBeanList(observer);
        manageRequestBeanList.addRequestsToList(searchRequestByIdUser(idUser));
    }



    //tutte le richieste che ha mandato un utente
    private List<RequestAppointmentsBean> searchRequestByIdUser(int idUser) throws SystemException{
        RequestAppointmentsDAO requestAppointmentsDAO = new RequestAppointmentsDAO();
        List<RequestAppointmentsModel> list = requestAppointmentsDAO.getAllRequestAppointments(idUser);
        List<RequestAppointmentsBean> listBean = new ArrayList<>();
        for(RequestAppointmentsModel requestAppointmentsModel : list){
            RequestAppointmentsBean bean = new RequestAppointmentsBean(requestAppointmentsModel);
            listBean.add(bean);
        }

        return listBean;
    }
}
