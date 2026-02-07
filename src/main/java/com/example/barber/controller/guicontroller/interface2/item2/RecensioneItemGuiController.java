package com.example.barber.controller.guicontroller.interface2.item2;

import com.example.barber.controller.appcontroller.RecensioneAppController;
import com.example.barber.utils.bean.IdBean;
import com.example.barber.utils.bean.RecensioneBean;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

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
    private Button reportReviewButton;



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
        reportReviewButton.setId(String.valueOf(bean.getIdRecensione()));
        reportReviewButton.setVisible(true);
        
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
        String idRecensione = reportReviewButton.getId();
        IdBean idBean = new IdBean(Integer.parseInt(idRecensione));
        RecensioneAppController controller = new RecensioneAppController();
        controller.reportRecensione(idBean);
        reportReviewButton.setDisable(true);
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Recensione segnalata");
        alert.setHeaderText(null);
        alert.setContentText("La recensione è stata segnalata con successo.");
        alert.showAndWait();
    }
}
