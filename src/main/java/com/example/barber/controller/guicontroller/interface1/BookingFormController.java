package com.example.barber.controller.guicontroller.interface1;

import com.example.barber.controller.appcontroller.BarberAppController;
import com.example.barber.utils.Session;
import com.example.barber.utils.bean.BarberBean;
import com.example.barber.utils.bean.IdBean;
import com.example.barber.utils.exception.ErrorDialog;
import com.example.barber.utils.exception.myexception.SystemException;
import com.example.barber.utils.switchPage.SwitchPage;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;

public class BookingFormController {

    @FXML
    private TextField nameField;
    @FXML
    private TextField phoneField;
    @FXML
    private DatePicker appointmentDatePicker;
    @FXML
    private ComboBox<String> serviceComboBox;
    @FXML
    private TextField notesField;
    @FXML
    private TextField emailField;
    @FXML
    private Button bookButton;

    SwitchPage switchPage = new SwitchPage();

    // Handle the form submission
    @FXML
    private void handleBooking() {
        String name = nameField.getText();
        String phone = phoneField.getText();
        String date = appointmentDatePicker.getValue() != null ? appointmentDatePicker.getValue().toString() : "No date selected";
        String service = serviceComboBox.getValue();
        String notes = notesField.getText();
        String email = emailField.getText();

        // Handle booking logic here (e.g., save to database, send confirmation, etc.)
        System.out.println("Booking Details:");
        System.out.println("Name: " + name);
        System.out.println("Phone: " + phone);
        System.out.println("Appointment Date: " + date);
        System.out.println("Service: " + service);
        System.out.println("Notes: " + notes);
        System.out.println("Email: " + email);

        // Add your logic for saving or sending booking information here.
    }

    @FXML
    private void goBack(ActionEvent event) {
        //prendo id dall button
        System.out.println("Booking Form Controller: goBack");

        try {
            switchPage.switchPageId( "/BarberDetail.fxml",event, new IdBean((int)bookButton.getUserData()) );
        } catch (SystemException e) {
            ErrorDialog.getInstance().handleException(e);
        }
    }

    public void setBookingForm(IdBean id) {
        // Access data from session
        Session session = Session.getInstance();
        //setto iD del barbiere nel bottone
        bookButton.setUserData(id.getId());
        // Print user information (for debugging)
        if (session.getUser() != null) {

            //Inserisco il Nome della persona che ha effettuato il login
            nameField.setText(session.getUser().getName()+" "+session.getUser().getSurname());
            emailField.setText(session.getUser().getEmail());
            System.out.println("User session found: " + session.getUser().getName());


        } else {
            //chiudo la finestra
            System.out.println("User session not found");

        }


    }

}
