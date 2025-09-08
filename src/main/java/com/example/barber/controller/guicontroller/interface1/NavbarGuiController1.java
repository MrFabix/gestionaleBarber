package com.example.barber.controller.guicontroller.interface1;
import com.example.barber.utils.Session;
import com.example.barber.utils.db.MySqlConnection;
import com.example.barber.utils.exception.ErrorDialog;
import com.example.barber.utils.exception.myexception.SystemException;
import com.example.barber.utils.graphicnavbar.GraphicNavBar;
import com.example.barber.utils.switchpage.SwitchPage;
import io.github.palexdev.materialfx.controls.MFXButton;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;


public class NavbarGuiController1 implements Initializable {

    @FXML
    private AnchorPane navAnchor;
    SwitchPage switchPage = new SwitchPage();

    public void initialize(URL location, ResourceBundle resources) {
       try {
           initNavBar(navAnchor);
       }catch (Exception e){
           ErrorDialog.getInstance().handleException(e);
       }
    }

    private void initNavBar(AnchorPane pane) {
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
        vBox.getChildren().add(createButton("HomePage Cliente","/view/interface1/HomePageClient.fxml"));
        vBox.getChildren().add(createButton("Appuntamenti", "/view/interface1/HomePageClientAppointments1.fxml"));
        vBox.getChildren().add(createButton("Recensioni Effettuate", "not location set"));
        vBox.getChildren().add(logOutButton("Logout"));
    }

    private void setupBarbiere(VBox vBox) {
        vBox.getChildren().add(createButton("HomePage Barbiere","/view/interface1/HomePageBarber1.fxml"));
        vBox.getChildren().add(createButton("Gestione Appuntamenti", "/view/interface1/HomePageBarberAppointments1.fxml"));
        vBox.getChildren().add(createButton("Recensioni Ricevute", "not location set"));
        vBox.getChildren().add(createButton("Modifica Negozio", "/view/interface1/ManageShop1.fxml"));
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
                switchPage.replaceScene(e, "/view/interface1/welcomePage1.fxml");
            }catch (SystemException | SQLException ex) {
                ErrorDialog.getInstance().handleException(ex);
            }
        });
        return button;
    }

}


