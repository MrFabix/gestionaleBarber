package com.example.barber.controller.guicontroller.interface1.item;

import com.example.barber.utils.bean.RequestAppointmentsBean;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;


public class AppointmentsItemUserGuiController extends AppointemntsItemGuiController{

    @FXML
    private Label labelIndirizzo;



    public void setAll(RequestAppointmentsBean rBean){
        labelIndirizzo.setText(rBean.getAddressBarber());
        super.bind(rBean.getNameUser(), rBean.getDate().toString(), rBean.getOrario(), rBean.getService(), rBean.getState().getId());
    }
}
