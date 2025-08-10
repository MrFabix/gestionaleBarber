package com.example.barber.controller.guicontroller.interface1;

import com.example.barber.controller.appcontroller.BookingFormAppController;
import com.example.barber.utils.Session;
import com.example.barber.utils.bean.*;
import com.example.barber.utils.exception.ErrorDialog;
import com.example.barber.utils.exception.myexception.EmptyInputException;
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

import java.net.URL;
import java.util.ResourceBundle;

public class BookingFormGuiController implements Initializable {

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

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        userBean = Session.getInstance().getUser();
        nameField.setText(userBean.getName());
        phoneField.setText(userBean.getPhone());
        emailField.setText(userBean.getEmail());
    }

    public void setAll(PreFormBarberBean bean) {


        System.out.println("setAll: "+ bean.toString());

        this.preFormBarberBean.setIdBarber(bean.getIdBarber());
        this.preFormBarberBean.setBarberName(bean.getBarberName());
        this.preFormBarberBean.setBarberAddress(bean.getBarberAddress());
    }






    // Handle the form submission
    @FXML
    private void handleBooking(ActionEvent event) throws EmptyInputException{
        BookingFormAppController bookingFormAppController = new BookingFormAppController();
        RequestAppointmentsBean requestAppointmentsBean = new RequestAppointmentsBean();
        //Setto l'appointmentsBean
        System.out.println("Nome del barbiere in bookingformguicontroller prima del set: "+preFormBarberBean.getBarberName());
        requestAppointmentsBean.setIdUser(userBean.getId());
        requestAppointmentsBean.setIdBarber(preFormBarberBean.getIdBarber());
        requestAppointmentsBean.setNameBarber(preFormBarberBean.getBarberName());
        requestAppointmentsBean.setNameUser(userBean.getName());
        requestAppointmentsBean.setPhoneUser(phoneField.getText());
        requestAppointmentsBean.setDate(appointmentDatePicker.getValue());
        requestAppointmentsBean.setDescription(notesField.getText());
        requestAppointmentsBean.setAddressBarber(preFormBarberBean.getBarberAddress());
        requestAppointmentsBean.setService(serviceComboBox.getValue());
        requestAppointmentsBean.setPhoneUser(phoneField.getText());
        requestAppointmentsBean.setState(StatoRichieste.PENDENTE);
        requestAppointmentsBean.setOrario(orarioComboBox.getValue());

        System.out.println("Il campo phone vale "+ requestAppointmentsBean.getPhoneUser());

        System.out.println("Nome del barbiere in bookingFormGuiController: "+requestAppointmentsBean.getNameBarber());
        bookingFormAppController.sendAppointments(requestAppointmentsBean);

        try{
            //Carichiamo l'requestAppointmentsBean
            switchAndSetPage.switchAndSetHomePageClient(event, "/HomePageClientAppointments.fxml", requestAppointmentsBean , bookingFormAppController);
            // Add your logic for saving or sending booking information here.
        }catch(SystemException e ){
            ErrorDialog.getInstance().handleException(e);
        }

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
