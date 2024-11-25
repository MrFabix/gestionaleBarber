package com.example.barber.controller.guicontroller.interface1;

import com.example.barber.controller.appcontroller.BarberAppController;
import com.example.barber.utils.bean.BarberBean;
import com.example.barber.utils.exception.ErrorDialog;
import com.example.barber.utils.exception.myexception.SystemException;
import com.example.barber.utils.switchPage.SwitchPage;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;

public class BarberDetailController  {

    @FXML
    private Label barberName;
    @FXML
    private Label barberAddress;
    @FXML
    private Label barberPhone;
    @FXML
    private Label barberHours;
    @FXML
    private TextArea description;
    @FXML
    private ListView<String> servicesList;
    @FXML
    private ListView<String> reviewsList;

    SwitchPage switchPage = new SwitchPage();

    public void setBarberDetails(int id) {
        System.out.println("ID selezionato barber details: " + id);

        // Chiamare l'AppController per ottenere i dettagli
        BarberAppController barberAppController = new BarberAppController();

        // Ottieni i dettagli del barbiere
        BarberBean barberBean = barberAppController.getBarberDetails(id);
        if (barberBean != null) {
            System.out.println("BarberBean: " + barberBean);

            // Impostare i dettagli sui componenti grafici
            barberName.setText(barberBean.getName());
            barberAddress.setText(barberBean.getAddress());
            barberPhone.setText(barberBean.getPhone());
            barberHours.setText(barberBean.getHours());
            description.setText(barberBean.getDescription());

            // Impostare le liste di servizi e recensioni


        } else {
            System.out.println("Dettagli del barbiere non trovati");
        }
    }

    // Metodo per tornare alla lista dei barbieri
    public void backToBarberList(ActionEvent event) {
        try {
            switchPage.replaceScene(event, "/welcomePage.fxml");
        } catch(SystemException e) {
            ErrorDialog.getInstance().handleException(e);
        }
    }
}
