module com.example.barber {
    requires javafx.controls;
    requires javafx.fxml;
    requires org.controlsfx.controls;
    requires org.kordamp.bootstrapfx.core;
    requires java.sql;
    requires java.desktop;


    opens com.example.barber to javafx.fxml;
    exports com.example.barber;
    exports com.example.barber.controller.guicontroller.interface1;
    opens com.example.barber.controller.guicontroller.interface1 to javafx.fxml;
}