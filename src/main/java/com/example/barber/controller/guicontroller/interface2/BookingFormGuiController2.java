package com.example.barber.controller.guicontroller.interface2;


import com.example.barber.controller.appcontroller.CheckRequestAppController;
import com.example.barber.utils.Session;
import com.example.barber.utils.bean.ClientBean;
import com.example.barber.utils.bean.IdBean;
import com.example.barber.utils.bean.PreFormBarberBean;
import com.example.barber.utils.bean.interfaccia2.ClientBean2;
import com.example.barber.utils.bean.interfaccia2.RequestAppointmentsBean2;
import com.example.barber.utils.exception.ErrorDialog;
import com.example.barber.utils.exception.myexception.EmptyInputException;
import com.example.barber.utils.exception.myexception.InvalidDateException;
import com.example.barber.utils.exception.myexception.SystemException;
import com.example.barber.utils.statorichiesta.StatoRichieste;
import com.example.barber.utils.switchPage.SwitchAndSetPage;
import com.example.barber.utils.switchPage.SwitchPage;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

import java.util.List;


public class BookingFormGuiController2 {

    private ClientBean clientBean = new ClientBean2();
    private PreFormBarberBean preFormBarberBean = new PreFormBarberBean();


    @FXML
    private TextField nameField;
    @FXML
    private TextField phoneField;
    @FXML
    private TextField dayField;
    @FXML
    private TextField monthField;
    @FXML
    private TextField yearField;

    @FXML
    private ComboBox<String> serviceComboBox;
    @FXML
    private TextField orario;
    @FXML
    private TextField notes;
    @FXML
    private TextField emailField;


    private SwitchAndSetPage switchAndSetPage = new SwitchAndSetPage();
    private SwitchPage switchPage = new SwitchPage();



    @FXML
    private void handleBooking(ActionEvent event) {
        CheckRequestAppController checkRequestAppController = new CheckRequestAppController();
        RequestAppointmentsBean2 rAppBean = new RequestAppointmentsBean2();
        try{
            rAppBean.setIdUser(clientBean.getId());
            rAppBean.setIdBarber(preFormBarberBean.getIdBarber());
            rAppBean.setNameBarber(preFormBarberBean.getBarberName());
            rAppBean.setPhoneUser(phoneField.getText());
            rAppBean.setNameUser(clientBean.getName());
            rAppBean.setDate(dayField.getText(), monthField.getText(), yearField.getText());
            rAppBean.setAddressBarber(preFormBarberBean.getBarberAddress());
            rAppBean.setService(serviceComboBox.getValue());
            rAppBean.setState(StatoRichieste.PENDENTE);
            rAppBean.setOrario(orario.getText());
            rAppBean.setDescription(notes.getText());
        }catch( IllegalArgumentException | EmptyInputException | InvalidDateException e ){
            ErrorDialog.getInstance().handleException(e);
        }
        checkRequestAppController.sendAppointments(rAppBean);
        try{
            switchAndSetPage.switchAndSetHomePageClient(event, "/view/interface2/HomePageClientAppointments2.fxml", rAppBean);
        }catch (SystemException | EmptyInputException e){
            ErrorDialog.getInstance().handleException(e);
        }
    }

    @FXML
    private void goBack(ActionEvent event) {
        IdBean idBean = new IdBean();
        idBean.setId(preFormBarberBean.getIdBarber());
        try {
            switchPage.switchPageId( "/view/interface2/BarberDetail2.fxml",event,idBean);
        } catch (SystemException e) {
            ErrorDialog.getInstance().handleException(e);
        }
    }


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


}
