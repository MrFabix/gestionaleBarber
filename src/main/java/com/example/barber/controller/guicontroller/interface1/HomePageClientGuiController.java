package com.example.barber.controller.guicontroller.interface1;



import com.example.barber.controller.guicontroller.interface1.item.BarberItemController;
import com.example.barber.utils.bean.BarberBean;
import com.example.barber.utils.engineering.ListBarberEngineering;
import com.example.barber.utils.exception.ErrorDialog;
import com.example.barber.utils.observer.GenericBeanList;
import com.example.barber.utils.observer.Observer;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;

import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;

public class HomePageClientGuiController implements Observer, Initializable {




    @FXML
    private ListView<Pane> barberListView;  // La ListView che mostrerà i barbieri
    @FXML
    private TextField searchBarber; // Barra di ricerca







    @Override
    public void initialize(URL location, ResourceBundle resources) {
        ListBarberEngineering listBarber;
        try {
            listBarber = new ListBarberEngineering();
            GenericBeanList list = new GenericBeanList(this);
            list.addBarbersToList(listBarber.getAllBarber());
        } catch (Exception e) {
            ErrorDialog.getInstance().handleException(e);
        }
    }




    @Override
    public void update(Object ob) {
        FXMLLoader fxmlLoader = new FXMLLoader();
        Pane pane;
        if (ob instanceof BarberBean bBean) {
            try {
                // Carica il layout del barbiere dal file FXML
                pane = fxmlLoader.load(Objects.requireNonNull(getClass().getResource("/BarberItem.fxml")).openStream());
                // Ottieni il controller del layout caricato
                BarberItemController controller = fxmlLoader.getController();
                // Imposta i dettagli del barbiere
                controller.setBarberDetails(bBean.getName(), bBean.getCity(), bBean.getAddress(), bBean.getId());
                // Aggiungi il pane alla ListView
                this.barberListView.getItems().add(pane);
            } catch (Exception e) {
                ErrorDialog.getInstance().handleException(e);
            }
        }
    }

    //funzione per il filtraggio dei barbieri
    @FXML
    private void search() {
        String query = searchBarber.getText().trim();
        this.barberListView.getItems().clear(); // Pulisci la lista prima di riempirla di nuovo
        if (query.isEmpty()) {
            initialize(null, null);
            return;
        }
        try {
            ListBarberEngineering listBarber = new ListBarberEngineering();
            GenericBeanList list = new GenericBeanList(this);
            list.addBarbersToList(listBarber.getBarberByName(query));
        } catch (Exception e) {
            ErrorDialog.getInstance().handleException(e);
        }
    }
}
