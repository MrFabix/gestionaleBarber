package com.example.barber.utils.switchpage;


import com.example.barber.controller.appcontroller.BookingAppController;
import com.example.barber.utils.bean.PreFormBarberBean;
import com.example.barber.utils.bean.RequestAppointmentsBean;
import com.example.barber.utils.exception.myexception.SystemException;
import com.example.barber.utils.switchpage.initpage.BookingFormPageSetter;
import com.example.barber.utils.switchpage.initpage.HomePageClientSetter;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;

import java.io.IOException;
public class SwitchAndSetPage{
    public void switchAndSetBookingForm(ActionEvent event, String fxml, PreFormBarberBean barberBean) throws SystemException {
        try{
            FXMLLoader loader = new FXMLLoader(SwitchAndSetPage.class.getResource(fxml));
            Parent root = loader.load();
            BookingFormPageSetter bookingFormPageSetter = new BookingFormPageSetter();
            bookingFormPageSetter.setter(barberBean, loader.getController());
            SwitchPage.showStage(event,root);

        }catch (IOException e){
            SystemException exception = new SystemException();
            exception.initCause(e);
            throw exception;
        }





    }

    public void switchAndSetHomePageClient(ActionEvent event, String fxml, RequestAppointmentsBean requestAppointmentsBean) throws SystemException {
        System.out.println("Sei ne Switch and scene home page client");
        try{
            FXMLLoader loader = new FXMLLoader(SwitchAndSetPage.class.getResource(fxml));
            Parent root = loader.load();
            HomePageClientSetter homePageClientSetter = new HomePageClientSetter();
            homePageClientSetter.setter(requestAppointmentsBean, loader.getController());
            SwitchPage.showStage(event,root);

        }catch (IOException e){
            SystemException exception = new SystemException();
            exception.initCause(e);
            throw exception;
        }
    }

}
