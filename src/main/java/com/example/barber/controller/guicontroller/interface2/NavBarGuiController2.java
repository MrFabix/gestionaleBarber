package com.example.barber.controller.guicontroller.interface2;

import com.example.barber.utils.Session;
import com.example.barber.utils.db.MySqlConnection;
import com.example.barber.utils.exception.ErrorDialog;
import com.example.barber.utils.exception.myexception.SystemException;
import com.example.barber.utils.graphicnavbar.GraphicNavBar;
import io.github.palexdev.materialfx.controls.MFXButton;
import javafx.fxml.FXML;
import com.example.barber.utils.switchpage.SwitchPage;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class NavBarGuiController2 implements Initializable {


        @FXML
        private AnchorPane navAnchor;

        private final SwitchPage switchPage = new SwitchPage();

        @Override
        public void initialize(URL location, ResourceBundle resources) {
            try {
                initNavBar(navAnchor);
            } catch (Exception e) {
                ErrorDialog.getInstance().handleException(e);
            }
        }


        private MFXButton logOutButton(String name) {
            MFXButton button = new MFXButton(name);
            button.setPrefHeight(44.0);
            button.setMinWidth(120.0);
            button.setAlignment(Pos.CENTER);
            button.setOnAction(e -> {
                try {
                    Session.getInstance().deleteSession();
                    MySqlConnection.getInstance().closeConnection();
                    switchPage.replaceScene(e, "/view/interface2/welcomePage2.fxml");
                } catch (SystemException | SQLException ex) {
                    ErrorDialog.getInstance().handleException(ex);
                }
            });
            return button;
        }
        
        private void initNavBar(AnchorPane pane) {
            HBox hBox = new HBox();
            hBox.setAlignment(Pos.CENTER_LEFT);
            hBox.setSpacing(12);
            hBox.setPadding(new Insets(8, 12, 8, 12));

            GraphicNavBar graphicNavBar = new GraphicNavBar();
            graphicNavBar.setGraphicNAvbar(navAnchor, hBox, Session.getInstance().getCredentials().getUsername());

            switch (Session.getInstance().getCredentials().getType().getRoleId()) {
                case "CLIENTE" -> setupCliente(hBox);
                case "BARBIERE" -> setupBarbiere(hBox);
                default -> hBox.getChildren().clear();
            }

            pane.getChildren().clear();
            pane.getChildren().add(hBox);
            // Fai “stretch” orizzontale della navbar
            AnchorPane.setTopAnchor(hBox, 0.0);
            AnchorPane.setLeftAnchor(hBox, 0.0);
            AnchorPane.setRightAnchor(hBox, 0.0);
        }

        private void setupCliente(HBox hBox) {
            hBox.getChildren().add(createButton("HomePage Cliente", "/view/interface2/HomePageClient2.fxml"));
            hBox.getChildren().add(createButton("Appuntamenti", "/view/interface2/HomePageClientAppointments2.fxml"));
            hBox.getChildren().add(createButton("Recensioni Effettuate", "/view/interface2/HomePageClientAppointments2.fxml"));
            hBox.getChildren().add(logOutButton("Logout"));
        }

        private void setupBarbiere(HBox hBox) {
            hBox.getChildren().add(createButton("HomePage Barbiere", "/view/interface2/HomePageBarber2.fxml"));
            hBox.getChildren().add(createButton("Gestione Appuntamenti", "/view/interface2/HomePageBarberAppointments2.fxml"));
            hBox.getChildren().add(createButton("Recensioni Ricevute", "/view/interface2/HomePageClientAppointments2.fxml"));
            hBox.getChildren().add(createButton("Modifica Negozio", "/view/interface2/ManageShop2.fxml"));
            hBox.getChildren().add(logOutButton("Logout"));
        }

        private MFXButton createButton(String name, String fxml) {
            MFXButton button = new MFXButton(name);
            button.setPrefHeight(44.0);
            button.setMinWidth(120.0);
            button.setOnAction(e -> {
                try {
                    switchPage.replaceScene(e, fxml);
                } catch (SystemException exception) {
                    exception.printStackTrace();
                }
            });
            return button;
        }


}
