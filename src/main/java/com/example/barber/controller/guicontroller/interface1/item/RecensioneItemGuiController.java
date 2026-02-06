package com.example.barber.controller.guicontroller.interface1.item;

import com.example.barber.controller.appcontroller.RecensioneAppController;
import com.example.barber.utils.bean.IdBean;
import com.example.barber.utils.bean.RecensioneBean;
import com.example.barber.utils.exception.Trigger;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import io.github.palexdev.materialfx.controls.MFXButton;

public class RecensioneItemGuiController {
    @FXML
    public Label name;
    @FXML
    private Label reviewDateLabel;
    @FXML
    private Label reviewRatingLabel;
    @FXML
    private Label reviewTextLabel;
    @FXML
    private MFXButton reportReviewButton;



    public void setRecensioneDetails(RecensioneBean bean) {
        name.setText(bean.getNomeBarbiere());
        reviewDateLabel.setText(bean.getCreatedAt().toString());
        reviewRatingLabel.setText(String.valueOf(bean.getVoto()));
        reviewTextLabel.setText(bean.getTesto());
    }

    public void setRecensioneDetailsBarber(RecensioneBean bean) {
        name.setText(bean.getNomeCliente());
        reviewDateLabel.setText(bean.getCreatedAt().toString());
        reviewRatingLabel.setText(String.valueOf(bean.getVoto()));
        reviewTextLabel.setText(bean.getTesto());
        //setto identificativo del bottone per segnalare la recensione, in questo modo posso identificare quale recensione è stata segnalata
        reportReviewButton.setId(String.valueOf(bean.getIdRecensione()));
        reportReviewButton.setVisible(true);
        
        //se la recensione è già segnalata (report = 1), disabilito il bottone
        if (bean.getReport() == 1) {
            reportReviewButton.setDisable(true);
            reportReviewButton.setText("Segnalata");
        } else {
            reportReviewButton.setDisable(false);
            reportReviewButton.setText("Segnala");
        }
    }

    @FXML
    private void reportReview() {
        //raccolgo l'id della recensione dal bottone
        String idRecensione = reportReviewButton.getId();
        //incapsulo l'id in un idBean e triggero l'evento di segnalazione recensione
        IdBean idBean = new IdBean( Integer.parseInt(idRecensione));
        //mando al controller che si occuperà di segnalare la recensione
        RecensioneAppController controller = new RecensioneAppController();
        controller.reportRecensione(idBean);
        //disabilito il bottone dopo la segnalazione
        reportReviewButton.setDisable(true);
        //mostro un alert di conferma segnalazione
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Recensione segnalata");
        alert.setHeaderText(null);
        alert.setContentText("La recensione è stata segnalata con successo.");
        alert.showAndWait();


    }


}
