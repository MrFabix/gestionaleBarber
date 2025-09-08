package com.example.barber.utils.scene;
import com.example.barber.controller.guicontroller.interface1.BookingFormGuiController1;


import com.example.barber.controller.guicontroller.interface2.BookingFormGuiController2;
import com.example.barber.utils.bean.PreFormBarberBean;
import com.example.barber.utils.bean.RequestAppointmentsBean;
import com.example.barber.utils.exception.myexception.EmptyInputException;
import com.example.barber.utils.exception.myexception.SystemException;
import com.example.barber.utils.scene.initpage.BookingFormPageSetter;
import com.example.barber.utils.scene.initpage.HomePageClientSetter;
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
            if(loader.getController() instanceof BookingFormGuiController1 bookingFormGuiController1){
                bookingFormPageSetter.setter1(barberBean, loader.getController());
            }else if(loader.getController() instanceof BookingFormGuiController2 bookingFormGuiController2){
                bookingFormPageSetter.setter2(barberBean, loader.getController());
            }
            SwitchPage.showStage(event,root);

        }catch (IOException e){
            SystemException exception = new SystemException();
            exception.initCause(e);
            throw exception;
        }





    }

    public void switchAndSetHomePageClient(ActionEvent event, String fxml, RequestAppointmentsBean requestAppointmentsBean) throws SystemException, EmptyInputException {
        try{
            FXMLLoader loader = new FXMLLoader(SwitchAndSetPage.class.getResource(fxml));
            Parent root = loader.load();
            HomePageClientSetter homePageClientSetter = new HomePageClientSetter();
            if(loader.getController() instanceof BookingFormGuiController1 bookingFormGuiController1){
                homePageClientSetter.setter1(requestAppointmentsBean, loader.getController());
            }else if(loader.getController() instanceof BookingFormGuiController2 bookingFormGuiController2){
                homePageClientSetter.setter2(requestAppointmentsBean, loader.getController());
            }
            SwitchPage.showStage(event,root);

        }catch (IOException e){
            SystemException exception = new SystemException();
            exception.initCause(e);
            throw exception;
        }
    }

}
