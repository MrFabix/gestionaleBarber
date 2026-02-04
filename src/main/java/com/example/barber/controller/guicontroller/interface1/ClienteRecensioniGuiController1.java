package com.example.barber.controller.guicontroller.interface1;

import com.example.barber.controller.appcontroller.ClienteRecensioneAppController;
import com.example.barber.utils.Session;
import com.example.barber.utils.bean.ClientBean;
import com.example.barber.utils.bean.IdBean;
import com.example.barber.utils.bean.RecensioneBean;
import com.example.barber.utils.bean.interfaccia1.ClientBean1;
import com.example.barber.utils.exception.ErrorDialog;
import com.example.barber.utils.exception.myexception.EmptyInputException;
import com.example.barber.utils.exception.myexception.InvalidDateException;
import com.example.barber.utils.exception.myexception.SystemException;
import com.example.barber.utils.scene.SwitchPage;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.Button;

import java.net.URL;
import java.util.ResourceBundle;

public class ClienteRecensioniGuiController1 implements Initializable {
    @FXML
    private TextArea textRecensione;
    @FXML
    private ComboBox<Integer> comboVoto;
    @FXML
    private Button annullaButton;
    private SwitchPage sp = new SwitchPage();
    private IdBean idBean;
    private ClientBean clientBean = new ClientBean1();


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        comboVoto.setItems(FXCollections.observableArrayList(1, 2, 3, 4, 5));
        comboVoto.getSelectionModel().selectFirst();
    }

    @FXML
    private void onInviaRecensione(ActionEvent event) {
        RecensioneBean recensioneBean = new RecensioneBean();
        clientBean = Session.getInstance().getUser();
        //raccolgo i dati
        recensioneBean.setIdAppuntamento(idBean.getId());
        recensioneBean.setTesto(textRecensione.getText());
        recensioneBean.setVoto(comboVoto.getValue());
        recensioneBean.setIdCliente(clientBean.getId());
        recensioneBean.setTesto(textRecensione.getText());
        try {
            //invio la recensione
            ClienteRecensioneAppController clienteRecensioneAppController = new ClienteRecensioneAppController();
            clienteRecensioneAppController.inviaRecensione(recensioneBean);
            //mostro messaggio di successo
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Recensione Inviata");
            alert.setHeaderText(null);
            alert.setContentText("La tua recensione è stata inviata con successo!");
            alert.showAndWait();
            //torno alla pagina precedente
            sp.replaceScene(event, "/view/interface1/HomePageClientAppointments1.fxml");
        } catch ( InvalidDateException | SystemException e) {
            ErrorDialog.getInstance().handleException(e);
        }


    }

    @FXML
    private void onAnnulla(ActionEvent event) {
        try {
            sp.replaceScene(event, "/view/interface1/HomePageClientAppointments1.fxml");
        } catch (SystemException e) {
            ErrorDialog.getInstance().handleException(e);
        }
    }

    public void setIdBean(IdBean id) {
        this.idBean = id;
    }
}

