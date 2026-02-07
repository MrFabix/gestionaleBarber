package com.example.barber.controller.guicontroller.interface2;

import com.example.barber.controller.appcontroller.RecensioneAppController;
import com.example.barber.utils.bean.IdBean;
import com.example.barber.utils.bean.RecensioneBean;
import com.example.barber.utils.exception.ErrorDialog;
import com.example.barber.utils.exception.myexception.SystemException;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.util.List;
import java.util.Optional;

public class HomePageModeratorGuiController2 {

    @FXML
    private TextField searchReportedMessage;

    @FXML
    private ListView<RecensioneBean> reportedMessagesListView;

    @FXML
    private TextArea messageDetails;

    @FXML
    private Button approveButton;

    @FXML
    private Button deleteButton;

    private ObservableList<RecensioneBean> reportedReviews;
    private final RecensioneAppController recensioneAppController = new RecensioneAppController();

    @FXML
    private void initialize() {
        reportedReviews = FXCollections.observableArrayList();
        
        setupListView();
        loadReportedReviews();
        setupSearchFilter();
        setupButtons();
    }

    private void setupListView() {
        reportedMessagesListView.setCellFactory(param -> new ListCell<>() {
            @Override
            protected void updateItem(RecensioneBean item, boolean empty) {
                super.updateItem(item, empty);
                if (empty || item == null) {
                    setText(null);
                    setStyle("");
                } else {
                    setText(String.format("⭐ %d - %s (Cliente: %s | Barbiere: %s)",
                            item.getVoto(),
                            item.getTesto().length() > 50 ? item.getTesto().substring(0, 47) + "..." : item.getTesto(),
                            item.getNomeCliente(),
                            item.getNomeBarbiere()));
                    setStyle("-fx-text-fill: white; -fx-background-color: transparent;");
                }
            }
        });

        reportedMessagesListView.getSelectionModel().selectedItemProperty().addListener(
                (observable, oldValue, newValue) -> showReviewDetails(newValue));
    }

    private void loadReportedReviews() {
        try {
            List<RecensioneBean> reviews = recensioneAppController.getReportedRecensioni();
            reportedReviews.setAll(reviews);
            reportedMessagesListView.setItems(reportedReviews);
        } catch (SystemException e) {
            ErrorDialog.getInstance().handleException(e);
        }
    }

    private void showReviewDetails(RecensioneBean review) {
        if (review != null) {
            String details = """
                    ID Recensione: %d
                    Cliente: %s
                    Barbiere: %s
                    Voto: %d stelle
                    Data: %s
                    ID Appuntamento: %d
                    
                    Testo della recensione:
                    %s""".formatted(
                    review.getIdRecensione(),
                    review.getNomeCliente(),
                    review.getNomeBarbiere(),
                    review.getVoto(),
                    review.getCreatedAt(),
                    review.getIdAppuntamento(),
                    review.getTesto()
            );
            messageDetails.setText(details);
            approveButton.setDisable(false);
            deleteButton.setDisable(false);
        } else {
            messageDetails.clear();
            approveButton.setDisable(true);
            deleteButton.setDisable(true);
        }
    }

    private void setupSearchFilter() {
        searchReportedMessage.textProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue == null || newValue.isEmpty()) {
                reportedMessagesListView.setItems(reportedReviews);
            } else {
                ObservableList<RecensioneBean> filtered = reportedReviews.filtered(review ->
                        review.getTesto().toLowerCase().contains(newValue.toLowerCase()) ||
                        review.getNomeCliente().toLowerCase().contains(newValue.toLowerCase()) ||
                        review.getNomeBarbiere().toLowerCase().contains(newValue.toLowerCase())
                );
                reportedMessagesListView.setItems(filtered);
            }
        });
    }

    private void setupButtons() {
        approveButton.setDisable(true);
        deleteButton.setDisable(true);

        approveButton.setOnAction(event -> handleApprove());
        deleteButton.setOnAction(event -> handleDelete());
    }

    @FXML
    private void handleApprove() {
        RecensioneBean selectedReview = reportedMessagesListView.getSelectionModel().getSelectedItem();
        if (selectedReview != null) {
            Alert confirmAlert = new Alert(Alert.AlertType.CONFIRMATION);
            confirmAlert.setTitle("Conferma Approvazione");
            confirmAlert.setHeaderText("Approva recensione");
            confirmAlert.setContentText("Vuoi rimuovere la segnalazione da questa recensione?");

            Optional<ButtonType> result = confirmAlert.showAndWait();
            if (result.isPresent() && result.get() == ButtonType.OK) {
                try {
                    IdBean idBean = new IdBean();
                    idBean.setId(selectedReview.getIdRecensione());
                    recensioneAppController.approveRecensione(idBean);
                    reportedReviews.remove(selectedReview);
                    messageDetails.clear();
                    
                    Alert successAlert = new Alert(Alert.AlertType.INFORMATION);
                    successAlert.setTitle("Successo");
                    successAlert.setHeaderText(null);
                    successAlert.setContentText("Recensione approvata con successo!");
                    successAlert.showAndWait();
                } catch (SystemException e) {
                    ErrorDialog.getInstance().handleException(e);
                }
            }
        }
    }

    @FXML
    private void handleDelete() {
        RecensioneBean selectedReview = reportedMessagesListView.getSelectionModel().getSelectedItem();
        if (selectedReview != null) {
            Alert confirmAlert = new Alert(Alert.AlertType.CONFIRMATION);
            confirmAlert.setTitle("Conferma Eliminazione");
            confirmAlert.setHeaderText("Elimina recensione");
            confirmAlert.setContentText("Sei sicuro di voler eliminare definitivamente questa recensione? Questa azione non può essere annullata.");

            Optional<ButtonType> result = confirmAlert.showAndWait();
            if (result.isPresent() && result.get() == ButtonType.OK) {
                try {
                    IdBean idBean = new IdBean();
                    idBean.setId(selectedReview.getIdRecensione());
                    recensioneAppController.deleteRecensione(idBean);
                    reportedReviews.remove(selectedReview);
                    messageDetails.clear();
                    
                    Alert successAlert = new Alert(Alert.AlertType.INFORMATION);
                    successAlert.setTitle("Successo");
                    successAlert.setHeaderText(null);
                    successAlert.setContentText("Recensione eliminata con successo!");
                    successAlert.showAndWait();
                } catch (SystemException e) {
                    ErrorDialog.getInstance().handleException(e);
                }
            }
        }
    }
}
