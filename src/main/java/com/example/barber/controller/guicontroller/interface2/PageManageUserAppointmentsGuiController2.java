package com.example.barber.controller.guicontroller.interface2;

import com.example.barber.controller.appcontroller.CheckRequestAppController;
import com.example.barber.controller.guicontroller.interface2.item2.AppointmentsItemUserGuiControllerSecondInterface;
import com.example.barber.utils.Session;
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
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.layout.Pane;

import java.io.IOException;
import java.util.Objects;


public class PageManageUserAppointmentsGuiController2 implements Observer {
    private CheckRequestAppController controller = new CheckRequestAppController();
    private String appointmentsItemFxml = "/view/interface2/AppointmentsItemUser2.fxml";
    private SetterClass setterClass = new SetterClass();
    RequestAppointmentsBean2 requestAppointmentsBean2 = new RequestAppointmentsBean2();


    @FXML
    private ListView<Pane> listViewAppointments;
    @FXML
    private Button btnPending;
    @FXML
    private Button btnDeclined;
    @FXML
    private Button btnAccepted;

    private StatoRichieste state = StatoRichieste.PENDENTE;



    public void reload(){
        try{
            controller.manageRequestAppointments(this, Session.getInstance().getUser().getId(), Session.getInstance().getCredentials().getType().getRoleId());
        }catch (SystemException e ){
            ErrorDialog.getInstance().handleException(e);
        }
    }

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




    public void setAll(RequestAppointmentsBean rBean) throws EmptyInputException {
        setterClass.setRequestApp(this.requestAppointmentsBean2, rBean);
        controller.addAppointmentsToList(requestAppointmentsBean2);
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


    @Override
    public void update(Object ob) {
        if(ob instanceof RequestAppointmentsBean rBean){

            if(!matchState(rBean))  return;

            RequestAppointmentsBean2 requestAppointmentsBean1 = new RequestAppointmentsBean2();
            try{
                setterClass.setRequestApp(requestAppointmentsBean1,(RequestAppointmentsBean)ob );
                loadPane(requestAppointmentsBean1);
            }catch (IOException e ){
                ErrorDialog.getInstance().handleException(e);
            }

        }
    }

    private void loadPane(RequestAppointmentsBean2 rBean) throws IOException {
        AppointmentsItemUserGuiControllerSecondInterface itemController;
        Pane pane = null;
        FXMLLoader fxmlLoader = new FXMLLoader();
        pane = fxmlLoader.load(Objects.requireNonNull(getClass().getResource(appointmentsItemFxml).openStream()));
        itemController = fxmlLoader.getController();
        itemController.setAll(rBean);


        this.listViewAppointments.getItems().add(pane);
    }
}
