module com.example.organizationapp {
    requires javafx.controls;
    requires javafx.fxml;
    requires org.controlsfx.controls;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;

    opens com.example.organizationapp to javafx.fxml;
    exports com.example.organizationapp;
    exports com.example.organizationapp.model;
    opens com.example.organizationapp.model to javafx.fxml;
}