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


public class LoginGuiController {

    @FXML
    private TextField usernameField;
    @FXML
    private PasswordField passwordField;
    @FXML
    private RadioButton radioBarber;
    @FXML
    private RadioButton radioAdmin;
    @FXML
    private Button loginButton;

    private SwitchPage sp = new SwitchPage();
    @FXML
    private void onloginButton(ActionEvent event) {
        String type = "user";
        LoginAppController controller;

        try {
            // Se la checkbox è selezionata, imposta il tipo a "barber"
            if (radioBarber.isSelected()) {
                type = "barber";
            } else if (radioAdmin.isSelected()) {
                type = "moderator";
            }

            System.out.println("type: " + type);

            // Inizializza il controller e tenta il login
            controller = new LoginAppController();
            CredentialsBean credentialsBean = new CredentialsBean(usernameField.getText(), passwordField.getText(), type);
            controller.login(credentialsBean);
            // Se il login è andato a buon fine, mostra la pagina corrispondente
            if (type.equals("user")) {
                sp.replaceScene(event, "/homepageUser.fxml");
            } else if (type.equals("barber")) {
                sp.replaceScene(event, "/homepageBarber.fxml");

            } else {
                sp.replaceScene(event, "/homepageModerator.fxml");
            }

        } catch (SystemException | WrongCredentialsException e) {
            // Gestisce altri tipi di eccezioni
            ErrorDialog.getInstance().handleException(e);


        }


    }

    @FXML
    private void backToWelcomePage(ActionEvent event)   {
        try{
            sp.replaceScene(event, "/welcomePage.fxml");
        }catch(SystemException e){
            ErrorDialog.getInstance().handleException(e);
        }
    }





}

