package com.example.barber.utils.graphicnavbar;


import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;


public class GraphicNavBar {

    public void setGraphicNAvbar(VBox vBox, String userName){
        StackPane pane = createPane(userName, Color.web("#dc0f3f"));
        vBox.setSpacing(15);
        vBox.setAlignment( Pos.TOP_CENTER);
        vBox.getChildren().add(pane);
    }

    public void setGraphicNAvbar(AnchorPane paneAnchor, HBox hBox, String userName){
        StackPane pane = createPane(userName, Color.web("#10b981"));
        hBox.setSpacing(15);
        hBox.setAlignment( Pos.TOP_CENTER);
        hBox.getChildren().add(pane);
        hBox.prefWidthProperty().bind(paneAnchor.widthProperty());
    }


    private StackPane createPane(String userName, Color color) {
        Label label1 = new Label();
        StackPane pane = new StackPane();
        label1.setText("Benvenuto "+ userName);

        pane.setPrefWidth(207.0);
        pane.setPrefHeight(74.0);
        pane.setBackground(new Background(new BackgroundFill(color, CornerRadii.EMPTY, Insets.EMPTY)));
        StackPane.setAlignment(label1, Pos.CENTER);
        pane.getChildren().add(label1);
        return pane;
    }
}
