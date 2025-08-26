package com.example.barber.controller.guicontroller.interface1;

import com.example.barber.controller.appcontroller.CheckRequestAppController;
import com.example.barber.controller.guicontroller.interface1.item.AppointmentsItemBarberGuiController;
import com.example.barber.utils.Session;
import com.example.barber.utils.bean.RequestAppointmentsBean;
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

public class PageManageBarberAppointmentsGuiController implements Observer, Initializable {

    private CheckRequestAppController controller = new CheckRequestAppController();
    private String AppointmentsItemFxml = "/AppointmentsItemBarber.fxml";

    @FXML
    private ListView<Pane> listViewPendingAppointments;
    @FXML
    private ListView<Pane> listViewAcceptedAppointments;
    @FXML
    private ListView<Pane> listViewRefiutedDeclined;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        try{
            controller.manageRequestAppointments(this, Session.getInstance().getBarber().getId(), Session.getInstance().getCredentials().getType().getRoleId());
        }catch (SystemException e ){
            e.printStackTrace();
        }

    }

    private void handleRequest(RequestAppointmentsBean rBean){
        AppointmentsItemBarberGuiController itemController;
        FXMLLoader fxmlLoader = new FXMLLoader();
        Pane pane = null;
        try{
            if(Objects.equals(rBean.getState().getId(), "PENDENTE")){
                pane = fxmlLoader.load(Objects.requireNonNull(getClass().getResource(AppointmentsItemFxml).openStream()));
                itemController = fxmlLoader.getController();
                itemController.setAll(rBean, controller);
                this.listViewPendingAppointments.getItems().add(pane);
            }else if(Objects.equals(rBean.getState().getId(), "RIFIUTATA")){
                pane = fxmlLoader.load(Objects.requireNonNull(getClass().getResource(AppointmentsItemFxml).openStream()));
                itemController = fxmlLoader.getController();
                itemController.setVisibilityButton();
                itemController.setAll(rBean,controller);

                this.listViewRefiutedDeclined.getItems().add(pane);
            } else if (Objects.equals(rBean.getState().getId(), "ACCETTATA")) {
                pane = fxmlLoader.load(Objects.requireNonNull(getClass().getResource(AppointmentsItemFxml).openStream()));
                itemController = fxmlLoader.getController();
                itemController.setAll(rBean,controller);
                itemController.setVisibilityButton();
                this.listViewAcceptedAppointments.getItems().add(pane);
            }
        }catch (Exception e){
            //DA mette le systemexception
            e.printStackTrace();
        }
    }





    @Override
    public void update(Object ob) {
        if(ob instanceof RequestAppointmentsBean rBean){
            handleRequest(rBean);
        }
    }


}
