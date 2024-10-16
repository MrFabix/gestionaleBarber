package com.example.barber.controller.guicontroller.interface1;

import com.example.barber.utils.exception.ErrorDialog;
import com.example.barber.utils.exception.myexception.SystemException;
import com.example.barber.utils.switchPage.SwitchPage;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

public class RegistrationChoiceController {
    private SwitchPage sp = new SwitchPage();
    @FXML
    private void onSingInUser(ActionEvent event) {
      try {
          sp.replaceScene(event, "/signInUser.fxml");
      }catch(SystemException e){
          ErrorDialog.getInstance().handleException(e);
      }
    }
    @FXML
    private void onSignInBarber(ActionEvent event) {
        try {
            sp.replaceScene(event, "/signInBarber.fxml");
        }catch(SystemException e){
            ErrorDialog.getInstance().handleException(e);
        }
    }
    @FXML
    private void backToWelcomePage(ActionEvent event) {
        try {
            sp.replaceScene(event, "/welcomePage.fxml");
        }catch (SystemException e){
            ErrorDialog.getInstance().handleException(e);
        }
    }
}
