package com.example.barber.controller.guicontroller.interface1;

import com.example.barber.controller.appcontroller.SignInAppController;
import com.example.barber.utils.bean.BarberBean;
import com.example.barber.utils.bean.CredentialsBean;
import com.example.barber.utils.exception.ErrorDialog;
import com.example.barber.utils.exception.myexception.*;
import com.example.barber.utils.switchPage.SwitchPage;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import java.io.IOException;

public class SignInBarberController {
    //TODO gestione della registrazione come barbiere

    //Dichiariamo i bean per la registrazione
    BarberBean barberBean = new BarberBean();
    CredentialsBean credentialsBean = new CredentialsBean();

    @FXML
    private TextField barberShopField;
    @FXML
    private TextField addressField;
    @FXML
    private TextField cityField;
    @FXML
    private TextField phoneField;
    @FXML
    private TextField emailField;
    @FXML
    private PasswordField passwordField;
    @FXML
    private TextField usernameField;
    @FXML
    private PasswordField confirmPasswordField;

    private String roleField;

    private SwitchPage sp = new SwitchPage();

    @FXML
    private void backToWelcomePage(ActionEvent event) throws IOException {
        try {
            sp.replaceScene(event, "/welcomePage.fxml");
        } catch (SystemException e) {
            ErrorDialog.getInstance().handleException(e);
        }
    }

    @FXML
    private void signInBarber(ActionEvent event) {
        CredentialsBean credentiaBean;
        SignInAppController appController;
        try {
            credentialsBean = new CredentialsBean();
            appController = new SignInAppController();

            //Credenziali
            credentialsBean.setUsername(usernameField.getText());
            credentialsBean.setPassword(passwordField.getText(), confirmPasswordField.getText());

            roleField = "barber";
            credentialsBean.setType(roleField);


            //Carichiamo il barberBean
            barberBean.setName(barberShopField.getText());
            barberBean.setPhone(phoneField.getText());
            barberBean.setCity(cityField.getText());
            barberBean.setAddress(addressField.getText());
            barberBean.setEmail(emailField.getText());
            barberBean.setUsername(usernameField.getText());


            //Passiamo tutto al controller che si occupa di gestire l'inserimento dela barbiere e delle sue credenziali
            appController.registerBarber(barberBean, credentialsBean);
            sp.replaceScene(event, "/welcomePage.fxml");


        } catch (EmptyInputException e) {
            ErrorDialog.getInstance().handleException(e);
        } catch (EmailNotValidException e) {
            ErrorDialog.getInstance().handleException(e);
        } catch (PasswordNotCompliantException e) {
            ErrorDialog.getInstance().handleException(e);
        } catch (PasswordNotEquals e) {
            ErrorDialog.getInstance().handleException(e);
        } catch (SystemException e) {
            ErrorDialog.getInstance().handleException(e);
        } catch (UsernameAlreadyTakenException e) {
            ErrorDialog.getInstance().handleException(e);
        }

        //private void

    }
}
