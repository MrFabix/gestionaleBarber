package com.example.barber.controller.guicontroller.interface1;

import com.example.barber.controller.appcontroller.BookingAppController;
import com.example.barber.controller.appcontroller.CheckRequestAppController;
import com.example.barber.utils.Session;
import com.example.barber.utils.bean.*;
import com.example.barber.utils.exception.ErrorDialog;
import com.example.barber.utils.exception.myexception.EmptyInputException;
import com.example.barber.utils.exception.myexception.InvalidDateException;
import com.example.barber.utils.exception.myexception.SystemException;
import com.example.barber.utils.statorichiesta.StatoRichieste;
import com.example.barber.utils.switchpage.SwitchAndSetPage;
import com.example.barber.utils.switchpage.SwitchPage;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;


public class BookingFormGuiController{

    private UserBean userBean = new UserBean();
    private PreFormBarberBean preFormBarberBean = new PreFormBarberBean();


    @FXML
    private TextField nameField;
    @FXML
    private TextField phoneField;
    @FXML
    private DatePicker appointmentDatePicker;
    @FXML
    private ComboBox<String> serviceComboBox;
    @FXML
    private ComboBox<String> orarioComboBox;
    @FXML
    private TextField notesField;
    @FXML
    private TextField emailField;
    @FXML
    private Button bookButton;
    @FXML
    private Button goBackButton;

    private SwitchAndSetPage switchAndSetPage = new SwitchAndSetPage();
    private SwitchPage switchPage = new SwitchPage();


    public void setAll(PreFormBarberBean bean){
            userBean = Session.getInstance().getUser();
            System.out.println("userBean = " + userBean.toString());
            nameField.setText(userBean.getName());
            phoneField.setText(userBean.getPhone());
            emailField.setText(userBean.getEmail());
            this.preFormBarberBean.setIdBarber(bean.getIdBarber());
            this.preFormBarberBean.setBarberName(bean.getBarberName());
            this.preFormBarberBean.setBarberAddress(bean.getBarberAddress());
    }

    // Handle the form submission
    @FXML
    private void handleBooking(ActionEvent event) throws InvalidDateException, EmptyInputException{
        BookingAppController bookingAppController = new BookingAppController();
        RequestAppointmentsBean requestAppointmentsBean = new RequestAppointmentsBean();
        CheckRequestAppController checkRequestAppController = new CheckRequestAppController();

        //Setto l'appointmentsBean

        try{
            requestAppointmentsBean.setIdUser(userBean.getId());
            requestAppointmentsBean.setIdBarber(preFormBarberBean.getIdBarber());
            requestAppointmentsBean.setNameBarber(preFormBarberBean.getBarberName());
            requestAppointmentsBean.setPhoneUser(phoneField.getText());
            requestAppointmentsBean.setNameUser(userBean.getName());
            requestAppointmentsBean.setDate(appointmentDatePicker.getValue());
            requestAppointmentsBean.setDescription(notesField.getText());
            requestAppointmentsBean.setAddressBarber(preFormBarberBean.getBarberAddress());
            requestAppointmentsBean.setService(serviceComboBox.getValue());
            requestAppointmentsBean.setState(StatoRichieste.PENDENTE);
            requestAppointmentsBean.setOrario(orarioComboBox.getValue());
            switchAndSetPage.switchAndSetHomePageClient(event, "/HomePageClientAppointments.fxml", requestAppointmentsBean , bookingAppController);
        }catch(SystemException | InvalidDateException | EmptyInputException e ){
            ErrorDialog.getInstance().handleException(e);
            e.printStackTrace();
        }
        bookingAppController.sendAppointments(requestAppointmentsBean);
    }

    @FXML
    private void goBack(ActionEvent event) {
        IdBean idBean = new IdBean();
        idBean.setId(preFormBarberBean.getIdBarber());
        try {
            switchPage.switchPageId( "/BarberDetail.fxml",event,idBean);
        } catch (SystemException e) {
            ErrorDialog.getInstance().handleException(e);
        }
    }



}
