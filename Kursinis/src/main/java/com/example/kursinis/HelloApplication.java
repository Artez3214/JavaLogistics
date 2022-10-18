package com.example.kursinis;

import com.example.kursinis.utils.FxUtils;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class HelloApplication extends Application {

    @Override
    public void start(Stage stage) throws IOException {

        Parent root = FXMLLoader.load(getClass().getResource("login-page.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }





    public static void main(String[] args) {
        launch();
    }
}