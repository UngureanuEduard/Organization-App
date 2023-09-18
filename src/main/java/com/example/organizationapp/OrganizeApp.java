package com.example.organizationapp;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import java.io.IOException;
public class OrganizeApp extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("organization.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        Image image =new Image("/images/Logo.png");
        stage.getIcons().add(image);
        stage.setTitle("Organization App");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}