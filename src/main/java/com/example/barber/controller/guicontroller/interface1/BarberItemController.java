package com.example.barber.controller.guicontroller.interface1;

import com.example.barber.utils.bean.BarberBean;
import com.example.barber.utils.exception.ErrorDialog;
import com.example.barber.utils.exception.myexception.SystemException;
import com.example.barber.utils.switchPage.SwitchPage;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class BarberItemController {

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
    public void setBarberDetails(String name, String city, String address, int id) {
        barberNameLabel.setText(name);
        barberCityLabel.setText(city);
        barberAddressLabel.setText(address);

        // Usa setUserData per associare l'ID al pulsante
        barberButton.setUserData(id);
    }


    @FXML
    private void showBarberDetails(ActionEvent event) throws SystemException {
        // Recupera l'ID dal pulsante tramite getUserData
        int id = (int) barberButton.getUserData();
        System.out.println("ID selezionato: " + id);
        //cambio pagina passando l'id del barbiere
        sp.switchPageId("/BarberDetail.fxml", event, id);

    }









}
