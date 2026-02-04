package com.example.barber.controller.guicontroller.interface1.item;

import com.example.barber.utils.bean.RequestAppointmentsBean;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.Button;
import com.example.barber.utils.scene.SwitchPage;
import javafx.event.ActionEvent;

public class AppointmentsItemUserGuiController1 extends AppointemntsItemGuiController{

    @FXML
    private Label labelIndirizzo;
    @FXML
    private Button buttonRecensione;

    private RequestAppointmentsBean rBean;
    private SwitchPage switchPage = new SwitchPage();

    public void setAll(RequestAppointmentsBean rBean){
        this.rBean = rBean;
        labelIndirizzo.setText(rBean.getAddressBarber());
        super.bind(rBean.getNameUser(), rBean.getDate().toString(), rBean.getOrario(), rBean.getService(), rBean.getState().getId());
        if (rBean.getState().getId().equals("TERMINATA")) {
            buttonRecensione.setVisible(true);
        } else {
            buttonRecensione.setVisible(false);
        }
    }

    @FXML
    public void onRecensioneClick(ActionEvent event) {
        try {
            switchPage.replaceScene(event, "/view/interface1/clienteRecensioni.fxml");
        } catch (com.example.barber.utils.exception.myexception.SystemException e) {
            // Gestione dell'errore, puoi mostrare un dialogo o loggare
            e.printStackTrace();
        }
    }
}
