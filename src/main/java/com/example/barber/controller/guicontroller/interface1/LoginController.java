package com.example.barber.controller.guicontroller.interface1;

import com.example.barber.controller.appcontroller.LoginAppController;
import com.example.barber.utlis.bean.CredentialsBean;
import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import org.controlsfx.control.action.Action;

import java.io.IOException;

public class LoginController {

    @FXML
    private TextField usernameField;
    @FXML
    private PasswordField passwordField;
    @FXML
    private CheckBox checkBoxBarber;


    @FXML
    protected void onloginButton(Action ae)  {
        String type ="user";
        LoginAppController controller;
        if(checkBoxBarber.isSelected()) {type = "barber";}
        try {
            controller = new LoginAppController();
            CredentialsBean credentialsBean = new CredentialsBean(usernameField.getText(), passwordField.getText(), type);
            controller.login(credentialsBean);




        } catch (IOException e) {
            e.printStackTrace();
        }


    }

}