package com.example.barber.controller.appcontroller;

import com.example.barber.model.BarberModel;
import com.example.barber.utils.bean.BarberBean;
import com.example.barber.utils.bean.IdBean;
import com.example.barber.utils.dao.sql.BarberDAO;
import com.example.barber.utils.engineering.ListBarberEngineering;
import com.example.barber.utils.exception.Trigger;
import com.example.barber.utils.exception.myexception.SystemException;
import com.example.barber.utils.observer.GenericBeanList;
import com.example.barber.utils.observer.Observer;
import com.example.barber.utils.switchpage.SwitchPage;

import java.util.ArrayList;
import java.util.List;

public class BarberAppController {

    public BarberAppController() {
        // Costruttore
    }


    public BarberBean getBarberDetails(IdBean id) throws SystemException {
        BarberDAO barberDAO = new BarberDAO();
        return new BarberBean(barberDAO.getBarberById(id.getId())); //devo passare l'id del barbiere con un Bean

    }

    public void insertOrarioBarber(BarberBean barber) throws SystemException {
        BarberModel barberModel = new BarberModel();
        barberModel.setId(barber.getId());
        barberModel.setOrarioInizio(barber.getOrarioInizio());
        barberModel.setOrarioFine(barber.getOrarioFine());

        BarberDAO barberDAO = new BarberDAO();
        barberDAO.insertOrarioBarbiere(barberModel);
    }

    public void addToList(Observer ob) throws SystemException {
        ListBarberEngineering  listBarber = new ListBarberEngineering();
        List<BarberBean> list = new ArrayList<BarberBean>();
        listBarber.getAllBarber();
        GenericBeanList list1 = new GenericBeanList(ob);
        list1.addBarbersToList(listBarber.getAllBarber());
    }

    public void search(Observer ob, String search) throws SystemException {
        ListBarberEngineering listBarber = new ListBarberEngineering();
        GenericBeanList list = new GenericBeanList(ob);
        list.addBarbersToList(listBarber.getBarberByName(search));
    }



}
