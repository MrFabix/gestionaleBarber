package com.example.barber.utils.graphicnavbar;


import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;

public class GraphicNavBar {

    public void setGraphicNAvbar(VBox vBox, String userName){
        StackPane pane = createPane(userName);
        vBox.setSpacing(15);
        vBox.setAlignment( Pos.TOP_CENTER);
        vBox.getChildren().add(pane);
    }

    public void setGraphicNAvbar(HBox vBox, String userName){
        StackPane pane = createPane(userName);
        vBox.setSpacing(15);
        vBox.setAlignment( Pos.TOP_CENTER);
        vBox.getChildren().add(pane);
    }


    private StackPane createPane(String userName){
        Label label1 = new Label();
        StackPane pane = new StackPane();
        label1.setText("Benvenuto "+ userName);
        Color customColor = Color.web("#dc0f3f");
        pane.setPrefWidth(207.0);
        pane.setPrefHeight(74.0);
        pane.setBackground(new Background(new BackgroundFill(customColor, CornerRadii.EMPTY, Insets.EMPTY)));
        StackPane.setAlignment(label1, Pos.CENTER);
        pane.getChildren().add(label1);
        return pane;
    }
}
