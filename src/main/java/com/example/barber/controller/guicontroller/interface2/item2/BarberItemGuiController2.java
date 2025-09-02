package com.example.barber.controller.guicontroller.interface2.item2;

import com.example.barber.utils.bean.BarberBean;
import com.example.barber.utils.bean.IdBean;
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
    private Button barberButton;
    private SwitchPage sp = new SwitchPage();

    @FXML
    private void showBarberDetails(ActionEvent event) throws SystemException {
        //Recupera l'ID dal pulsante tramite getUserData
        int id = (int) barberButton.getUserData();
        //creo il bean per passare l'id
        IdBean idBean = new IdBean(id);
        //cambio pagina passando l'id del barbiere
        sp.switchPageId("/view/Interface2/BarberDetail2.fxml", event, idBean);

    }



    // Metodo per impostare i dettagli del barbiere
    public void setBarberDetails(BarberBean bean) {
        barberNameLabel.setText(bean.getName());
        barberCityLabel.setText(bean.getCity());
        barberAddressLabel.setText(bean.getAddress());
        barberButton.setUserData(bean.getId());
    }












}
