package com.example.barber.controller.guicontroller.interface1;

import com.example.barber.controller.appcontroller.RecensioneAppController;
import com.example.barber.controller.guicontroller.interface1.item.RecensioneItemGuiController;
import com.example.barber.utils.Session;
import com.example.barber.utils.bean.RecensioneBean;
import com.example.barber.utils.exception.ErrorDialog;
import com.example.barber.utils.observer.Observer;
import com.example.barber.utils.setterandgetter.SetterClass;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;

import java.io.IOException;
import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;

public class BarberRecensioniGuiController1 implements Initializable, Observer {
    @FXML
    public TextField searchRecensioni;
    @FXML
    public ListView<Pane> recensioniList;
    @FXML
    public AnchorPane navigationBar;

    private RecensioneBean recensioneBean1 = new RecensioneBean();

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        RecensioneAppController recensioneAppController = new RecensioneAppController();
        try {
            recensioneAppController.addToListbarber(this, Session.getInstance().getBarber().getId());
        } catch (Exception e) {
            ErrorDialog.getInstance().handleException(e);
        }

    }

    @Override
    public void update(Object ob) {
        FXMLLoader fxmlLoader = new FXMLLoader();
        Pane pane;
        SetterClass setterClass = new SetterClass();
        if (ob instanceof RecensioneBean bean) {
            try {
                setterClass.setRecensione(recensioneBean1,bean);

                pane = fxmlLoader.load(Objects.requireNonNull(getClass().getResource("/view/interface1/RecensioneItem.fxml")).openStream());
                RecensioneItemGuiController controller = fxmlLoader.getController();
                controller.setRecensioneDetailsBarber(recensioneBean1);
                this.recensioniList.getItems().add(pane);
            } catch (IOException e) {
                ErrorDialog.getInstance().handleException(e);
            }
        }
    }
}
