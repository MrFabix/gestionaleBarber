package com.example.barber.controller.guicontroller.interface2.item2;

import com.example.barber.utils.bean.IdBean;
import com.example.barber.utils.bean.interfaccia2.BarberBean2;
import com.example.barber.utils.exception.myexception.SystemException;
import com.example.barber.utils.switchpage.SwitchPage;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class BarberItemGuiController2 {

    @FXML
    private Label barberNameLabel;
    @FXML
    private Label barberCityLabel;
    @FXML
    private Label barberAddressLabel;
    @FXML
    private Button buttonBarber;
    private SwitchPage sp = new SwitchPage();

    @FXML
    private void showBarberDetails(ActionEvent event) throws SystemException {
        int id = (int) buttonBarber.getUserData();
        IdBean idBean = new IdBean(id);
        System.out.println("Stai chiamando il dettaglio del barbiere");
        sp.switchPageId("/view/interface2/BarberDetail2.fxml", event, idBean);
    }



    // Metodo per impostare i dettagli del barbiere
    public void setBarberDetails(BarberBean2 bean) {
        barberNameLabel.setText(bean.getName());
        barberCityLabel.setText(bean.getCity());
        barberAddressLabel.setText(bean.getAddress());
        buttonBarber.setUserData(bean.getId());
    }












}
