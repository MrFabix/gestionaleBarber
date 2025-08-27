package com.example.barber.controller.guicontroller.interface1;

import com.example.barber.controller.appcontroller.SignInAppController;
import com.example.barber.utils.bean.BarberBean;
import com.example.barber.utils.bean.CredentialsBean;
import com.example.barber.utils.exception.ErrorDialog;
import com.example.barber.utils.exception.myexception.*;
import com.example.barber.utils.ruoli.Role;
import com.example.barber.utils.switchpage.SwitchPage;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;


public class SignInBarberGuiController1 {
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



    private SwitchPage sp = new SwitchPage();

    @FXML
    private void backToWelcomePage(ActionEvent event){
        try {
            sp.replaceScene(event, "/view/interface1/welcomePage1.fxml");
        } catch (SystemException e) {
            ErrorDialog.getInstance().handleException(e);
        }
    }

    @FXML
    private void signInBarber(ActionEvent event) {
        SignInAppController appController;
        try {
            credentialsBean = new CredentialsBean();
            appController = new SignInAppController();

            //Credenziali
            credentialsBean.setUsername(usernameField.getText());
            credentialsBean.setPassword(passwordField.getText());
            credentialsBean.setType(Role.BARBER);


            //Carichiamo il barberBean
            barberBean.setName(barberShopField.getText());
            barberBean.setPhone(phoneField.getText());
            barberBean.setCity(cityField.getText());
            barberBean.setAddress(addressField.getText());
            barberBean.setEmail(emailField.getText());
            barberBean.setUsername(usernameField.getText());
            System.out.println("Mandiamo bean ");


            //Passiamo tutto al controller che si occupa di gestire l'inserimento dela barbiere e delle sue credenziali
            appController.registerBarber(barberBean, credentialsBean);
            sp.replaceScene(event, "/view/interface1/welcomePage1.fxml");


        } catch (EmptyInputException | EmailNotValidException | PasswordNotCompliantException | SystemException |
                 UsernameAlreadyTakenException e) {
            ErrorDialog.getInstance().handleException(e);
        }
    }
}
