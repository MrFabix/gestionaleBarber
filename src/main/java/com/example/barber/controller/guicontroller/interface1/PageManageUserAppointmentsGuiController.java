package com.example.barber.controller.guicontroller.interface1;

import com.example.barber.controller.appcontroller.BookingFormAppController;
import com.example.barber.utils.Session;
import com.example.barber.utils.bean.IdBean;
import com.example.barber.utils.bean.RequestAppointmentsBean;
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



    @FXML
    private ListView<Pane> listViewPendingAppointments;
    private RequestAppointmentsBean requestAppointmentsBean;


    private BookingFormAppController bookingFormAppController = new BookingFormAppController();

    private void handleRequest(RequestAppointmentsBean rBean){
        //va creato il RequestItemGuiController
        FXMLLoader fxmlLoader = new FXMLLoader();
        Pane pane = null;
        try{
            if(Objects.equals(rBean.getState().getId(), "PENDENTE")){
                //SETTAilPane PENDENTE
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





    public void setAll(RequestAppointmentsBean rBean, BookingFormAppController bookingFormAppController) {
        this.requestAppointmentsBean = new RequestAppointmentsBean(rBean);
    }



    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        try {
            bookingFormAppController.manageRequestAppointments(this, new IdBean(Session.getInstance().getUser().getId()));
        } catch () {

        }
    }


    @Override
    public void update(Object ob) {
        if(ob instanceof RequestAppointmentsBean rBean){
            handleRequest(rbean);
        }
    }
}
