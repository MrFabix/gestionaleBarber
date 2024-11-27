package com.example.barber.controller.guicontroller.interface1;

import com.example.barber.controller.appcontroller.BarberAppController;
import com.example.barber.utils.bean.BarberBean;
import com.example.barber.utils.bean.IdBean;
import com.example.barber.utils.exception.ErrorDialog;
import com.example.barber.utils.exception.myexception.SystemException;
import com.example.barber.utils.switchPage.SwitchPage;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;

public class BarberDetailController {

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
    @FXML
    private Button bookButton;


    SwitchPage switchPage = new SwitchPage();

    public void setBarberDetails(IdBean id) {
        System.out.println("ID selezionato Detail: " + id.getId());
        // Chiamare l'AppController per ottenere i dettagli
        BarberAppController barberAppController = new BarberAppController();

        // Ottieni i dettagli del barbiere
        BarberBean barberBean = barberAppController.getBarberDetails(id);
        if (barberBean != null) {
            System.out.println("BarberBean: " + barberBean);
            barberName.setText(barberBean.getName());
            barberAddress.setText(barberBean.getAddress());
            barberPhone.setText(barberBean.getPhone());
            barberHours.setText(barberBean.getHours());
            description.setText(barberBean.getDescription());
            //aggiugni attirbuto idBarber al button per prenotare
            bookButton.setUserData(barberBean.getId());




            // Aggiungi i servizi al ListView
            if (barberBean.getServices() != null ) {
                servicesList.getItems().addAll(barberBean.getServices());
            } else {
                servicesList.getItems().add("Nessun servizio disponibile.");
            }

        } else {
            System.out.println("Dettagli del barbiere non trovati");
            // Gestisci il caso in cui i dettagli non sono disponibili
            barberName.setText("N/A");
            barberAddress.setText("N/A");
            barberPhone.setText("N/A");
            barberHours.setText("N/A");
            description.setText("Nessuna descrizione disponibile");
            servicesList.getItems().add("Dettagli non disponibili.");
        }
    }

    // Metodo per tornare alla lista dei barbieri
    public void backToBarberList(ActionEvent event) {
        try {
            switchPage.replaceScene(event, "/homepageUser.fxml");
        } catch (SystemException e) {
            ErrorDialog.getInstance().handleException(e);
        }
    }

    // Metodo per prenotare un appuntamento
    public void bookAppointment(ActionEvent event) {

        System.out.println("BOOK APPOINTEMENT");
        // prendo Id dal button
        int id = (int) bookButton.getUserData();
        IdBean idBean = new IdBean(id);

        try {
            switchPage.switchPageId("/BookingForm.fxml", event, idBean);
        } catch (SystemException e) {
            ErrorDialog.getInstance().handleException(e);
        }
    }
}






