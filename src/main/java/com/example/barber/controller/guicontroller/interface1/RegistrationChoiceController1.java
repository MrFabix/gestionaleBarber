package com.example.barber.controller.guicontroller.interface1;

import com.example.barber.utils.exception.ErrorDialog;
import com.example.barber.utils.exception.myexception.SystemException;
import com.example.barber.utils.switchpage.SwitchPage;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

public class RegistrationChoiceController1 {
    private SwitchPage sp = new SwitchPage();
    @FXML
    private void onSingInUser(ActionEvent event) {
      try {
          sp.replaceScene(event, "/signInUser1.fxml");
      }catch(SystemException e){
          ErrorDialog.getInstance().handleException(e);
      }
    }
    @FXML
    private void onSignInBarber(ActionEvent event) {
        try {
            sp.replaceScene(event, "/signInBarber1.fxml");
        }catch(SystemException e){
            ErrorDialog.getInstance().handleException(e);
        }
    }
    @FXML
    private void backToWelcomePage(ActionEvent event) {
        try {
            sp.replaceScene(event, "/welcomePage1.fxml");
        }catch (SystemException e){
            ErrorDialog.getInstance().handleException(e);
        }
    }
}
