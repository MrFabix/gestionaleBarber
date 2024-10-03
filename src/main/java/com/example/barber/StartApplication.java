package com.example.barber;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class StartApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(StartApplication.class.getResource("/interface1/login.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Barber");
        stage.setScene(scene);
        //implementare gestione degli eventi andrea ispw 00
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}