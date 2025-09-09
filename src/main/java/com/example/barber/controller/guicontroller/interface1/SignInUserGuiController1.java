package com.example.barber.controller.guicontroller.interface1;


import com.example.barber.controller.appcontroller.SignInAppController;
import com.example.barber.utils.bean.CredentialsBean;
import com.example.barber.utils.bean.ClientBean;
import com.example.barber.utils.exception.ErrorDialog;
import com.example.barber.utils.exception.myexception.*;
import com.example.barber.utils.enumeration.ruoli.Role;
import com.example.barber.utils.scene.SwitchPage;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

import javafx.scene.control.ComboBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;


public class SignInUserGuiController1 {

    //Dichiaro uno ClientBean che prende tutti i details di clienti(Name, surname, e-mail, telephone, gender)
    ClientBean clientBean = new ClientBean();
    private SwitchPage sp = new SwitchPage();

    @FXML
    private TextField usernameField;
    @FXML
    private TextField emailField;
    @FXML
    private PasswordField passwordField;
    @FXML
    private TextField telephone;
    @FXML
    private TextField name;
    @FXML
    private TextField surname;
    @FXML
    private ComboBox<String> genderField;

    @FXML
    private void signInUser(ActionEvent event){
        CredentialsBean credentialsBean;
        SignInAppController appController;
        try{
            credentialsBean = new CredentialsBean();
            //Carichiamo il credentialsBean con i campi delle credenziali.
            credentialsBean.setUsername(usernameField.getText());
            credentialsBean.setPassword(passwordField.getText());
            credentialsBean.setType(Role.CLIENTE);

            //Carichiamo lo ClientBean con le informazioni del cliente
            clientBean.setName(name.getText());
            clientBean.setSurname(surname.getText());
            clientBean.setGender(genderField.getValue());
            clientBean.setEmail(emailField.getText());
            clientBean.setUsername(usernameField.getText());
            clientBean.setPhone(telephone.getText());

            appController = new SignInAppController();

            //Spediamo tutto al controller dello user che poi si interfaccia con il livello sottostante ancora
            appController.registerUser(clientBean, credentialsBean);
            sp.replaceScene(event, "/view/interface1/welcomePage1.fxml");

        }catch( EmptyInputException | SystemException | UsernameAlreadyTakenException | EmailNotValidException  e) {
            ErrorDialog.getInstance().handleException(e);
        }
    }

    @FXML
    public void initialize() {
        genderField.getItems().addAll("Male", "Female");
    }

    @FXML
    private void backToWelcomePage(ActionEvent event){
        try{
            sp.replaceScene(event, "/view/interface1/welcomePage1.fxml");
        }catch(SystemException e){
            ErrorDialog.getInstance().handleException(e);
        }
    }


}
