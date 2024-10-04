package com.example.barber.controller.guicontroller.interface1;


import com.example.barber.utils.exception.ErrorDialog;
import com.example.barber.utils.exception.myecxeption.SystemException;
import com.example.barber.utils.switchPage.SwitchPage;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import java.io.IOException;

//import javafx.scene.control.CheckBox;
public class SignInController {

    @FXML
    private TextField usernameField;
    @FXML
    private TextField emailField;
    @FXML
    private TextField emailRepeatField;
    @FXML
    private Button signInButton;
    @FXML
    private PasswordField passwordField;
    @FXML
    private PasswordField confirmPasswordField;

    private SwitchPage sp = new SwitchPage();

    private void registrationButton(ActionEvent event){

    }
    @FXML
    private void backToLogin(ActionEvent event) throws IOException {
        try{
            sp.replaceScene(event, "/interface1/Login.fxml");
        }catch(SystemException e){
            ErrorDialog.getInstance().handleException(e);
        }
    }
}
