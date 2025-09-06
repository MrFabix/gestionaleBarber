package com.example.barber.utils.switchpage;

import com.example.barber.Main;
import com.example.barber.controller.guicontroller.interface1.BarberDetailGuiController;
import com.example.barber.controller.guicontroller.interface2.BarberDetailGuiController2;
import com.example.barber.utils.bean.IdBean;
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
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource(fxml));
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
    public void switchPageId(String fxml, ActionEvent event, IdBean id) throws SystemException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource(fxml));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = null;

        try {
            scene = new Scene(fxmlLoader.load());
            // Gestisci BarberDetailGuiController
            if (fxml.equals("/view/interface1/BarberDetail.fxml")) {
                BarberDetailGuiController controller = fxmlLoader.getController();
                if (controller != null) {
                    controller.setBarberDetails(id);
                }
            }else if(fxml.equals("/view/interface2/BarberDetail2.fxml")) {
                BarberDetailGuiController2 controller = fxmlLoader.getController();
                if (controller != null) {
                    controller.setBarberDetails(id);
                }
            }
        } catch (IOException e) {
            // Cattura le eccezioni di I/O
            SystemException exception = new SystemException();
            exception.initCause(e);
            throw exception;
        }

        // Imposta la scena e mostra la finestra
        stage.setScene(scene);
        stage.show();
    }
}
