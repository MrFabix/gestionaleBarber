package com.example.barber.controller.guicontroller.interface1;

import com.example.barber.controller.appcontroller.LoginAppController;
import com.example.barber.utils.bean.CredentialsBean;
import com.example.barber.utils.exception.ErrorDialog;
import com.example.barber.utils.exception.myexception.EmptyInputException;
import com.example.barber.utils.exception.myexception.SystemException;
import com.example.barber.utils.exception.myexception.WrongCredentialsException;
import com.example.barber.utils.switchPage.SwitchPage;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.io.IOException;


public class LoginController {

    @FXML
    private TextField usernameField;
    @FXML
    private PasswordField passwordField;
    @FXML
    private CheckBox checkBoxBarber;
    @FXML
    private Button loginButton;

    private SwitchPage sp = new SwitchPage();
    @FXML
    private void onloginButton(ActionEvent event) {
        String type = "user";
        LoginAppController controller;

        try {
            // Verifica se il campo username è vuoto
            if (usernameField.getText().isEmpty()) {
                throw new EmptyInputException("username");
            }

            // Verifica se il campo password è vuoto
            if (passwordField.getText().isEmpty()) {
                throw new EmptyInputException("password");
            }

            // Se la checkbox è selezionata, imposta il tipo a "barber"
            if (checkBoxBarber.isSelected()) {
                type = "barber";
            }
            // Inizializza il controller e tenta il login
            controller = new LoginAppController();
            CredentialsBean credentialsBean = new CredentialsBean(usernameField.getText(), passwordField.getText(), type);
            controller.login(credentialsBean);

        } catch (EmptyInputException e) {
            // Gestisce il caso dei campi vuoti mostrando un messaggio di errore
            ErrorDialog.getInstance().handleException(e);
        } catch (SystemException | WrongCredentialsException e) {
            // Gestisce altri tipi di eccezioni
            ErrorDialog.getInstance().handleException(e);
        }


    }

    @FXML
    private void backToWelcomePage(ActionEvent event) throws IOException {
        try{
            sp.replaceScene(event, "/interface1/welcomePage.fxml");
        }catch(SystemException e){
            ErrorDialog.getInstance().handleException(e);
        }
    }





}

