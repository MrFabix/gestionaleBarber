package com.example.barber.controller.guicontroller.interface2;


import com.example.barber.controller.appcontroller.SignInAppController;
import com.example.barber.utils.bean.CredentialsBean;
import com.example.barber.utils.bean.interfaccia1.ClientBean1;
import com.example.barber.utils.exception.ErrorDialog;
import com.example.barber.utils.exception.myexception.*;
import com.example.barber.utils.enumeration.ruoli.Role;
import com.example.barber.utils.scene.SwitchPage;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;


public class SignInUserGuiController2 {

    ClientBean1 clientBean1 = new ClientBean1();

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
    RadioButton maleRadio;

    @FXML
    private void signInUser(ActionEvent event){
        CredentialsBean credentialsBean;
        SignInAppController appController;
        String gender = null;
        try{
            credentialsBean = new CredentialsBean();
            credentialsBean.setUsername(usernameField.getText());
            credentialsBean.setPassword(passwordField.getText());
            credentialsBean.setType(Role.CLIENTE);

            clientBean1.setName(firstNameField.getText());
            clientBean1.setSurname(lastNameField.getText());
            if(maleRadio.isSelected()){
                gender = "male";
            }else{
                gender = "female";
            }
            clientBean1.setGender(gender);
            clientBean1.setEmail(emailField.getText());
            clientBean1.setUsername(usernameField.getText());
            clientBean1.setPhone(phoneField.getText());
            appController = new SignInAppController();
            appController.registerUser(clientBean1, credentialsBean);
            sp.replaceScene(event, "/view/interface2/welcomePage2.fxml");

        }catch( EmptyInputException | SystemException | UsernameAlreadyTakenException | EmailNotValidException  e) {
            ErrorDialog.getInstance().handleException(e);
        }
    }


    @FXML
    private void backToWelcomePage(ActionEvent event){
        try{
            sp.replaceScene(event, "/view/interface2/registrationChoice2.fxml");
        }catch(SystemException e){
            ErrorDialog.getInstance().handleException(e);
        }
    }
}
