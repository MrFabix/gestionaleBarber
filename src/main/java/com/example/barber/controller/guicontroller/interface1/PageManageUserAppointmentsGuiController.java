package com.example.barber.controller.guicontroller.interface1;

import com.example.barber.controller.appcontroller.CheckRequestAppController;
import com.example.barber.controller.guicontroller.interface1.item.AppointmentsItemUserGuiController;
import com.example.barber.utils.Session;
import com.example.barber.utils.bean.RequestAppointmentsBean;
import com.example.barber.utils.exception.ErrorDialog;
import com.example.barber.utils.exception.myexception.SystemException;
import com.example.barber.utils.observer.Observer;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import javafx.scene.layout.Pane;

import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;

public class PageManageUserAppointmentsGuiController implements Observer, Initializable {
    private RequestAppointmentsBean requestAppointmentsBean;
    private CheckRequestAppController controller = new CheckRequestAppController();
    private String APPOINTMENTS_ITEM_FXML = "/AppointmentsItemUser.fxml";


    @FXML
    private ListView<Pane> listViewPendingAppointments;
    @FXML
    private ListView<Pane> listViewAcceptedAppointments;
    @FXML
    private ListView<Pane> listViewRefiutedDeclined;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        try{
            controller.manageRequestAppointments(this, Session.getInstance().getUser().getId(), Session.getInstance().getCredentials().getType().getRoleId());
        }catch (SystemException e ){
            ErrorDialog.getInstance().handleException(e);
        }

    }

    private void handleRequest(RequestAppointmentsBean rBean){
        AppointmentsItemUserGuiController controller;
        FXMLLoader fxmlLoader = new FXMLLoader();
        Pane pane = null;
        try{
            if(Objects.equals(rBean.getState().getId(), "PENDENTE")){
                pane = fxmlLoader.load(Objects.requireNonNull(getClass().getResource(APPOINTMENTS_ITEM_FXML).openStream()));
                controller = fxmlLoader.getController();
                controller.setAll(rBean);
                this.listViewPendingAppointments.getItems().add(pane);
            }else if(Objects.equals(rBean.getState().getId(), "RIFIUTATA")){
                pane = fxmlLoader.load(Objects.requireNonNull(getClass().getResource(APPOINTMENTS_ITEM_FXML).openStream()));
                controller = fxmlLoader.getController();
                controller.setAll(rBean);
                this.listViewRefiutedDeclined.getItems().add(pane);
                //SETTA IL PANE RIFIUTATA
            } else if (Objects.equals(rBean.getState().getId(), "ACCETTATA")) {
                pane = fxmlLoader.load(Objects.requireNonNull(getClass().getResource(APPOINTMENTS_ITEM_FXML).openStream()));
                controller = fxmlLoader.getController();
                controller.setAll(rBean);
                this.listViewAcceptedAppointments.getItems().add(pane);
                //SETTA IL PANE ACCETATA
            }
        }catch (Exception e){
            //DA mette le systemexception
            ErrorDialog.getInstance().handleException(e);
        }
    }


    public void setAll(RequestAppointmentsBean rBean) {
        this.requestAppointmentsBean = new RequestAppointmentsBean(rBean);
        controller.addAppointmentsToList(requestAppointmentsBean);
    }



    @Override
    public void update(Object ob) {
        if(ob instanceof RequestAppointmentsBean rBean){
            handleRequest(rBean);
        }
    }
}
