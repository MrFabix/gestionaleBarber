package com.example.barber.controller.guicontroller.interface1;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class BarberItemController {

    @FXML
    private Label barberNameLabel;

    @FXML
    private Label barberCityLabel;
    @FXML
    private Label barberAddressLabel;

    




    // Metodo per impostare i dettagli del barbiere
    public void setBarberDetails(String name, String city,String address) {
        barberNameLabel.setText(name);
        barberCityLabel.setText(city);
        barberAddressLabel.setText(address);

    }
}
