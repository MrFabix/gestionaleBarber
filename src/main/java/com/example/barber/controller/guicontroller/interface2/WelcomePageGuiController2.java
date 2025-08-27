package com.example.barber.controller.guicontroller.interface2;

import com.example.barber.utils.switchpage.SwitchPage;
import com.example.barber.utils.exception.ErrorDialog;
import com.example.barber.utils.exception.myexception.SystemException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

import java.io.IOException;

public class WelcomePageGuiController2 {

        @FXML
        private Button signInButton;
        @FXML
        private Button signIn;

        private SwitchPage switchPage = new SwitchPage();
        private com.example.barber.utils.switchpage.SwitchPage sp = new com.example.barber.utils.switchpage.SwitchPage();

        @FXML
        public void goToRegistrationChoice(ActionEvent event) throws IOException {
            try{
                sp.replaceScene(event, "/view/interface2/registrationChoice2.fxml");
            }catch(SystemException e){
                ErrorDialog.getInstance().handleException(e);
            }

        }
        @FXML
        public void switchInterface(ActionEvent event) throws IOException {
            try {
                switchPage.replaceScene(event, "/view/interface1/WelcomePage1.fxml");
            } catch (SystemException e) {
                ErrorDialog.getInstance().handleException(e);
            }
        }

        @FXML
        public void goToLogin(ActionEvent event) throws IOException {
            try{
                sp.replaceScene(event, "/Login.fxml");
            }catch(SystemException e){
                ErrorDialog.getInstance().handleException(e);
            }

        }
}

