package com.example.barber.controller.guicontroller.interface2.item2;


import com.example.barber.utils.bean.IdBean;
import com.example.barber.utils.bean.interfaccia2.RequestAppointmentsBean2;
import com.example.barber.utils.scene.SwitchPage;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
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
    @FXML
    private Button buttonRecensione;

    private SwitchPage switchPage = new SwitchPage();


    public void setAll(RequestAppointmentsBean2 rBean){
        labelName.setText(rBean.getNameBarber());
        labelIndirizzo.setText(rBean.getAddressBarber());
        labelServizio.setText(rBean.getService());
        labelOrario.setText(rBean.getOrario());
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy", Locale.ITALY);
        labelData.setText(rBean.getDate() != null ? rBean.getDate().format(fmt) : "");
        labelStato.setText(rBean.getState().getId());
        buttonRecensione.setVisible(rBean.getState().getId().equals("TERMINATA"));
        buttonRecensione.setUserData(rBean.getIdAppointement());
    }

    @FXML
    public void onRecensioneClick(ActionEvent event) {
        IdBean idBean = new IdBean();
        idBean.setId((int) buttonRecensione.getUserData());
        try {
            switchPage.switchPageId("/view/interface2/clienteRecensioneForm2.fxml", event, idBean);
        } catch (com.example.barber.utils.exception.myexception.SystemException e) {
            e.printStackTrace();
        }
    }
}
