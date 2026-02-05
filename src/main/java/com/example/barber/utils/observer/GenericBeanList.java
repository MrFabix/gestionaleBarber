package com.example.barber.utils.observer;

import com.example.barber.utils.bean.*;
import java.util.List;
import java.util.ArrayList;

    public class GenericBeanList extends Subject {
    private List<GenericBean> beans;




    public GenericBeanList(Observer observer) {
        super(observer);
        beans = new ArrayList<>();
    }

    public void addBarbersToList(List<BarberBean> listBean) {
        if (listBean != null && !listBean.isEmpty()) {
            for (BarberBean barberBean : listBean) {
                beans.add(barberBean);
                notify(barberBean);
            }
        }
    }

    //Aggiungo gli appuntamenti alla lista degli appuntamnti pendenti del barbiere
    public void addAppointmentsPendingList(List<RequestAppointmentsBean> listBean) {
        if(listBean != null && !listBean.isEmpty()) {
            for (RequestAppointmentsBean requestAppointmentsBean : listBean) {
                beans.add(requestAppointmentsBean);
                notify(requestAppointmentsBean);
            }
        }
    }

    //Aggiungo le recensioni alla lista delle recensioni del barbiere
    public void addRecensioniToList(List<RecensioneBean> listBean) {
        if(listBean != null && !listBean.isEmpty()) {
            for (RecensioneBean recensioneBean : listBean) {
                beans.add(recensioneBean);
                notify(recensioneBean);
            }
        }
    }




}
