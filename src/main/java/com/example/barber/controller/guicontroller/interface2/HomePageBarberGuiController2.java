package com.example.barber.controller.guicontroller.interface2;

import com.example.barber.controller.appcontroller.CheckRequestAppController;
import com.example.barber.controller.guicontroller.interface2.item2.AppointmentsItemBarberGuiControllerSecondInterface;
import com.example.barber.utils.Session;
import com.example.barber.utils.bean.RequestAppointmentsBean;
import com.example.barber.utils.bean.interfaccia2.RequestAppointmentsBean2;
import com.example.barber.utils.exception.ErrorDialog;
import com.example.barber.utils.exception.myexception.EmptyInputException;
import com.example.barber.utils.exception.myexception.SystemException;
import com.example.barber.utils.observer.Observer;
import com.example.barber.utils.setterandgetter.SetterClass;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import javafx.scene.layout.Pane;

import java.io.IOException;
import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;

public class HomePageBarberGuiController2 implements Observer, Initializable {

    @FXML
    private ListView<Pane> listNextAppointemtns;
    @FXML
    private ListView<Pane> listTerminateAppointments;
    private CheckRequestAppController controller = new CheckRequestAppController();
    private SetterClass setterClass = new SetterClass();

    private static final String APPOINTMENTS_ITEM_BARBER_FXML = "/view/interface2/AppointmentsItemBarber2.fxml";



    private void moveRequest(RequestAppointmentsBean2 rBean){
        AppointmentsItemBarberGuiControllerSecondInterface itemController;
        FXMLLoader fxmlLoader = new FXMLLoader();
        Pane pane = null;
        try {
            if (Objects.equals(rBean.getState().getId(), "ACCETTATA")) {
                pane = fxmlLoader.load(Objects.requireNonNull(getClass().getResource(APPOINTMENTS_ITEM_BARBER_FXML).openStream()));
                itemController = fxmlLoader.getController();
                itemController.setAll(rBean, controller);
                itemController.setVisibilityBotton(rBean.getState());
                this.listNextAppointemtns.getItems().add(pane);
            } else if (Objects.equals(rBean.getState().getId(), "TERMINATA")) {
                pane = fxmlLoader.load(Objects.requireNonNull(getClass().getResource(APPOINTMENTS_ITEM_BARBER_FXML).openStream()));
                itemController = fxmlLoader.getController();
                itemController.setAll(rBean, controller);
                itemController.setVisibilityBotton(rBean.getState());
                this.listTerminateAppointments.getItems().add(pane);
            }
        }catch (IOException e){
            ErrorDialog.getInstance().handleException(e);
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        try{
            controller.manageRequestAppointments(this, Session.getInstance().getBarber().getId(), Session.getInstance().getCredentials().getType().getRoleId());
        }catch (SystemException e){
            ErrorDialog.getInstance().handleException(e);
        }

    }

    @Override
    public void update(Object ob) {
        if(ob instanceof RequestAppointmentsBean rBean){

            RequestAppointmentsBean2 requestAppointmentsBean1 = new RequestAppointmentsBean2();
            try{
                setterClass.setRequestApp(requestAppointmentsBean1,rBean );
                moveRequest(requestAppointmentsBean1);
            }catch (EmptyInputException e ){
                ErrorDialog.getInstance().handleException(e);
            }

        }
    }
}