package com.example.barber.controller.guicontroller.interface2;

import com.example.barber.utils.scene.SwitchPage;
import com.example.barber.utils.exception.ErrorDialog;
import com.example.barber.utils.exception.myexception.SystemException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

import java.io.IOException;

public class WelcomePageGuiController2 {

        private SwitchPage sPage = new SwitchPage();
        private com.example.barber.utils.scene.SwitchPage sp = new com.example.barber.utils.scene.SwitchPage();

        @FXML
        public void choiceRegistration(ActionEvent event) throws IOException {
            try{
                sp.replaceScene(event, "/view/interface2/registrationChoice2.fxml");
            }catch(SystemException e){
                ErrorDialog.getInstance().handleException(e);
            }

        }
        @FXML
        public void Login(ActionEvent event) throws IOException {
            try{
                sp.replaceScene(event, "/view/interface2/Login2.fxml");
            }catch(SystemException e){
                ErrorDialog.getInstance().handleException(e);
            }

        }
        @FXML
        public void changeInterface(ActionEvent event) throws IOException {
            try {
                sPage.replaceScene(event, "/view/interface1/WelcomePage1.fxml");
            } catch (SystemException e) {
                ErrorDialog.getInstance().handleException(e);
            }
        }


}

