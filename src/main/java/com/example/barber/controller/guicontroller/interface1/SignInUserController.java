package com.example.barber.controller.guicontroller.interface1;


import com.example.barber.controller.appcontroller.SignInAppController;
import com.example.barber.utils.bean.SignInBean;
import com.example.barber.utils.exception.ErrorDialog;
import com.example.barber.utils.exception.myexception.SystemException;
import com.example.barber.utils.switchPage.SwitchPage;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import java.io.IOException;

//import javafx.scene.control.CheckBox;
public class SignInUserController {

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

    @FXML
    private ComboBox ruolo;

    private SwitchPage sp = new SwitchPage();

    private void registrationButton(ActionEvent event){

    }
    @FXML
    private void backToWelcomePage(ActionEvent event) throws IOException {
        try{
            sp.replaceScene(event, "/interface1/welcomePage.fxml");
        }catch(SystemException e){
            ErrorDialog.getInstance().handleException(e);
        }
    }
    @FXML
    private void signIn(ActionEvent event){

        SignInAppController controller = new SignInAppController();
        SignInBean signinBean = new SignInBean(usernameField.getText(), passwordField.getText(), emailField.getText(), ruolo.getValue().toString());
        controller.registration(signinBean);
    }
}
