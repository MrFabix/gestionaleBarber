package com.example.barber.controller.guicontroller.interface2;

import com.example.barber.controller.appcontroller.SignInAppController;
import com.example.barber.utils.bean.CredentialsBean;
import com.example.barber.utils.bean.interfaccia2.BarberBean2;
import com.example.barber.utils.exception.ErrorDialog;
import com.example.barber.utils.exception.myexception.*;
import com.example.barber.utils.ruoli.Role;
import com.example.barber.utils.switchpage.SwitchPage;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;


public class SignInBarberGuiController2 {
    BarberBean2 barberBean2 = new BarberBean2();
    CredentialsBean credentialsBean = new CredentialsBean();

    @FXML
    private TextField barberShopField;
    @FXML
    private TextField streetField;
    @FXML
    private TextField civicoField;
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
            sp.replaceScene(event, "/view/interface2/registrationChoice2.fxml");
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
            barberBean2.setName(barberShopField.getText());
            barberBean2.setPhone(phoneField.getText());
            barberBean2.setCity(cityField.getText());
            barberBean2.setAddress(streetField.getText(), civicoField.getText());
            barberBean2.setEmail(emailField.getText());
            barberBean2.setUsername(usernameField.getText());
            System.out.println("Mandiamo bean ");


            //Passiamo tutto al controller che si occupa di gestire l'inserimento dela barbiere e delle sue credenziali
            appController.registerBarber(barberBean2, credentialsBean);
            sp.replaceScene(event, "/view/interface2/welcomePage2.fxml");


        } catch (EmptyInputException | EmailNotValidException | PasswordNotCompliantException | SystemException |
                 UsernameAlreadyTakenException e) {
            ErrorDialog.getInstance().handleException(e);
        }
    }
}
