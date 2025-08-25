package com.example.barber.controller.appcontroller;


import com.example.barber.utils.exception.myexception.SystemException;
import com.example.barber.utils.graphicnavbar.GraphicNavBar;
import com.example.barber.utils.Session;
import com.example.barber.utils.switchpage.SwitchPage;
import io.github.palexdev.materialfx.controls.MFXButton;
import javafx.scene.layout.*;

import java.io.IOException;


public class NavBarAppController {

    SwitchPage switchPage = new SwitchPage();

    public void initNavBar(AnchorPane pane) {

       VBox vBox = new VBox();
       GraphicNavBar graphicNavBar = new GraphicNavBar();
       graphicNavBar.setGraphicNAvbar(vBox, Session.getInstance().getCredentials().getUsername());
       switch(Session.getInstance().getCredentials().getType().getId()){
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
    }

    private void setupBarbiere(VBox vBox) {
        vBox.getChildren().add(createButton("HomePage Barbiere","/HomePageClientAppointments.fxml"));
        vBox.getChildren().add(createButton("Gestione Appuntamenti","/HomePageClientAppointments.fxml"));
        vBox.getChildren().add(createButton("Recensioni Ricevute","/HomePageClientAppointments.fxml"));
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

    private void SetActionButton(String fxml){


    }

}
