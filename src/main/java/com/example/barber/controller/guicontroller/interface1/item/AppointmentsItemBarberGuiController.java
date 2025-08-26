package com.example.barber.controller.guicontroller.interface1.item;

import com.example.barber.controller.appcontroller.CheckRequestAppController;
import com.example.barber.utils.bean.RequestAppointmentsBean;
import com.example.barber.utils.statorichiesta.StatoRichieste;
import com.example.barber.utils.switchpage.SwitchPage;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;


public class AppointmentsItemBarberGuiController {

    private CheckRequestAppController checkRequestAppController;

    private RequestAppointmentsBean rBean;

    private SwitchPage switchPage = new SwitchPage();

    @FXML
    private Label labelNameClient;
    @FXML
    private Label labelData;
    @FXML
    private Label orario;
    @FXML
    private Label servizio;
    @FXML
    private Label stato;
    @FXML
    private Button acceptButton;
    @FXML
    private Button refutedButton;
    @FXML
    private Button terminateAppointments;

    public void setAll(RequestAppointmentsBean rBean, CheckRequestAppController checkRequestAppController){
        this.checkRequestAppController = checkRequestAppController;
        this.rBean = rBean;
        this.labelNameClient.setText(rBean.getNameUser());
        this.orario.setText(rBean.getOrario());
        this.stato.setText(rBean.getState().getId());
        this.servizio.setText(rBean.getService());
        this.labelData.setText(rBean.getDate().toString());
    }

    public void setVisibilityButton(){
        acceptButton.setVisible(false);
        refutedButton.setVisible(false);
    }

    public void setVisibilityTer(boolean bool){
        terminateAppointments.setVisible(bool);
    }

    @FXML
    public void refutedApp(ActionEvent event) {
        try{
            checkRequestAppController.setStateAppointments(rBean, StatoRichieste.RIFIUTATA);
            rBean.setState(StatoRichieste.RIFIUTATA);
            checkRequestAppController.addAppointmentsToList(rBean);
            switchPage.replaceScene(event, "/HomePageBarberAppointments.fxml");
        }catch (Exception e){
            e.printStackTrace();
        }

    }

    @FXML
    public void acceptApp(ActionEvent event){
        try{
            checkRequestAppController.setStateAppointments(rBean, StatoRichieste.ACCETTATA);
            rBean.setState(StatoRichieste.ACCETTATA);
            checkRequestAppController.addAppointmentsToList(rBean);
            switchPage.replaceScene(event, "/HomePageBarberAppointments.fxml");
        }catch (Exception e){
            e.printStackTrace();
        }

    }

    @FXML
    public void terminateApp(ActionEvent event){
        try{
            checkRequestAppController.setStateAppointments(rBean, StatoRichieste.TERMINATA);
            rBean.setState(StatoRichieste.ACCETTATA);
            checkRequestAppController.addAppointmentsToList(rBean);
            switchPage.replaceScene(event, "/HomePageBarber.fxml");
        }catch (Exception e){
            e.printStackTrace();
        }

    }



}
