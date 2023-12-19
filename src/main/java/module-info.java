module com.example.barber {
    requires javafx.controls;
    requires javafx.fxml;


    requires org.controlsfx.controls;
    requires org.kordamp.bootstrapfx.core;


    opens com.example.barber to javafx.fxml;
    exports com.example.barber;
    exports com.example.barber.controller;
    opens com.example.barber.controller to javafx.fxml;
}