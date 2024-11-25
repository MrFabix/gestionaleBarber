package com.example.barber.controller.appcontroller;

import com.example.barber.model.BarberModel;
import com.example.barber.utils.bean.BarberBean;
import com.example.barber.utils.dao.BarberDAO;
import com.example.barber.utils.exception.Trigger;
import com.example.barber.utils.switchPage.SwitchPage;

public class BarberAppController {
    Trigger trigger = new Trigger();
    SwitchPage sp = new SwitchPage();
    public BarberAppController() {
    }

    //funzione per prendere i dettagli del barbiere dal DB
    public BarberBean getBarberDetails(int id) {
        // Creare una nuova istanza del BarberDAO per prendere i dettagli
        BarberDAO barberDAO = new BarberDAO();

        try {
            // Chiamare il metodo DAO per ottenere il BarberBean

            // Ritorna il BarberBean
            return new  BarberBean(barberDAO.getBarberById(id));
        } catch (Exception e) {
            System.out.println("Errore nel prendere i dettagli del barbiere: " + e.getMessage());
            return null;
        }
    }


}
