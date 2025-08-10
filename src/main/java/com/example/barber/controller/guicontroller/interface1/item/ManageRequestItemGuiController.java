package com.example.barber.controller.guicontroller.interface1.item;

import com.example.barber.controller.appcontroller.BookingFormAppController;
import com.example.barber.utils.bean.RequestAppointmentsBean;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class ManageRequestItemGuiController {
    private RequestAppointmentsBean requestAppointmentsBean;
    private BookingFormAppController bookingFormAppController;

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

    public void setAll(RequestAppointmentsBean requestAppointmentsBean, BookingFormAppController bookingFormAppController) {
        this.requestAppointmentsBean = requestAppointmentsBean;
        this.bookingFormAppController = bookingFormAppController;
        this.nomeBarbiereDaInserire.setText(requestAppointmentsBean.getNameBarber());
        this.dataDaInserire.setText(requestAppointmentsBean.getDate().toString());
        this.orarioDaInserire.setText(requestAppointmentsBean.getOrario());
        this.statoRichiesta.setText(requestAppointmentsBean.getState().getId());
    }

}
