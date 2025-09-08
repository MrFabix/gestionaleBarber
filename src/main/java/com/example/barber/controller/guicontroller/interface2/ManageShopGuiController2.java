package com.example.barber.controller.guicontroller.interface2;

import com.example.barber.controller.appcontroller.BarberAppController;
import com.example.barber.controller.appcontroller.ServiceAppController;
import com.example.barber.utils.Session;
import com.example.barber.utils.bean.IdBean;
import com.example.barber.utils.bean.ServiceBean;
import com.example.barber.utils.bean.interfaccia2.BarberBean2;
import com.example.barber.utils.exception.ErrorDialog;
import com.example.barber.utils.exception.myexception.EmailNotValidException;
import com.example.barber.utils.exception.myexception.EmptyInputException;
import com.example.barber.utils.exception.myexception.SystemException;
import com.example.barber.utils.exception.myexception.UsernameAlreadyTakenException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;


public class ManageShopGuiController2 implements Initializable {



    @FXML
    private TextField nomeServizio;
    @FXML
    private VBox listService;
    @FXML
    private TextField costo;
    @FXML
    private TextField inizioOrario;
    @FXML
    private TextField fineOrario;

    private ServiceBean serviceBean = new ServiceBean();
    private BarberBean2 barberBean = new BarberBean2();

    private IdBean idBean = new IdBean(Session.getInstance().getBarber().getId());
    private ServiceAppController controller = new ServiceAppController();
    @FXML
    private void aggiungiServizio() {

        String price = costo.getText();
        double priceDouble = Double.parseDouble(price.trim().replace(',', '.'));

        serviceBean.setPrezzo(priceDouble);
        String name = nomeServizio.getText() == null ? "" : nomeServizio.getText().trim();
        if (name.isEmpty()) {
            new Alert(Alert.AlertType.WARNING, "Inserisci il nome del servizio.").showAndWait();
            return;
        }
        if (priceDouble == 0.0) {
            new Alert(Alert.AlertType.WARNING, "Inserisci il prezzo del servizio.").showAndWait();
            return;
        }
        try {
            if (priceDouble < 0) throw new NumberFormatException();
        } catch (NumberFormatException ex) {
            new Alert(Alert.AlertType.WARNING, "Questo formato non va bene .").showAndWait();
            return;
        }
        buildItemVbox(name,price);
        new Alert(Alert.AlertType.WARNING, "Servizio aggiunto!").showAndWait();
        try{
            controller.insertService(serviceBean);
        } catch (SystemException e) {
            ErrorDialog.getInstance().handleException(e);
        }

        serviceBean.setId_barber(Session.getInstance().getBarber().getId());
        serviceBean.setNome_servizio(nomeServizio.getText());

        // pulizia campi
        nomeServizio.clear();
        costo.clear();
        nomeServizio.requestFocus();
    }


    @FXML
    public void upgradeOrarioLavoro(ActionEvent e){
        BarberAppController barberAppController = new BarberAppController();

        barberBean.setId(Session.getInstance().getBarber().getId());
        try{
            barberBean.setInizio(inizioOrario.getText());
            barberBean.setFine(fineOrario.getText());
            barberAppController.insertOrarioBarber(barberBean);
        }catch (SystemException | IllegalArgumentException |UsernameAlreadyTakenException | EmailNotValidException | EmptyInputException ex){
            ErrorDialog.getInstance().handleException(ex);
        }
        new Alert(Alert.AlertType.WARNING, "Orario modificato!").showAndWait();
    }




    private void deleteService(HBox row, ServiceAppController controller, ServiceBean serviceBean){
        listService.getChildren().remove(row);
        try{
            controller.deleteService(serviceBean);
        } catch (SystemException e) {
            ErrorDialog.getInstance().handleException(e);
        }
    }


    private void buildItemVbox(String name, String price){
        Label bullet = new Label("•");
        Label lblName = new Label(name);
        Label prezzo = new Label(price);
        HBox row = new HBox(8);
        Button remove = new Button("X");
        remove.setOnAction(e -> deleteService(row, controller, serviceBean));
        row.getChildren().addAll(bullet, lblName, prezzo, remove);
        listService.getChildren().add(row);
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        List<ServiceBean> serviceBeanList;
        serviceBeanList = controller.getServiceBarber(idBean);
        if(serviceBeanList == null){
            listService.getChildren().clear();
        }else {
            for (ServiceBean s : serviceBeanList) {
                String prezzo = String.format(java.util.Locale.US, "%.2f", s.getPrezzo());
                buildItemVbox(s.getNome_servizio(), prezzo);
            }
        }
    }


}


