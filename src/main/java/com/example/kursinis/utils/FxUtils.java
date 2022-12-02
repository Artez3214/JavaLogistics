package com.example.kursinis.utils;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.stage.Stage;

import java.io.IOException;

public class FxUtils {
    private Stage stage;
    private Scene scene;
    private Parent root;
    public static void alertMessage(Alert.AlertType  alertType, String title, String headerText, String alertMsg)
    {

        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setHeaderText(headerText);
        alert.setContentText(alertMsg);

        alert.showAndWait();
    }

}
