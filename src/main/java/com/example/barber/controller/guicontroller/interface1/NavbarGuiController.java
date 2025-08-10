package com.example.barber.controller.guicontroller.interface1;
import com.example.barber.controller.appcontroller.NavBarAppController;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;

import java.net.URL;
import java.util.ResourceBundle;


public class NavbarGuiController implements Initializable {

    @FXML
    private AnchorPane navAnchor;


    public void initialize(URL location, ResourceBundle resources) {
       try {
           NavBarAppController controller = new NavBarAppController();
           controller.initNavBar(navAnchor);
       }catch (Exception e){
           e.printStackTrace();
       }
    }


}


