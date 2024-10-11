package com.example.barber.controller.guicontroller.interface1;

import com.example.barber.utils.exception.ErrorDialog;
import com.example.barber.utils.exception.myexception.SystemException;
import com.example.barber.utils.switchPage.SwitchPage;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

import java.io.IOException;

public class WelcomePageController {
    @FXML
    private Button signInButton;

    private SwitchPage sp = new SwitchPage();

    @FXML
    private void goToRegistrationChoice(ActionEvent event) throws IOException {
        try{
            sp.replaceScene(event, "/interface1/registrationChoice.fxml");
        }catch(SystemException e){
            ErrorDialog.getInstance().handleException(e);
        }

    }
    @FXML
    private void goToLogin(ActionEvent event) throws IOException {
        try{
            sp.replaceScene(event, "/interface1/Login.fxml");
        }catch(SystemException e){
            ErrorDialog.getInstance().handleException(e);
        }

    }
}
