package com.example.barber.controller.guicontroller.interface1;



import com.example.barber.controller.appcontroller.BarberAppController;
import com.example.barber.controller.guicontroller.interface1.item.BarberItemGuiController;
import com.example.barber.utils.bean.BarberBean;
import com.example.barber.utils.bean.interfaccia1.BarberBean1;
import com.example.barber.utils.exception.ErrorDialog;
import com.example.barber.utils.exception.myexception.EmailNotValidException;
import com.example.barber.utils.exception.myexception.EmptyInputException;
import com.example.barber.utils.observer.Observer;
import com.example.barber.utils.setterandgetter.SetterClass;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;

import java.io.IOException;
import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;

public class HomePageClientGuiController1 implements Observer, Initializable {

    @FXML
    private ListView<Pane> barberListView;
    @FXML
    private TextField searchBarber;

    private BarberBean1 barberBean1 = new BarberBean1();


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        BarberAppController barberAppController = new BarberAppController();
        try {
            barberAppController.addToList(this);
        } catch (Exception e) {
            ErrorDialog.getInstance().handleException(e);
        }
    }




    @Override
    public void update(Object ob) {
        FXMLLoader fxmlLoader = new FXMLLoader();
        Pane pane;
        SetterClass setterClass = new SetterClass();

        if (ob instanceof BarberBean bean) {
            try {
                setterClass.setBarber(bean,barberBean1);
                pane = fxmlLoader.load(Objects.requireNonNull(getClass().getResource("/view/interface1/BarberItem.fxml")).openStream());
                BarberItemGuiController controller = fxmlLoader.getController();
                controller.setBarberDetails(barberBean1);
                this.barberListView.getItems().add(pane);
            } catch ( EmptyInputException | EmailNotValidException | IOException e) {
                ErrorDialog.getInstance().handleException(e);
            }
        }
    }

    //funzione per il filtraggio dei barbieri
    @FXML
    private void search() {
        String query = searchBarber.getText().trim();
        this.barberListView.getItems().clear(); // Pulisci la lista prima di riempirla di nuovo
        BarberAppController barberAppController = new BarberAppController();
        try {
            barberAppController.search(this, query);
        } catch (Exception e) {
            ErrorDialog.getInstance().handleException(e);
        }
    }
}
