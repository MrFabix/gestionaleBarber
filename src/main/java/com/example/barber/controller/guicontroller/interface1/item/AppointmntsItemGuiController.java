package com.example.barber.controller.guicontroller.interface1.item;


import javafx.fxml.FXML;
import javafx.scene.control.Label;

abstract class AppointemntsItemGuiController {

    @FXML
    protected Label labelName;
    @FXML
    protected Label labelData;
    @FXML
    protected Label labelOrario;
    @FXML
    protected Label labelServizio;
    @FXML
    protected Label labelStato;

    protected void bind(String name, String data, String orario, String servizio, String stato) {
        labelName.setText(name);
        labelData.setText(data);
        labelOrario.setText(orario);
        labelServizio.setText(servizio);
        labelStato.setText(stato);
    }


}
