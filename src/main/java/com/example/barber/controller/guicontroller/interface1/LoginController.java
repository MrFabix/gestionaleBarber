package com.example.barber.controller.guicontroller.interface1;

import com.example.barber.controller.appcontroller.LoginAppController;
import com.example.barber.utils.bean.CredentialsBean;
import com.example.barber.utils.exception.ErrorDialog;
import com.example.barber.utils.exception.myecxeption.SystemException;
import com.example.barber.utils.exception.myecxeption.WrongCredentialsException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import java.io.IOException;


public class LoginController {

    @FXML
    private TextField usernameField;
    @FXML
    private PasswordField passwordField;
    @FXML
    private CheckBox checkBoxBarber;
    @FXML
    private Button loginButton;

    @FXML
    private Button signInButton;
    @FXML
    private void onloginButton(ActionEvent event) {
        String type = "user";
        LoginAppController controller;
        if (checkBoxBarber.isSelected()) {
            type = "barber";
        }
        try {
            controller = new LoginAppController();
            CredentialsBean credentialsBean = new CredentialsBean(usernameField.getText(), passwordField.getText(), type);
            controller.login(credentialsBean);
        } catch (SystemException | WrongCredentialsException e) {
            ErrorDialog.getInstance().handleException(e);
        }
    }
    @FXML
    private void onSignInbutton(ActionEvent event) throws IOException {
     //da implementare
    }


}

