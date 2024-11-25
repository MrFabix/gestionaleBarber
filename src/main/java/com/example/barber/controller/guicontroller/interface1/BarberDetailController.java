package com.example.barber.controller.guicontroller.interface1;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;

import java.net.URL;
import java.util.ResourceBundle;

public class BarberDetailController {

    @FXML
    private ImageView barberImage;

    @FXML
    private Label barberName;

    @FXML
    private Label barberAddress;

    @FXML
    private Label barberPhone;

    @FXML
    private Label barberHours;

    @FXML
    private TextArea description;

    @FXML
    private ListView<String> servicesList;

    @FXML
    private ListView<String> reviewsList;

    @FXML
    private Button bookButton;

    //inizializzo la schermata prendendo i dati dal database in base all'id del barbiere
    public void initialize(URL location, ResourceBundle resources) {
        //TODO

    }
}
