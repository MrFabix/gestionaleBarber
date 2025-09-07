package com.example.barber.controller.guicontroller.interface1;

import com.example.barber.controller.appcontroller.BarberAppController;
import com.example.barber.controller.appcontroller.ServiceAppController;
import com.example.barber.utils.Session;
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
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import java.net.URL;
import java.net.UnknownServiceException;
import java.util.List;
import java.util.ResourceBundle;


public class ManageShopGuiController1 implements Initializable {

    private ServiceBean serviceBean = new ServiceBean();
    private BarberBean1 barberBean = new BarberBean1();

    private IdBean idBean = new IdBean(Session.getInstance().getBarber().getId());
    private ServiceAppController controller = new ServiceAppController();

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

    @FXML
    private void addServiceInVbox() {

        serviceBean.setId_barber(Session.getInstance().getBarber().getId());
        serviceBean.setNome_servizio(nomeServizio.getText());
        String price = costo.getText();

        double d = Double.parseDouble(price.trim().replace(',', '.'));
        serviceBean.setPrezzo(d);
        String name = nomeServizio.getText() == null ? "" : nomeServizio.getText().trim();


        if (name.isEmpty()) {
            new Alert(Alert.AlertType.WARNING, "Inserisci il nome del servizio.").showAndWait();
            return;
        }
        if (d == 0.0) {
            new Alert(Alert.AlertType.WARNING, "Inserisci il prezzo del servizio.").showAndWait();
            return;
        }

        try {
            if (d < 0) throw new NumberFormatException();
        } catch (NumberFormatException ex) {
            new Alert(Alert.AlertType.WARNING, "Prezzo non valido.").showAndWait();
            return;
        }

        buildItemVbox(name,price);
        new Alert(Alert.AlertType.WARNING, "Aggiunto un serivzio").showAndWait();
        try{
            controller.insertService(serviceBean);
        } catch (SystemException e) {
            ErrorDialog.getInstance().handleException(e);
        }



        // pulizia campi
        nomeServizio.clear();
        costo.clear();
        nomeServizio.requestFocus();
    }

    private void buildItemVbox(String name, String price){
        HBox row = new HBox(8);
        Label bullet = new Label("•");
        Label lblName = new Label(name);
        Label prezzo = new Label(price);
        Button remove = new Button("X");
        remove.setOnAction(e -> deleteService(row, controller, serviceBean));
        row.getChildren().addAll(bullet, lblName, prezzo, remove);
        listService.getChildren().add(row);
    }

    private void deleteService(HBox row, ServiceAppController controller, ServiceBean serviceBean){
        listService.getChildren().remove(row);
        try{
            controller.deleteService(serviceBean);
        } catch (SystemException e) {
            ErrorDialog.getInstance().handleException(e);
        }
    }

    @FXML
    public void upgradeOrarioLavoro(ActionEvent e){
        BarberAppController barberAppController = new BarberAppController();

        barberBean.setId(Session.getInstance().getBarber().getId());
        try{
            barberBean.setInizio(inizioOrario.getText());
            barberBean.setFine(fineOrario.getText());
            barberAppController.insertOrarioBarber(barberBean);
        }catch (SystemException | EmailNotValidException | IllegalArgumentException |EmptyInputException | UsernameAlreadyTakenException ex){
            ErrorDialog.getInstance().handleException(ex);
        }

        new Alert(Alert.AlertType.WARNING, "Modificato Orario").showAndWait();

    }
}


