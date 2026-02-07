package com.example.barber.controller.guicontroller.interface1.item;

import com.example.barber.utils.bean.IdBean;
import com.example.barber.utils.bean.RequestAppointmentsBean;
import com.example.barber.utils.exception.ErrorDialog;
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

    private SwitchPage switchPage = new SwitchPage();

    public void setAll(RequestAppointmentsBean rBean){
        labelIndirizzo.setText(rBean.getAddressBarber());
        super.bind(rBean.getNameUser(), rBean.getDate().toString(), rBean.getOrario(), rBean.getService(), rBean.getState().getId());
        buttonRecensione.setVisible(rBean.getState().getId().equals("TERMINATA"));
        buttonRecensione.setUserData(rBean.getIdAppointement()); // oppure rBean.getIdAppuntamento() se serve l'id appuntamento
    }

    @FXML
    public void onRecensioneClick(ActionEvent event) {
        IdBean idBean = new IdBean();
        idBean.setId((int) buttonRecensione.getUserData());//id dell'appuntamento
        try {
            switchPage.switchPageId( "/view/interface1/clienteRecensioneForm1.fxml", event,idBean);
        } catch (com.example.barber.utils.exception.myexception.SystemException e) {
            ErrorDialog.getInstance().handleException(e);
        }
    }
}
