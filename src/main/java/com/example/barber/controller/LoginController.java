package com.example.barber.controller;

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
        System.out.println("Username: " + username + " Password: " + password);


    }

}