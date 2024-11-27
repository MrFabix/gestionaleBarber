package com.example.barber.controller.guicontroller.interface1;

import com.example.barber.utils.engineering.ListBarberEngineering;
import com.example.barber.utils.exception.ErrorDialog;
import com.example.barber.utils.observer.GenericBeanList;
import com.example.barber.utils.observer.Observer;
import javafx.fxml.Initializable;

import java.awt.event.ActionEvent;
import java.net.URL;
import java.util.ResourceBundle;

public class BookigListController implements Initializable, Observer {



    @Override
    public void initialize(URL location, ResourceBundle resources) {
        ListBarberEngineering listBarber;
        try {
            listBarber = new ListBarberEngineering();
            GenericBeanList list = new GenericBeanList(this);
           // list.addBookingToList(listBarber.getAllBarber());
        } catch (Exception e) {
            ErrorDialog.getInstance().handleException(e);
        }
    }

    @Override
    public void update(Object ob) {

    }
}
