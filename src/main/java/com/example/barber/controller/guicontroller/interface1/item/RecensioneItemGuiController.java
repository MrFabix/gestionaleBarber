package com.example.barber.controller.guicontroller.interface1.item;

import com.example.barber.utils.bean.RecensioneBean;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import io.github.palexdev.materialfx.controls.MFXButton;

public class RecensioneItemGuiController {
    @FXML
    public Label barberName;
    @FXML
    private Label reviewDateLabel;
    @FXML
    private Label reviewRatingLabel;
    @FXML
    private Label reviewTextLabel;
    @FXML
    private MFXButton replyButton;

    public void setRecensioneDetails(RecensioneBean bean) {
        barberName.setText(bean.getNomeBarbiere());
        reviewDateLabel.setText(bean.getCreatedAt().toString());
        reviewRatingLabel.setText(String.valueOf(bean.getVoto()));
        reviewTextLabel.setText(bean.getTesto());
    }
}
