package com.example.barber.controller.guicontroller.interface1;

import com.example.barber.utils.Session;
import com.example.barber.utils.bean.ServiceBean;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;


public class ManageShopGuiController {

    private ServiceBean serviceBean;



    @FXML
    private TextField nomeServizio;
    @FXML
    private VBox listService;
    @FXML
    private Spinner<Double> prezzo;

    @FXML
    private void addServiceInVbox() {

        serviceBean.setId_barber(Session.getInstance().getBarber().getId());
        serviceBean.setNome_servizio(nomeServizio.getText());
        serviceBean.setPrezzo(prezzo.getValue());
        String name = nomeServizio.getText() == null ? "" : nomeServizio.getText().trim();
        double price = prezzo.getValue();

        if (name.isEmpty()) {
            new Alert(Alert.AlertType.WARNING, "Inserisci il nome del servizio.").showAndWait();
            return;
        }
        if (price == 0.0) {
            new Alert(Alert.AlertType.WARNING, "Inserisci il prezzo del servizio.").showAndWait();
            return;
        }

        try {
            if (price < 0) throw new NumberFormatException();
        } catch (NumberFormatException ex) {
            new Alert(Alert.AlertType.WARNING, "Prezzo non valido.").showAndWait();
            return;
        }

        HBox row = new HBox(8);
        Label bullet = new Label("•");
        Label lblName = new Label(name);
        Label lblPrice = new Label(String.format(java.util.Locale.ITALY, "€ %.2f", price));
        Button remove = new Button("X");
        remove.setOnAction(e -> listService.getChildren().remove(row));

        row.getChildren().addAll(bullet, lblName, lblPrice, remove);
        listService.getChildren().add(row);

        // pulizia campi
        nomeServizio.clear();
        prezzo.getValueFactory().setValue(0.0);
        nomeServizio.requestFocus();
    }




}


