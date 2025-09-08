package com.example.barber.controller.guicontroller.interface1;

import com.example.barber.controller.appcontroller.BarberAppController;
import com.example.barber.controller.appcontroller.ServiceAppController;
import com.example.barber.utils.bean.PreFormBarberBean;
import com.example.barber.utils.bean.BarberBean;
import com.example.barber.utils.bean.IdBean;
import com.example.barber.utils.bean.ServiceBean;
import com.example.barber.utils.bean.interfaccia1.BarberBean1;
import com.example.barber.utils.exception.ErrorDialog;
import com.example.barber.utils.exception.myexception.EmailNotValidException;
import com.example.barber.utils.exception.myexception.EmptyInputException;
import com.example.barber.utils.exception.myexception.SystemException;
import com.example.barber.utils.exception.myexception.UsernameAlreadyTakenException;
import com.example.barber.utils.setterandgetter.SetterClass;
import com.example.barber.utils.scene.SwitchAndSetPage;
import com.example.barber.utils.scene.SwitchPage;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;

import java.util.ArrayList;
import java.util.List;

public class BarberDetailGuiController {


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
    @FXML
    private ListView<String> servicesList;
    @FXML
    private ListView<String> reviewsList;
    @FXML
    private Button bookButton;

    private SwitchPage switchPage = new SwitchPage();
    private SwitchAndSetPage switchPageAndSet = new SwitchAndSetPage();
    private List<ServiceBean> serviceBeanList = new ArrayList<>();
    private SetterClass setterClass = new SetterClass();

    public void setBarberDetails(IdBean id){
        // Chiamare l'AppController per ottenere i dettagli
        BarberBean1 barberBean1 = new BarberBean1();
        BarberBean barberBean = null;
        BarberAppController barberAppController = new BarberAppController();
        ServiceAppController serviceAppController = new ServiceAppController();

        // Ottieni i dettagli del barbiere
        try{
            barberBean = barberAppController.getBarberDetails(id);
            //Qui va sostituito
            setterClass.setBarber(barberBean, barberBean1);

        }catch (SystemException | UsernameAlreadyTakenException | EmptyInputException | EmailNotValidException e){
            ErrorDialog.getInstance().handleException(e);
        }
        if (barberBean1 != null) {
            barberName.setText(barberBean1.getName());
            barberAddress.setText(barberBean1.getAddress());
            barberPhone.setText(barberBean1.getPhone());
            description.setText(barberBean1.getDescription());
            bookButton.setUserData(barberBean1.getId());
            serviceBeanList = serviceAppController.getServiceBarber(id);
            for(ServiceBean s : serviceBeanList){
                servicesList.getItems().add(s.getNome_servizio());
            }
        } else {
            // Gestisci il caso in cui i dettagli non sono disponibili, magari non tutti i campi sono stati compilati
            barberName.setText("N/A");
            barberAddress.setText("N/A");
            barberPhone.setText("N/A");
            barberHours.setText("N/A");
            description.setText("Nessuna descrizione disponibile");
            servicesList.getItems().add("Dettagli non disponibili.");
        }
    }

    // Metodo per tornare alla lista dei barbieri
    public void backToBarberList(ActionEvent event) {
        try {
            switchPage.replaceScene(event, "/view/interface1/homePageClient1.fxml");
        } catch (SystemException e) {
            ErrorDialog.getInstance().handleException(e);
        }
    }



    // Metodo per prenotare un appuntamento
    public void bookAppointment(ActionEvent event){
        List<String> appList = new ArrayList<>();
        PreFormBarberBean preFormBarberBean = new PreFormBarberBean();
        preFormBarberBean.setIdBarber((int)bookButton.getUserData());
        preFormBarberBean.setBarberName(barberName.getText());
        preFormBarberBean.setBarberAddress(barberAddress.getText());
        for(String s : servicesList.getItems()){
            appList.add(s);
        }
        preFormBarberBean.setServiceList(appList);
        try{
            switchPageAndSet.switchAndSetBookingForm(event, "/view/interface1/BookingForm1.fxml", preFormBarberBean);
        } catch (SystemException e) {
            ErrorDialog.getInstance().handleException(e);
        }
    }
}






