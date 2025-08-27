package com.example.barber.controller.guicontroller.interface1;

import com.example.barber.utils.exception.ErrorDialog;
import com.example.barber.utils.exception.myexception.SystemException;
import com.example.barber.utils.switchpage.SwitchPage;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

import java.io.IOException;

public class WelcomePageGuiController1 {
    @FXML
    private Button signInButton;

    private SwitchPage sp = new SwitchPage();

    @FXML
    private void goToRegistrationChoice(ActionEvent event) throws IOException {
        try{
            sp.replaceScene(event, "/registrationChoice.fxml");
        }catch(SystemException e){
            ErrorDialog.getInstance().handleException(e);
        }

    }


    @FXML
    public void switchInterface(ActionEvent event) throws IOException {
        try {
            sp.replaceScene(event, "/WelcomePage2.fxml");
        } catch (SystemException e) {
            ErrorDialog.getInstance().handleException(e);
        }
    }


    @FXML
    private void goToLogin(ActionEvent event) throws IOException {
        try{
            sp.replaceScene(event, "/Login.fxml");
        }catch(SystemException e){
            ErrorDialog.getInstance().handleException(e);
        }

    }
}
