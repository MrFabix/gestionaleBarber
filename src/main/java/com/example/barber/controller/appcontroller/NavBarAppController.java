package com.example.barber.controller.appcontroller;


import com.example.barber.utils.graphicnavbar.GraphicNavBar;
import com.example.barber.utils.Session;
import io.github.palexdev.materialfx.controls.MFXButton;
import javafx.scene.layout.*;


public class NavBarAppController {


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



        vBox.getChildren().add(createButton("HomePage Cliente"));
        vBox.getChildren().add(createButton("Appuntamenti"));
        vBox.getChildren().add(createButton("Recensioni Effettuate"));
    }

    private void setupBarbiere(VBox vBox) {
        vBox.getChildren().add(createButton("HomePage Barbiere"));
        vBox.getChildren().add(createButton("Gestione Appuntamenti"));
        vBox.getChildren().add(createButton("Recensioni Ricevute"));
    }

    private MFXButton createButton(String name) {
        MFXButton button = new MFXButton(name);
        button.setPrefWidth(207.0);
        button.setPrefHeight(74.0);
        return button;
    }

    private void SetActionButton(String fxml){


    }

}
