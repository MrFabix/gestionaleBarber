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


}
