package com.example.barber.utils.observer;

import com.example.barber.utils.bean.RequestAppointmentsBean;

import java.util.ArrayList;
import java.util.List;

public class ManageRequestBeanList extends Subject{

    private List<RequestAppointmentsBean> beans;

    public ManageRequestBeanList(Observer observer) {
        super(observer);
        beans = new ArrayList<>();
    }

    public void addRequestsToList(List<RequestAppointmentsBean> listBean) {
        if (listBean != null && !listBean.isEmpty()) {
            for (RequestAppointmentsBean manageRequestBean : listBean) {
                beans.add(manageRequestBean);
                notify(manageRequestBean);
            }
        }
    }

    public void addRequest(RequestAppointmentsBean bean) {
        if (beans != null) {
            beans.add(bean);
            notify(bean);
        }
    }

}
