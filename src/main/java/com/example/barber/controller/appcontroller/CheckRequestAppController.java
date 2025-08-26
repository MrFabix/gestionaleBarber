package com.example.barber.controller.appcontroller;

import com.example.barber.controller.guicontroller.interface1.PageManageBarberAppointmentsGuiController;
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



    public void manageRequestAppointments(Observer observer, int id, String role) throws SystemException {
        this.observer = observer;
        this.manageRequestBeanList = new ManageRequestBeanList(observer);
        manageRequestBeanList.addRequestsToList(searchRequestById(id, role));
    }

    public void setStateAppointments(RequestAppointmentsBean rBean, StatoRichieste state) throws SystemException {
        updateStateAppointments(rBean.getIdAppointement(), state);
    }


    public void addAppointmentsToList(RequestAppointmentsBean requestAppointmentsBean){
        manageRequestBeanList.addRequest(requestAppointmentsBean);
    }

    //tutte le richieste che ha mandato un utente
    private List<RequestAppointmentsBean> searchRequestById(int id, String role) throws SystemException{
        RequestAppointmentsDAO requestAppointmentsDAO = new RequestAppointmentsDAO();
        List<RequestAppointmentsModel> list = requestAppointmentsDAO.getAllRequestAppointments(id, role);
        List<RequestAppointmentsBean> listBean = new ArrayList<>();
        for(RequestAppointmentsModel requestAppointmentsModel : list){
            RequestAppointmentsBean bean = new RequestAppointmentsBean(requestAppointmentsModel);
            listBean.add(bean);
        }

        return listBean;
    }


    private void updateStateAppointments(int id, StatoRichieste state) throws SystemException{
        RequestAppointmentsDAO requestAppointmentsDAO = new RequestAppointmentsDAO();
        requestAppointmentsDAO.updateStateByIdApp(id, state.getId());
    }

}
