package com.example.barber.controller.guicontroller.interface2.item2;


import com.example.barber.utils.bean.interfaccia2.RequestAppointmentsBean2;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

import java.time.format.DateTimeFormatter;
import java.util.Locale;


public class AppointmentsItemUserGuiControllerSecondInterface{

    @FXML
    private Label labelName;
    @FXML
    private Label labelIndirizzo;
    @FXML
    private Label labelServizio;
    @FXML
    private Label labelData;
    @FXML
    private Label labelOrario;
    @FXML
    private Label labelStato;


    public void setAll(RequestAppointmentsBean2 rBean){
        System.out.println("Sei dentro il sett all del item cotntrolle"+rBean.getIdAppointement());
        System.out.println("Sei dentro il sett all del item cotntrolle"+rBean.getNameBarber());
        System.out.printf("Item -> barber=%s, addr=%s, serv=%s, data=%s, ora=%s, stato=%s%n",
                rBean.getNameBarber(), rBean.getAddressBarber(), rBean.getService(),
                rBean.getDate(), rBean.getOrario(), rBean.getState());

        labelName.setText(rBean.getNameBarber());
        labelIndirizzo.setText(rBean.getAddressBarber());
        labelServizio.setText(rBean.getService());
        labelOrario.setText(rBean.getOrario());
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy", Locale.ITALY);
        labelData.setText(rBean.getDate() != null ? rBean.getDate().format(fmt) : "");
        labelStato.setText(rBean.getState().getId());
    }
}
