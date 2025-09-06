package com.example.barber.controller.guicontroller.interface2;

import com.example.barber.controller.appcontroller.CheckRequestAppController;
import com.example.barber.controller.guicontroller.interface2.item2.AppointmentsItemBarberGuiControllerSecondInterface;import com.example.barber.utils.Session;
import com.example.barber.utils.bean.RequestAppointmentsBean;
import com.example.barber.utils.bean.interfaccia2.RequestAppointmentsBean2;
import com.example.barber.utils.exception.ErrorDialog;
import com.example.barber.utils.exception.myexception.EmptyInputException;
import com.example.barber.utils.exception.myexception.SystemException;
import com.example.barber.utils.observer.Observer;
import com.example.barber.utils.setterandgetter.SetterClass;
import com.example.barber.utils.statorichiesta.StatoRichieste;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import javafx.scene.layout.Pane;

import java.io.IOException;
import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;

public class PageManageBarberAppointmentsGuiController2 implements Observer, Initializable {

    private CheckRequestAppController controller = new CheckRequestAppController();
    private static final String APPOINTMENTS_ITEM_BARBER_FXML = "/view/interface2/AppointmentsItemBarber2.fxml";
    private SetterClass setterClass = new SetterClass();
    RequestAppointmentsBean2 requestAppointmentsBean2 = new RequestAppointmentsBean2();

    @FXML
    private ListView<Pane> listViewAppointments;

    private StatoRichieste state = StatoRichieste.PENDENTE;

    @FXML
    public void showPending(ActionEvent event){
        state = StatoRichieste.PENDENTE;
        listViewAppointments.getItems().clear();
        reload();


    }

    @FXML
    public void showDeclined(){
        state = StatoRichieste.RIFIUTATA;
        listViewAppointments.getItems().clear();
        reload();
    }

    @FXML
    public void showAccepted(){
        state = StatoRichieste.ACCETTATA;
        listViewAppointments.getItems().clear();
        reload();
    }


    @FXML
    public void showTerminate(){
        state = StatoRichieste.TERMINATA;
        listViewAppointments.getItems().clear();
        reload();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        try{
            controller.manageRequestAppointments(this, Session.getInstance().getBarber().getId(), Session.getInstance().getCredentials().getType().getRoleId());
        }catch (SystemException | EmptyInputException e){
            ErrorDialog.getInstance().handleException(e);
        }

    }

    public void reload(){
        try{
            controller.manageRequestAppointments(this, Session.getInstance().getBarber().getId(), Session.getInstance().getCredentials().getType().getRoleId());
        }catch (SystemException | EmptyInputException e ){
            ErrorDialog.getInstance().handleException(e);
        }
    }





    @Override
    public void update(Object ob) {
        if(ob instanceof RequestAppointmentsBean rBean){

            if(!matchState(rBean))  return;

            RequestAppointmentsBean2 requestAppointmentsBean1 = new RequestAppointmentsBean2();
            try{
                setterClass.setRequestApp(requestAppointmentsBean1,(RequestAppointmentsBean)ob );
                loadPane(requestAppointmentsBean1);
            }catch (EmptyInputException | IOException e ){
                ErrorDialog.getInstance().handleException(e);
            }

        }
    }

    private boolean matchState(RequestAppointmentsBean rBean){
        String s = rBean.getState().getId();

        switch (state.getId()) {
            case "PENDENTE":
                return s.equals("PENDENTE");
            case "ACCETTATA":
                return s.equals("ACCETTATA");
            case "RIFIUTATA":
                return s.equals("RIFIUTATA");
            case "TERMINATA":
                return s.equals("TERMINATA");
            default:
                return true;
        }
    }

    private void loadPane(RequestAppointmentsBean2 rBean) throws IOException {
        AppointmentsItemBarberGuiControllerSecondInterface itemController;
        Pane pane = null;
        FXMLLoader fxmlLoader = new FXMLLoader();
        pane = fxmlLoader.load(Objects.requireNonNull(getClass().getResource(APPOINTMENTS_ITEM_BARBER_FXML).openStream()));
        itemController = fxmlLoader.getController();
        itemController.setAll(rBean,controller);
        itemController.setVisibilityBotton(rBean.getState());
        this.listViewAppointments.getItems().add(pane);
    }


}