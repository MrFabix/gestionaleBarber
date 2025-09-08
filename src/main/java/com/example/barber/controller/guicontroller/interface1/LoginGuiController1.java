package com.example.barber.controller.guicontroller.interface1;

import com.example.barber.controller.appcontroller.LoginAppController;
import com.example.barber.utils.bean.CredentialsBean;
import com.example.barber.utils.exception.ErrorDialog;
import com.example.barber.utils.exception.myexception.*;
import com.example.barber.utils.switchPage.SwitchPage;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;


public class LoginGuiController1 {



    @FXML
    private TextField usernameField;
    @FXML
    private PasswordField passwordField;


    private SwitchPage sp = new SwitchPage();
    @FXML
    private void onloginButton(ActionEvent event) {
        LoginAppController controller;
        try {
                // Inizializza il controller e tenta il login
                controller = new LoginAppController();
                CredentialsBean credentialsBean = new CredentialsBean();
                credentialsBean.setUsername(usernameField.getText());
                credentialsBean.setPassword(passwordField.getText());
                //Ancora non so che ruolo avrò dipende come mi sono registrato
                //chiama qui il login controller che manda la query e cerca che ruolo ha quell'utente nel database
                controller.login(credentialsBean);
                if (credentialsBean.getType().getRoleId().equals("CLIENTE")) {
                    sp.replaceScene(event, "/view/interface1/homePageClient1.fxml");
                } else if (credentialsBean.getType().getRoleId().equals("BARBIERE")) {
                    sp.replaceScene(event, "/view/interface1/HomePageBarber1.fxml");
                } else if (credentialsBean.getType().getRoleId().equals("MODERATORE")) {
                    sp.replaceScene(event, "/view/interface1/homepageModerator.fxml");
                }
            }catch (WrongCredentialsException | PasswordNotCompliantException | SystemException | EmptyInputException | UsernameAlreadyTakenException | EmailNotValidException e ){
                ErrorDialog.getInstance().handleException(e);
            }
    }
    @FXML
    private void backToWelcomePage(ActionEvent event)  {
        try{
            sp.replaceScene(event, "/view/interface1/welcomePage1.fxml");
        }catch(SystemException e){
            ErrorDialog.getInstance().handleException(e);
        }
    }
}

