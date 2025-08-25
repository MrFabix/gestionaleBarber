package com.example.barber.controller.guicontroller.interface1.item;

import com.example.barber.controller.appcontroller.BookingAppController;
import com.example.barber.utils.bean.RequestAppointmentsBean;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class ManageRequestItemGuiController {
    private RequestAppointmentsBean requestAppointmentsBean;
    private BookingAppController bookingAppController;

    @FXML
    private Label nomeBarbiereDaInserire;
    @FXML
    private Label ServizioDaInserire;
    @FXML
    private Label dataDaInserire;
    @FXML
    private Label orarioDaInserire;
    @FXML
    private Button statoRichiesta;

    public void setAll(RequestAppointmentsBean requestAppointmentsBean, BookingAppController bookingAppController) {
        this.requestAppointmentsBean = requestAppointmentsBean;
        this.bookingAppController = bookingAppController;
        this.nomeBarbiereDaInserire.setText(requestAppointmentsBean.getNameBarber());
        this.dataDaInserire.setText(requestAppointmentsBean.getDate().toString());
        this.orarioDaInserire.setText(requestAppointmentsBean.getOrario());
        this.statoRichiesta.setText(requestAppointmentsBean.getState().getId());
    }

}
