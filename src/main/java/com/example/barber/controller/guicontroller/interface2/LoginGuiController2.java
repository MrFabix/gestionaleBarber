package com.example.barber.controller.guicontroller.interface2;

import com.example.barber.controller.appcontroller.LoginAppController;
import com.example.barber.utils.bean.CredentialsBean;
import com.example.barber.utils.exception.ErrorDialog;
import com.example.barber.utils.exception.myexception.*;
import com.example.barber.utils.scene.SwitchPage;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;


public class LoginGuiController2 {



    @FXML
    private TextField username;
    @FXML
    private PasswordField pass;


    private SwitchPage sp = new SwitchPage();

    @FXML
    private void goBack(ActionEvent event)   {
        try{
            sp.replaceScene(event, "/view/interface2/welcomePage2.fxml");
        }catch(SystemException e){
            ErrorDialog.getInstance().handleException(e);
        }
    }



    @FXML
    private void onloginButton(ActionEvent event) {
        LoginAppController controller;
        try {
            // Inizializza il controller e tenta il login
            controller = new LoginAppController();
            CredentialsBean credentialsBean = new CredentialsBean();
            credentialsBean.setUsername(username.getText());
            credentialsBean.setPassword(pass.getText());
            //Ancora non so che ruolo avrò, dipende come mi sono registrato
            //chiama qui il login controller che manda la query e cerca che ruolo ha quell'utente nel database
            controller.login(credentialsBean);
            if (credentialsBean.getType().getRoleId().equals("CLIENTE")) {
                sp.replaceScene(event, "/view/interface2/homePageClient2.fxml");
            } else if (credentialsBean.getType().getRoleId().equals("BARBIERE")) {
                sp.replaceScene(event, "/view/interface2/homePageBarber2.fxml");
            } else if(credentialsBean.getType().getRoleId().equals("MODERATORE")){
                sp.replaceScene(event, "/homepageModerator.fxml");
            }
        } catch (SystemException | WrongCredentialsException | EmptyInputException  | EmailNotValidException e) {
            // Gestisce altri tipi di eccezioni
            ErrorDialog.getInstance().handleException(e);
        }
    }

}

