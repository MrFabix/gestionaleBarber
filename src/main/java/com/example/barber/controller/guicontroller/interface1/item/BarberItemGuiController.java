package com.example.barber.controller.guicontroller.interface1.item;

import com.example.barber.utils.bean.IdBean;
import com.example.barber.utils.bean.interfaccia1.BarberBean1;
import com.example.barber.utils.exception.myexception.SystemException;
import com.example.barber.utils.switchPage.SwitchPage;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class BarberItemGuiController {

    @FXML
    private Label barberNameLabel;
    @FXML
    private Label barberCityLabel;
    @FXML
    private Label barberAddressLabel;
    @FXML
    private Button barberButton;


    private SwitchPage sp = new SwitchPage();

    // Metodo per impostare i dettagli del barbiere
    public void setBarberDetails(BarberBean1 bean) {
        barberNameLabel.setText(bean.getName());
        barberCityLabel.setText(bean.getCity());
        barberAddressLabel.setText(bean.getAddress());
        // Usa setUserData per associare l'ID al pulsante
        barberButton.setUserData(bean.getId());
    }


    @FXML
    private void showBarberDetails(ActionEvent event) throws SystemException {
        //Recupera l'ID dal pulsante tramite getUserData
        int id = (int) barberButton.getUserData();
        //creo il bean per passare l'id
        IdBean idBean = new IdBean(id);
        //cambio pagina passando l'id del barbiere
        sp.switchPageId("/view/interface1/BarberDetail.fxml", event, idBean);
    }









}
