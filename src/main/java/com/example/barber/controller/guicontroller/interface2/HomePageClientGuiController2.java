package com.example.barber.controller.guicontroller.interface2;



import com.example.barber.controller.appcontroller.BarberAppController;
import com.example.barber.controller.guicontroller.interface2.item2.BarberItemGuiController2;
import com.example.barber.utils.bean.BarberBean;
import com.example.barber.utils.bean.interfaccia2.BarberBean2;
import com.example.barber.utils.exception.ErrorDialog;
import com.example.barber.utils.observer.Observer;
import com.example.barber.utils.setterandgetter.SetterClass;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;

import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;

public class HomePageClientGuiController2 implements Observer, Initializable {


    private BarberBean2 barberBean2 = new BarberBean2();

    @FXML
    private ListView<Pane> listBarber;  // La ListView che mostrerà i barbieri
    @FXML
    private TextField searchBarber; // Barra di ricerca


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        BarberAppController barberAppController = new BarberAppController();
        try {
            barberAppController.addToList(this);
        } catch (Exception e) {
            ErrorDialog.getInstance().handleException(e);
        }
    }

    //funzione per il filtraggio dei barbieri
    @FXML
    private void search2() {
        String query = searchBarber.getText().trim();
        this.listBarber.getItems().clear(); // Pulisci la lista prima di riempirla di nuovo
        BarberAppController barberAppController = new BarberAppController();
        try {
            barberAppController.search(this, query);
        } catch (Exception e) {
            ErrorDialog.getInstance().handleException(e);
        }
    }

    @Override
    public void update(Object ob) {
        SetterClass setterClass = new SetterClass();
        FXMLLoader fxmlLoader = new FXMLLoader();
        Pane pane;
        if (ob instanceof BarberBean bBean) {
            try {
                setterClass.setBarber((BarberBean)ob,barberBean2);
                pane = fxmlLoader.load(Objects.requireNonNull(getClass().getResource("/view/interface2/BarberItem2.fxml")).openStream());
                BarberItemGuiController2 controller = fxmlLoader.getController();
                controller.setBarberDetails(barberBean2);
                this.listBarber.getItems().add(pane);
            } catch (Exception e) {
                ErrorDialog.getInstance().handleException(e);
            }
        }
    }


}
