package com.example.barber.controller.appcontroller;


import com.example.barber.utils.db.MySqlConnection;
import com.example.barber.utils.exception.ErrorDialog;
import com.example.barber.utils.exception.myexception.SystemException;
import com.example.barber.utils.graphicnavbar.GraphicNavBar;
import com.example.barber.utils.Session;
import com.example.barber.utils.switchpage.SwitchPage;
import io.github.palexdev.materialfx.controls.MFXButton;
import javafx.geometry.Pos;
import javafx.scene.layout.*;

import java.sql.SQLException;


public class NavBarAppController {

    SwitchPage switchPage = new SwitchPage();

    public void initNavBar(AnchorPane pane) {

       VBox vBox = new VBox();
       GraphicNavBar graphicNavBar = new GraphicNavBar();
       graphicNavBar.setGraphicNAvbar(vBox, Session.getInstance().getCredentials().getUsername());
       switch(Session.getInstance().getCredentials().getType().getRoleId()){
            case "CLIENTE" -> setupCliente(vBox);
            case "BARBIERE" -> setupBarbiere(vBox);
            default -> vBox.getChildren().clear();
        }
        pane.getChildren().add(vBox);
    }


    private void setupCliente(VBox vBox) {
        vBox.getChildren().add(createButton("HomePage Cliente","/HomePageClient.fxml"));
        vBox.getChildren().add(createButton("Appuntamenti", "/HomePageClientAppointments.fxml"));
        vBox.getChildren().add(createButton("Recensioni Effettuate","/HomePageClientAppointments.fxml"));
        vBox.getChildren().add(logOutButton("Logout"));
    }

    private void setupBarbiere(VBox vBox) {
        vBox.getChildren().add(createButton("HomePage Barbiere","/HomePageBarber.fxml"));
        vBox.getChildren().add(createButton("Gestione Appuntamenti","/HomePageBarberAppointments.fxml"));
        vBox.getChildren().add(createButton("Recensioni Ricevute","/HomePageClientAppointments.fxml"));
        vBox.getChildren().add(createButton("Modifica Negozio", "/ManageShop.fxml"));
        vBox.getChildren().add(logOutButton("Logout"));
    }

    private MFXButton createButton(String name, String fxml){
        MFXButton button = new MFXButton(name);
        button.setPrefWidth(207.0);
        button.setPrefHeight(74.0);
        button.setOnAction(e ->{
            try{
                switchPage.replaceScene(e,fxml);
            }catch (SystemException exception){
                exception.printStackTrace();
            }
        });


        return button;
    }

    private MFXButton logOutButton(String name){
        MFXButton button = new MFXButton(name);
        button.setPrefWidth(207.0);
        button.setPrefHeight(74.0);
        button.setAlignment(Pos.CENTER);

        button.setOnAction(e ->{
            try{
                Session.getInstance().deleteSession();
                MySqlConnection.getInstance().closeConnection();
                switchPage.replaceScene(e, "/welcomePage.fxml");
            }catch (SystemException | SQLException ex) {
            ErrorDialog.getInstance().handleException(ex);
        }
        });
        return button;
    }


}
