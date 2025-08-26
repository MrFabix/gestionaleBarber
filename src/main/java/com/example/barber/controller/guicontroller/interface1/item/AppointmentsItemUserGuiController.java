package com.example.barber.controller.guicontroller.interface1.item;

import com.example.barber.utils.bean.RequestAppointmentsBean;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;


public class AppointmentsItemUserGuiController {

    @FXML
    private Label labelNameBarber;
    @FXML
    private Label indirizzo;
    @FXML
    private Label orario;
    @FXML
    private Label servizio;
    @FXML
    private Label stato;
    @FXML
    private Label labelData;



    public void setAll(RequestAppointmentsBean rBean){
        this.labelNameBarber.setText(rBean.getNameBarber());
        this.indirizzo.setText(rBean.getAddressBarber());
        this.orario.setText(rBean.getOrario());
        this.stato.setText(rBean.getState().getId());
        this.servizio.setText(rBean.getService());
        this.labelData.setText(rBean.getDate().toString());
    }
}
