package com.example.barber.controller.guicontroller.interface1;


import com.example.barber.controller.appcontroller.CheckRequestAppController;
import com.example.barber.utils.Session;
import com.example.barber.utils.bean.*;
import com.example.barber.utils.bean.interfaccia1.ClientBean1;
import com.example.barber.utils.exception.ErrorDialog;
import com.example.barber.utils.exception.myexception.EmptyInputException;
import com.example.barber.utils.exception.myexception.InvalidDateException;
import com.example.barber.utils.exception.myexception.SystemException;
import com.example.barber.utils.enumeration.statorichieste.StatoRichieste;
import com.example.barber.utils.scene.SwitchAndSetPage;
import com.example.barber.utils.scene.SwitchPage;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;

import java.util.List;


public class BookingFormGuiController1 {

    private ClientBean clientBean = new ClientBean1();
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
    private TextField orario;
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
            List<String> serviceList;
            clientBean = Session.getInstance().getUser();

            nameField.setText(clientBean.getName());
            phoneField.setText(clientBean.getPhone());
            emailField.setText(clientBean.getEmail());
            this.preFormBarberBean.setIdBarber(bean.getIdBarber());
            this.preFormBarberBean.setBarberName(bean.getBarberName());
            this.preFormBarberBean.setBarberAddress(bean.getBarberAddress());

            serviceList = bean.getServiceList();

            for(String s : serviceList){
                serviceComboBox.getItems().add(s);
            }

    }

    // Handle the form submission
    @FXML
    private void handleBooking(ActionEvent event) throws InvalidDateException, EmptyInputException{
        CheckRequestAppController checkRequestAppController = new CheckRequestAppController();
        RequestAppointmentsBean requestAppointmentsBean = new RequestAppointmentsBean();

        //Setto l'appointmentsBean

        try{
            requestAppointmentsBean.setIdUser(clientBean.getId());
            requestAppointmentsBean.setIdBarber(preFormBarberBean.getIdBarber());
            requestAppointmentsBean.setNameBarber(preFormBarberBean.getBarberName());
            requestAppointmentsBean.setPhoneUser(phoneField.getText());
            requestAppointmentsBean.setNameUser(clientBean.getName());
            requestAppointmentsBean.setDate(appointmentDatePicker.getValue());
            requestAppointmentsBean.setDescription(notesField.getText());
            requestAppointmentsBean.setAddressBarber(preFormBarberBean.getBarberAddress());
            requestAppointmentsBean.setService(serviceComboBox.getValue());
            requestAppointmentsBean.setState(StatoRichieste.PENDENTE);
            requestAppointmentsBean.setOrario(orario.getText());
            //Switch dopo CheckRequestApp controller
            checkRequestAppController.sendAppointments(requestAppointmentsBean);

            switchAndSetPage.switchAndSetHomePageClient(event, "/view/interface1/HomePageClientAppointments1.fxml", requestAppointmentsBean);
        }catch(SystemException | InvalidDateException | EmptyInputException e ){
            ErrorDialog.getInstance().handleException(e);
        }

    }

    @FXML
    private void goBack(ActionEvent event) {
        IdBean idBean = new IdBean();
        idBean.setId(preFormBarberBean.getIdBarber());
        try {
            switchPage.switchPageId( "/view/interface1/BarberDetail.fxml",event,idBean);
        } catch (SystemException e) {
            ErrorDialog.getInstance().handleException(e);
        }
    }



}
