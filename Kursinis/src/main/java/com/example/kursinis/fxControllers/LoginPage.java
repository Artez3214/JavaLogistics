package com.example.kursinis.fxControllers;

import com.example.kursinis.utils.DataBaseOperations;
import javafx.event.ActionEvent;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.fxml.FXML;

import java.sql.Connection;

public class LoginPage {
    @FXML
    public TextField username;
    @FXML
    public PasswordField password;

    public void validate(ActionEvent actionEvent) {

        Connection connection = DataBaseOperations.connectToDb();
    }

    public void register(ActionEvent actionEvent) {
    }
}
