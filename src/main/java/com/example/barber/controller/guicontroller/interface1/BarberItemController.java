package com.example.barber.controller.guicontroller.interface1;

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
    public void setBarberDetails(String name, String city,String address) {
        barberNameLabel.setText(name);
        barberCityLabel.setText(city);
        barberAddressLabel.setText(address);

    }





}
