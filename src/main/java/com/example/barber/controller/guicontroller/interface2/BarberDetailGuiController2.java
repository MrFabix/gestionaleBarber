package com.example.barber.controller.guicontroller.interface2;

import com.example.barber.controller.appcontroller.BarberAppController;
import com.example.barber.controller.appcontroller.ServiceAppController;
import com.example.barber.utils.bean.BarberBean;
import com.example.barber.utils.bean.IdBean;
import com.example.barber.utils.bean.PreFormBarberBean;
import com.example.barber.utils.bean.ServiceBean;
import com.example.barber.utils.switchPage.SwitchAndSetPage;
import com.example.barber.utils.bean.interfaccia2.BarberBean2;
import com.example.barber.utils.exception.ErrorDialog;
import com.example.barber.utils.exception.myexception.EmailNotValidException;
import com.example.barber.utils.exception.myexception.EmptyInputException;
import com.example.barber.utils.exception.myexception.SystemException;
import com.example.barber.utils.exception.myexception.UsernameAlreadyTakenException;
import com.example.barber.utils.setterandgetter.SetterClass;
import com.example.barber.utils.switchPage.SwitchPage;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;

import java.util.ArrayList;
import java.util.List;

public class BarberDetailGuiController2 {


    private SwitchPage sp = new SwitchPage();
    private SetterClass setterClass = new SetterClass();
    private List<ServiceBean> serviceBeanList = new ArrayList<>();
    private SwitchAndSetPage switchPageAndSet = new SwitchAndSetPage();


    @FXML
    public void book(ActionEvent event){
        List<String> appList = new ArrayList<>();
        PreFormBarberBean preFB = new PreFormBarberBean();
        preFB.setIdBarber((int)bookButton.getUserData());
        preFB.setBarberName(barberName.getText());
        preFB.setBarberAddress(barberAddress.getText());
        for(String s : servicesList.getItems()){
            appList.add(s);
        }
        preFB.setServiceList(appList);
        try{
            switchPageAndSet.switchAndSetBookingForm(event, "/view/interface2/BookingForm2.fxml", preFB);
        } catch (SystemException e) {
            ErrorDialog.getInstance().handleException(e);
        }
    }


    @FXML
    private ListView<String> servicesList;
    @FXML
    private ListView<String> reviewsList;
    @FXML
    private Button bookButton;
    @FXML
    private Label barberName;
    @FXML
    private Label barberAddress;
    @FXML
    private Label barberPhone;
    @FXML
    private Label barberHours;
    @FXML
    private TextArea description;

    public void setBarberDetails(IdBean id){
        BarberBean2 barberBean2 = new BarberBean2();
        BarberBean barberBean = null;
        BarberAppController barberAppController = new BarberAppController();
        ServiceAppController serviceAppController = new ServiceAppController();
        try{
            barberBean = barberAppController.getBarberDetails(id);
            //Qui va sostituito
            setterClass.setBarber(barberBean, barberBean2);

        }catch (SystemException | UsernameAlreadyTakenException | EmptyInputException | EmailNotValidException e){
            ErrorDialog.getInstance().handleException(e);
        }
        if(barberBean2 != null) {
            barberName.setText(barberBean2.getName());
            barberAddress.setText(barberBean2.getAddress());
            barberPhone.setText(barberBean2.getPhone());
            description.setText(barberBean2.getDescription());
            bookButton.setUserData(barberBean2.getId());
            serviceBeanList = serviceAppController.getServiceBarber(id);
            for(ServiceBean s : serviceBeanList){
                servicesList.getItems().add(s.getNome_servizio());
            }
        }else{
            throw new IllegalArgumentException("Errore nel caricamento dei dati");
        }
    }


    @FXML
    public void backToBarberList(ActionEvent event){
        try {
            sp.replaceScene(event, "/view/interface2/homePageClient2.fxml");
        } catch (SystemException e) {
            ErrorDialog.getInstance().handleException(e);
        }
    }






}
