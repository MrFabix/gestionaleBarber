package com.example.barber.controller.guicontroller.interface1;

import io.github.palexdev.materialfx.controls.MFXButton;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;

import java.net.URL;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class ClienteRecensioniGuiController1 implements Initializable {

    // LISTA (stringhe pronte)
    @FXML private ListView<String> recensioniListView;

    // DETTAGLIO (aggiungi queste label nel tuo FXML)
    @FXML private Label lblDettaglioServizio;
    @FXML private Label lblDettaglioRating;
    @FXML private Label lblDettaglioData;
    @FXML private Label lblDettaglioCommento;

    // BOTTONI (aggiungili nel tuo FXML)
    @FXML private MFXButton eliminaRecensioneButton;
    @FXML private MFXButton indietroButton;

    // Se nel tuo FXML c’è ancora questo bottone, lo usiamo come "indietro" o lo rimuovi
    @FXML private MFXButton aggiungiRecensioneButton;

    private final DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");

    // Mantengo anche la lista “vera” per poter eliminare/mostrare dettagli corretti
    private final ObservableList<Review> myReviews = FXCollections.observableArrayList();

    // Model minimo
    private static class Review {
        final String servizio;      // es. "Taglio", "Barba", ...
        final int rating;           // 1..5
        final String commento;
        final LocalDateTime createdAt;

        Review(String servizio, int rating, String commento, LocalDateTime createdAt) {
            this.servizio = servizio;
            this.rating = rating;
            this.commento = commento;
            this.createdAt = createdAt;
        }

        String toListString(DateTimeFormatter dtf) {
            String shortComment = commento == null ? "" : commento.trim();
            if (shortComment.length() > 50) shortComment = shortComment.substring(0, 50) + "...";
            return "★".repeat(Math.max(0, rating)) + "  " + servizio + "  •  " + createdAt.format(dtf) + "\n" + shortComment;
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        System.out.println("ClienteRecensioniGuiController1 initialized");

        // Qui poi metterai: loadMyReviewsFromDB(idClienteLoggato)
        seedDemoMyReviews();

        renderList();

        recensioniListView.getSelectionModel().selectedIndexProperty().addListener((obs, ov, nv) -> {
            int idx = nv == null ? -1 : nv.intValue();
            showDetail(idx);
        });

        // seleziona la prima se presente
        if (!myReviews.isEmpty()) {
            recensioniListView.getSelectionModel().select(0);
            showDetail(0);
        } else {
            clearDetail();
        }
    }

    private void seedDemoMyReviews() {
        myReviews.clear();
        myReviews.addAll(
                new Review("Taglio", 5, "Ottimo lavoro, come sempre.", LocalDateTime.now().minusDays(3)),
                new Review("Barba", 4, "Molto bene, solo un po' di attesa.", LocalDateTime.now().minusDays(10)),
                new Review("Shampoo + Piega", 3, "Ok, migliorabile.", LocalDateTime.now().minusDays(20))
        );
    }

    private void renderList() {
        List<String> rows = new ArrayList<>();
        for (Review r : myReviews) rows.add(r.toListString(dtf));
        recensioniListView.setItems(FXCollections.observableArrayList(rows));
    }

    private void showDetail(int index) {
        if (index < 0 || index >= myReviews.size()) {
            clearDetail();
            return;
        }
        Review r = myReviews.get(index);

        if (lblDettaglioServizio != null) lblDettaglioServizio.setText(r.servizio);
        if (lblDettaglioRating != null) lblDettaglioRating.setText(String.valueOf(r.rating));
        if (lblDettaglioData != null) lblDettaglioData.setText(r.createdAt.format(dtf));
        if (lblDettaglioCommento != null) lblDettaglioCommento.setText(r.commento);
    }

    private void clearDetail() {
        if (lblDettaglioServizio != null) lblDettaglioServizio.setText("-");
        if (lblDettaglioRating != null) lblDettaglioRating.setText("-");
        if (lblDettaglioData != null) lblDettaglioData.setText("-");
        if (lblDettaglioCommento != null) lblDettaglioCommento.setText("-");
    }

    @FXML
    private void onEliminaRecensione(ActionEvent event) {
        int idx = recensioniListView.getSelectionModel().getSelectedIndex();
        if (idx < 0 || idx >= myReviews.size()) {
            alertWarn("Selezione mancante", "Seleziona una recensione da eliminare.");
            return;
        }

        // Qui: chiamata al DB per eliminare
        myReviews.remove(idx);

        renderList();

        if (myReviews.isEmpty()) {
            clearDetail();
        } else {
            int newIdx = Math.min(idx, myReviews.size() - 1);
            recensioniListView.getSelectionModel().select(newIdx);
            showDetail(newIdx);
        }

        alertInfo("Eliminata", "Recensione eliminata correttamente (demo).");
    }

    @FXML
    private void onIndietro(ActionEvent event) {
        // Hook: cambia scena / torna indietro
        alertInfo("Indietro", "Hook pronto: qui puoi tornare alla schermata precedente.");
    }

    // Se nel tuo FXML c’è ancora “aggiungiRecensioneButton”
    // lo riconverto a “Indietro” per non spaccare l’injection.
    @FXML
    private void onAggiungiRecensione(ActionEvent event) {
        onIndietro(event);
    }

    private void alertInfo(String title, String msg) {
        Alert a = new Alert(Alert.AlertType.INFORMATION);
        a.setTitle(title);
        a.setHeaderText(null);
        a.setContentText(msg);
        a.showAndWait();
    }

    private void alertWarn(String title, String msg) {
        Alert a = new Alert(Alert.AlertType.WARNING);
        a.setTitle(title);
        a.setHeaderText(null);
        a.setContentText(msg);
        a.showAndWait();
    }
}
