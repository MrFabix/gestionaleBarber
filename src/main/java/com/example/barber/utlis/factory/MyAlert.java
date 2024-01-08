package com.example.barber.utlis.factory;

import javafx.scene.control.Alert;

public class MyAlert implements MyDialogBox {
    @Override
    public void useMyDialogBox(String message) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Warning!");
        alert.setHeaderText(message);
        alert.showAndWait();
    }
}