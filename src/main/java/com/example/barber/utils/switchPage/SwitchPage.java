package com.example.barber.utils.switchPage;

import com.example.barber.StartApplication;
import com.example.barber.controller.guicontroller.interface1.BarberDetailController;
import com.example.barber.utils.exception.myexception.SystemException;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.Parent;

import java.io.IOException;

public class SwitchPage {

    public void replaceScene(ActionEvent event, String fxml) throws SystemException {
        FXMLLoader fxmlLoader = new FXMLLoader(StartApplication.class.getResource(fxml));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = null;
        try {
            scene = new Scene(fxmlLoader.load());

        } catch (IOException e) {
            SystemException exception = new SystemException();
            exception.initCause(e);
            throw exception;

        }
        stage.setScene(scene);
        stage.show();
    }

    public static void showStage(ActionEvent event, Parent root){
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    //switchPage per passare l'id del barbiere
    public void switchPageId(String fxml, ActionEvent event, int id) throws SystemException {
        FXMLLoader fxmlLoader = new FXMLLoader(StartApplication.class.getResource(fxml));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = null;
        try {
            scene = new Scene(fxmlLoader.load());
            BarberDetailController controller = fxmlLoader.getController();
            controller.setBarberDetails(id);
        } catch (IOException e) {
            SystemException exception = new SystemException();
            exception.initCause(e);
            throw exception;
        }
        stage.setScene(scene);
        stage.show();
    }










}
