module ucr.lab {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.base;

    opens domain to javafx.base; // Abre el paquete domain para javafx.base
    exports domain;
    opens ucr.lab to javafx.fxml;
    exports ucr.lab;
    exports controller;
    opens controller to javafx.fxml;
}