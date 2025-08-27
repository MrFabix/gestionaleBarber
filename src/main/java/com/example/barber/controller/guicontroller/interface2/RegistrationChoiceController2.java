package com.example.barber.controller.guicontroller.interface2;

import com.example.barber.utils.exception.ErrorDialog;
import com.example.barber.utils.exception.myexception.SystemException;
import com.example.barber.utils.switchpage.SwitchPage;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

public class RegistrationChoiceController2 {
    private SwitchPage switchP = new SwitchPage();
    @FXML
    private void userSign(ActionEvent event) {
      try {
          switchP.replaceScene(event, "/view/interface2/signInUser2.fxml");
      }catch(SystemException e){
          ErrorDialog.getInstance().handleException(e);
      }
    }
    @FXML
    private void barberSign(ActionEvent event) {
        try {
            switchP.replaceScene(event, "/view/interface2/signInBarber2.fxml");
        }catch(SystemException e){
            ErrorDialog.getInstance().handleException(e);
        }
    }
    @FXML
    private void goBack(ActionEvent event) {
        try {
            switchP.replaceScene(event, "/view/interface2/welcomePage2.fxml");
        }catch (SystemException e){
            ErrorDialog.getInstance().handleException(e);
        }
    }
}
