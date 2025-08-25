package com.example.barber.controller.guicontroller.interface1;

import com.example.barber.controller.appcontroller.BookingAppController;
import com.example.barber.controller.appcontroller.CheckRequestAppController;
import com.example.barber.controller.guicontroller.interface1.item.AppointmentsItemUserGuiController;
import com.example.barber.utils.Session;
import com.example.barber.utils.bean.IdBean;
import com.example.barber.utils.bean.RequestAppointmentsBean;
import com.example.barber.utils.bean.UserBean;
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
    private static final String APPOINTMENTS_ITEM_FXML = "/AppointmentsItemUser.fxml";


    @FXML
    private ListView<Pane> listViewPendingAppointments;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        CheckRequestAppController controller = new CheckRequestAppController();
        try{
            controller.manageRequestAppointments(this, Session.getInstance().getUser().getId());
        }catch (SystemException e ){
            e.printStackTrace();
        }

    }

    private void handleRequest(RequestAppointmentsBean rBean){
        //va creato il RequestItemGuiController, no sarebber il nostro AppointemntsBeanItem
        //Ho capito, praticamente questo controllore chiama l'appointmentsGuiController
        //prendere uel controller, prende i dati
        //Presi i dati aggiunge l'item alla lista dei pendenti
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
                //SETTA IL PANE RIFIUTATA
            } else if (Objects.equals(rBean.getState().getId(), "ACCETTATA")) {
                //SETTA IL PANE ACCETATA
            }
        }catch (Exception e){
            //DA mette le systemexception
            e.printStackTrace();
        }
    }





    public void setAll(RequestAppointmentsBean rBean, BookingAppController bookingAppController) {
        this.requestAppointmentsBean = new RequestAppointmentsBean(rBean);
    }



    @Override
    public void update(Object ob) {
        if(ob instanceof RequestAppointmentsBean rBean){
            handleRequest(rBean);
        }
    }
}
