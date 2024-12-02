package com.example.barber.controller.guicontroller.interface1;

import com.example.barber.utils.bean.BarberBean;
import com.example.barber.utils.bean.CredentialsBean;
import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class SignInBarberController {
    //TODO gestione della registrazione come barbiere

    //Dichiariamo i bean per la registrazione
    BarberBean barberBean = new BarberBean();
    CredentialsBean credentialsBean = new CredentialsBean();

    @FXML
    private TextField barberShopField;
    @FXML
    private TextField addressField;
    @FXML
    private TextField cityField;
    @FXML
    private TextField phoneField;
    @FXML
    private TextField emailField;
    @FXML
    private PasswordField passwordField;
    @FXML
    private TextField usernameField;
    @FXML
    private PasswordField confirmPasswordField;

}
