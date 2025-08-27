package com.example.barber.controller.guicontroller.interface2;


import com.example.barber.controller.appcontroller.SignInAppController;
import com.example.barber.utils.bean.CredentialsBean;
import com.example.barber.utils.bean.UserBean;
import com.example.barber.utils.exception.ErrorDialog;
import com.example.barber.utils.exception.myexception.*;
import com.example.barber.utils.ruoli.Role;
import com.example.barber.utils.switchpage.SwitchPage;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;


public class SignInUserGuiController2 {

    //Dichiaro uno UserBean che prende tutti i details di clienti(Name, surname, e-mail, telephone, gender)
    UserBean userBean = new UserBean();




    private SwitchPage sp = new SwitchPage();

    @FXML
    private TextField usernameField;
    @FXML
    private TextField emailField;
    @FXML
    private PasswordField passwordField;
    @FXML
    private TextField phoneField;
    @FXML
    private TextField firstNameField;
    @FXML
    private TextField lastNameField;
    @FXML
    private ComboBox<String> genderCombo;

    @FXML
    public void initialize() {
        genderCombo.getItems().addAll("Male", "Female");
    }

    @FXML
    private void backToWelcomePage(ActionEvent event){
        try{
            sp.replaceScene(event, "/welcomePage1.fxml");
        }catch(SystemException e){
            ErrorDialog.getInstance().handleException(e);
        }
    }

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

            //Carichiamo lo UserBean con le informazioni del cliente
            userBean.setName(firstNameField.getText());
            userBean.setSurname(lastNameField.getText());
            userBean.setGender(genderCombo.getValue());
            userBean.setEmail(emailField.getText());
            userBean.setUsername(usernameField.getText());
            userBean.setPhone(phoneField.getText());


            appController = new SignInAppController();

            //Spediamo tutto al controller dello user che poi si interfaccia con il livello sottostante ancora
            appController.registerUser(userBean, credentialsBean);
            sp.replaceScene(event, "/welcomePage1.fxml");

        }catch( EmptyInputException | SystemException | UsernameAlreadyTakenException | EmailNotValidException  | PasswordNotCompliantException e) {
            ErrorDialog.getInstance().handleException(e);
        }
    }
}
