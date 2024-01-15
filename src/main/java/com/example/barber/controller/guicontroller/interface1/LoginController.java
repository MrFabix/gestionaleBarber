package com.example.barber.controller.guicontroller.interface1;

import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import java.io.IOException;

public class LoginController {

    @FXML
    private TextField usernameField;
    @FXML
    private PasswordField passwordField;


    @FXML
    protected void onloginButton() throws IOException {
        //prendo i valori inseriti dall'utente
        String username = usernameField.getText();
        String password = passwordField.getText();


    }

}