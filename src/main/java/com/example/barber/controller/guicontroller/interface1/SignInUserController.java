package com.example.barber.controller.guicontroller.interface1;


import com.example.barber.controller.appcontroller.SignInAppController;
import com.example.barber.utils.bean.CredentialsBean;
import com.example.barber.utils.bean.SignInBean;
import com.example.barber.utils.bean.UserBean;
import com.example.barber.utils.exception.ErrorDialog;
import com.example.barber.utils.exception.myexception.*;
import com.example.barber.utils.switchPage.SwitchPage;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import java.io.IOException;

public class SignInUserController {

    //Dichiaro uno UserBean che prende tutti i details di clienti(Name, surname, e-mail, telephone, gender)
    UserBean userBean = new UserBean();

    //Dichiaro un credentialBean per il fatto che è lui che si occupa di prendere le credenziali(Username, Pswd, Type)
    CredentialsBean credentialsBean = new CredentialsBean();




    @FXML
    private TextField usernameField;
    @FXML
    private TextField emailField;
    @FXML
    private Button registrationButton;
    @FXML
    private PasswordField passwordField;
    @FXML
    private PasswordField confirmPasswordField;
    @FXML
    private TextField telephone;
    @FXML
    private TextField name;
    @FXML
    private TextField surname;
    @FXML
    private ComboBox<String> genderField;
    @FXML
    private ComboBox<String> roleField;

    @FXML
    public void initialize() {

        genderField.getItems().addAll("Male", "Female");
        roleField.getItems().addAll("user", "barber");
    }

    private SwitchPage sp = new SwitchPage();




    @FXML
    private void backToWelcomePage(ActionEvent event) throws IOException {
        try{
            sp.replaceScene(event, "/welcomePage.fxml");
        }catch(SystemException e){
            ErrorDialog.getInstance().handleException(e);
        }
    }

    @FXML
    private void signIn(ActionEvent event){

        CredentialsBean credentialBean;
        SignInAppController appController;

        try{
            System.out.println("Sei qui");
            credentialBean = new CredentialsBean();
            //System.out.println("password is too short" + credentialBean.getPassword());
            //Carichiamo il credentialBean con i campi delle credenziali.
            credentialBean.setUsername(usernameField.getText());
            //TODO inserire entrambi all'interno del setPassword del credential bean cambiare
            credentialBean.setConfirmPassword(confirmPasswordField.getText());
            credentialBean.setPassword(passwordField.getText());


            System.out.println("La password che sta dentro credentialBean    "+credentialBean.getPassword());
            credentialBean.setType(roleField.getValue());


            //Carichiamo lo UserBean con le informazioni del cliente
            userBean.setName(name.getText());
            userBean.setSurname(surname.getText());
            userBean.setGender(genderField.getValue());
            userBean.setEmail(emailField.getText());
            userBean.setUsername(usernameField.getText());
            userBean.setPhone(telephone.getText());

            appController = new SignInAppController();


            //Spediamo tutto al controller dello user che poi si interfaccia con il livello sottostante ancora
            appController.registerUser(userBean, credentialBean);
            sp.replaceScene(event, "/welcomePage.fxml");

        }catch( EmptyInputException e) {
            ErrorDialog.getInstance().handleException(e);
        } catch (SystemException e) {
            ErrorDialog.getInstance().handleException(e);
        } catch (UsernameAlreadyTakenException e) {
            ErrorDialog.getInstance().handleException(e);
        } catch (EmailNotValidException e) {
            ErrorDialog.getInstance().handleException(e);
        } catch (PasswordNotCompliantException e) {
            ErrorDialog.getInstance().handleException(e);
        } catch (PasswordNotEquals e) {
            ErrorDialog.getInstance().handleException(e);
        }
    }
}
