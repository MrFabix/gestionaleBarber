package com.example.barber.controller.guicontroller.interface1;

import com.example.barber.utils.exception.ErrorDialog;
import com.example.barber.utils.exception.myexception.SystemException;
import com.example.barber.utils.managermode.Mode;
import com.example.barber.utils.managermode.ModeManager;
import com.example.barber.utils.scene.SwitchPage;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;

import java.io.IOException;

public class WelcomePageGuiController1 {
    @FXML
    private Button signInButton;

    private SwitchPage sp = new SwitchPage();

    @FXML
    private void goToRegistrationChoice(ActionEvent event) {
        try{
            sp.replaceScene(event, "/view/interface1/registrationChoice1.fxml");
        }catch(SystemException e){
            ErrorDialog.getInstance().handleException(e);
        }

    }


    @FXML
    public void switchInterface(ActionEvent event)  {
        try {
            sp.replaceScene(event, "/view/interface2/WelcomePage2.fxml");
        } catch (SystemException e) {
            ErrorDialog.getInstance().handleException(e);
        }
    }


    @FXML
    private void goToLogin(ActionEvent event) {
        try{
            sp.replaceScene(event, "/view/interface1/Login1.fxml");
        }catch(SystemException e){
            ErrorDialog.getInstance().handleException(e);
        }

    }

    @FXML
    private void attivaDemo(ActionEvent event) {
        ModeManager.set(Mode.DEMO);
        Alert ok = new Alert(Alert.AlertType.INFORMATION);
        ok.setTitle("Modalità");
        ok.setHeaderText(null);
        ok.setContentText("Modalità DEMO attivata");
        ok.showAndWait();
    }

    @FXML
    private void disattivaDemo(ActionEvent event) {
        ModeManager.set(Mode.REAL);
        Alert ok = new Alert(Alert.AlertType.INFORMATION);
        ok.setTitle("Modalità");
        ok.setHeaderText(null);
        ok.setContentText("Modalità DEMO attivata");
        ok.showAndWait();
    }


}
