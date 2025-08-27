module com.example.barber {
    requires org.controlsfx.controls;
    requires org.kordamp.bootstrapfx.core;
    requires java.sql;
    requires java.naming;
    requires MaterialFX;
    requires javafx.fxml;
    requires jdk.dynalink;
    requires com.opencsv;


    opens com.example.barber to javafx.fxml;
    exports com.example.barber;
    exports com.example.barber.controller.guicontroller.interface1;
    exports com.example.barber.controller.guicontroller.interface2;
    exports com.example.barber.controller.guicontroller.interface1.item;
    opens com.example.barber.controller.guicontroller.interface1.item to javafx.fxml;
    opens com.example.barber.controller.guicontroller.interface1 to javafx.fxml;
    opens com.example.barber.controller.guicontroller.interface2 to javafx.fxml;
}