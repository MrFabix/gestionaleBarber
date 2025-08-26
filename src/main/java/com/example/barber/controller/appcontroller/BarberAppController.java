package com.example.barber.controller.appcontroller;

import com.example.barber.model.BarberModel;
import com.example.barber.utils.bean.BarberBean;
import com.example.barber.utils.bean.IdBean;
import com.example.barber.utils.dao.BarberDAO;
import com.example.barber.utils.exception.Trigger;
import com.example.barber.utils.exception.myexception.SystemException;
import com.example.barber.utils.switchpage.SwitchPage;

public class BarberAppController {
    Trigger trigger = new Trigger();
    SwitchPage sp = new SwitchPage();
    public BarberAppController() {
        // Costruttore
    }


    public BarberBean getBarberDetails(IdBean id) {
        BarberDAO barberDAO = new BarberDAO();
        try {
            return new BarberBean(barberDAO.getBarberById(id.getId())); //devo passare l'id del barbiere con un Bean
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public void insertOrarioBarber(BarberBean barber) throws SystemException {
        BarberModel barberModel = new BarberModel();
        barberModel.setId(barber.getId());
        barberModel.setOrarioInizio(barber.getOrarioInizio());
        barberModel.setOrarioFine(barber.getOrarioFine());

        BarberDAO barberDAO = new BarberDAO();
        barberDAO.insertOrarioBarbiere(barberModel);
    }


}
