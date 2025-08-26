package com.example.barber.controller.guicontroller.interface1;

import com.example.barber.controller.appcontroller.ServiceAppController;
import com.example.barber.utils.Session;
import com.example.barber.utils.bean.ServiceBean;
import com.example.barber.utils.exception.myexception.SystemException;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;


public class ManageShopGuiController {

    private ServiceBean serviceBean = new ServiceBean();



    @FXML
    private TextField nomeServizio;
    @FXML
    private VBox listService;
    @FXML
    private TextField costo;

    @FXML
    private void addServiceInVbox() {
        ServiceAppController controller = new ServiceAppController();
        serviceBean.setId_barber(Session.getInstance().getBarber().getId());
        serviceBean.setNome_servizio(nomeServizio.getText());
        String price = costo.getText();

        double d = Double.parseDouble(price.trim().replace(',', '.'));
        serviceBean.setPrezzo(d);
        String name = nomeServizio.getText() == null ? "" : nomeServizio.getText().trim();


        if (name.isEmpty()) {
            new Alert(Alert.AlertType.WARNING, "Inserisci il nome del servizio.").showAndWait();
            return;
        }
        if (d == 0.0) {
            new Alert(Alert.AlertType.WARNING, "Inserisci il prezzo del servizio.").showAndWait();
            return;
        }

        try {
            if (d < 0) throw new NumberFormatException();
        } catch (NumberFormatException ex) {
            new Alert(Alert.AlertType.WARNING, "Prezzo non valido.").showAndWait();
            return;
        }

        HBox row = new HBox(8);
        Label bullet = new Label("•");
        Label lblName = new Label(name);
        Label prezzo = new Label(price);
        Button remove = new Button("X");
        remove.setOnAction(e -> deleteService(row, controller, serviceBean));
        new Alert(Alert.AlertType.WARNING, "Aggiunto un serivzio").showAndWait();
        row.getChildren().addAll(bullet, lblName, prezzo, remove);
        listService.getChildren().add(row);

        try{
            controller.insertService(serviceBean);
        } catch (SystemException e) {
            e.printStackTrace();
        }



        // pulizia campi
        nomeServizio.clear();
        costo.clear();
        nomeServizio.requestFocus();
    }


    private void deleteService(HBox row, ServiceAppController controller, ServiceBean serviceBean){
        listService.getChildren().remove(row);
        try{
            controller.deleteService(serviceBean);
        } catch (SystemException e) {
            e.printStackTrace();
        }
    }
}


