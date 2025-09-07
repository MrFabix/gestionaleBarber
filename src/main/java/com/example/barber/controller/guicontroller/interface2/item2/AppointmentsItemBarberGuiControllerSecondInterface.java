package com.example.barber.controller.guicontroller.interface2.item2;

import com.example.barber.controller.appcontroller.CheckRequestAppController;
import com.example.barber.utils.bean.RequestAppointmentsBean;
import com.example.barber.utils.bean.interfaccia2.RequestAppointmentsBean2;
import com.example.barber.utils.exception.ErrorDialog;
import com.example.barber.utils.statorichiesta.StatoRichieste;
import com.example.barber.utils.switchpage.SwitchPage;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import java.time.format.DateTimeFormatter;
import java.util.Locale;


public class AppointmentsItemBarberGuiControllerSecondInterface{

    private CheckRequestAppController checkRequestAppController;
    private RequestAppointmentsBean rBean;
    private SwitchPage switchPage = new SwitchPage();



    @FXML
    private Button acceptButton;
    @FXML
    private Button refutedButton;
    @FXML
    private Button terminateAppointments;
    @FXML
    private Label labelName;
    @FXML
    private Label labelServizio;
    @FXML
    private Label labelData;
    @FXML
    private Label labelOrario;
    @FXML
    private Label labelStato;


    @FXML
    public void acceptApp(ActionEvent event){
        try{
            checkRequestAppController.setStateAppointments(rBean, StatoRichieste.ACCETTATA);
            rBean.setState(StatoRichieste.ACCETTATA);
            checkRequestAppController.addAppointmentsToList(rBean);
            switchPage.replaceScene(event, "/view/interface2/HomePageBarberAppointments2.fxml");
        }catch (Exception e){
            ErrorDialog.getInstance().handleException(e);
        }

    }

    @FXML
    public void terminateApp(ActionEvent event){
        try{
            checkRequestAppController.setStateAppointments(rBean, StatoRichieste.TERMINATA);
            rBean.setState(StatoRichieste.ACCETTATA);
            checkRequestAppController.addAppointmentsToList(rBean);
            switchPage.replaceScene(event, "/view/interface2/HomePageBarber2.fxml");
        }catch (Exception e){
            ErrorDialog.getInstance().handleException(e);
        }

    }


    @FXML
    public void refutedApp(ActionEvent event) {
        try{
            checkRequestAppController.setStateAppointments(rBean, StatoRichieste.RIFIUTATA);
            rBean.setState(StatoRichieste.RIFIUTATA);
            checkRequestAppController.addAppointmentsToList(rBean);
            switchPage.replaceScene(event, "/view/interface2/HomePageBarberAppointments2.fxml");
        }catch (Exception e){
            ErrorDialog.getInstance().handleException(e);
        }

    }



    public void setAll(RequestAppointmentsBean2 requestAppointmentsBean2, CheckRequestAppController checkRequestAppController){
        this.checkRequestAppController = checkRequestAppController;
        this.rBean = requestAppointmentsBean2;
        labelName.setText(rBean.getNameBarber());
        labelServizio.setText(rBean.getService());
        labelOrario.setText(rBean.getOrario());
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy", Locale.ITALY);
        labelData.setText(rBean.getDate() != null ? rBean.getDate().format(fmt) : "");
        labelStato.setText(rBean.getState().getId());
    }

    public void setVisibilityBotton(StatoRichieste state){
        switch(state){
            case ACCETTATA:
                acceptButton.setVisible(false);
                refutedButton.setVisible(false);
                acceptButton.setDisable(true);
                refutedButton.setDisable(true);
                terminateAppointments.setVisible(true);
                break;
            case RIFIUTATA:
            case TERMINATA:
                acceptButton.setVisible(false);
                refutedButton.setVisible(false);
                terminateAppointments.setVisible(false);
                acceptButton.setDisable(true);
                refutedButton.setDisable(true);
                terminateAppointments.setDisable(true);
                break;
            case PENDENTE:
                acceptButton.setVisible(true);
                refutedButton.setVisible(true);
                terminateAppointments.setVisible(false);
                terminateAppointments.setDisable(false);
                break;
            default:
                break;
        }
    }




}
