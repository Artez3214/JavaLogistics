package com.example.kursinis.fxControllers;

import com.example.kursinis.HelloApplication;
import com.example.kursinis.utils.DataBaseOperations;
import com.example.kursinis.utils.FxUtils;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ResourceBundle;

public class RegisterPage implements Initializable {

    @FXML
    private TextField name;
    @FXML
    private TextField phonenumber;
    @FXML
    private TextField email;
    @FXML
    private TextField birthday;
    @FXML
    private TextField username;
    @FXML
    private TextField password;
    @FXML
    private TextField company;
    @FXML
    private TextField healthensurance;
    @FXML
    private TextField driverlicence;

    @FXML
    private CheckBox isdrive;

    private boolean isDriver;

    @Override
    public void initialize(URL url, ResourceBundle resource)
    {
        healthensurance.setVisible(false);
        driverlicence.setVisible(false);
        isDriver = false;
    }
    public void validate(ActionEvent actionEvent) {

        try
        {
            Connection connection = DataBaseOperations.connectToDb();
            String insert = "INSERT INTO `user` (`userId`, `name`, `phoneNumber`, `emailAddress`, `birthDay`, `username`, `password`, `isRetired`, `salary`, `currency`) VALUES (NULL, ?, ?, ?, ?, ?, ?,0, 0,' ') ";
            PreparedStatement preparedStatement = connection.prepareStatement(insert);
            preparedStatement.setString(1, name.getText());
            preparedStatement.setString(2, phonenumber.getText());
            preparedStatement.setString(3, email.getText());
            preparedStatement.setString(4, birthday.getText());
            preparedStatement.setString(5, username.getText());
            preparedStatement.setString(6, password.getText());
            preparedStatement.executeUpdate();
            FxUtils.alertMessage(Alert.AlertType.ERROR,"Warning", "Sucessfully registered", "congratz on becoming part of our team");
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("login-page.fxml"));
            Parent root = fxmlLoader.load();
            Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }

    @FXML
    private void PersonIsNotADriver(ActionEvent actionEvent){
        if(isdrive.isSelected()) {
            company.setVisible(false);
            healthensurance.setVisible(true);
            driverlicence.setVisible(true);
            isDriver = true;
        }
        else
        {
            company.setVisible(true);
            healthensurance.setVisible(false);
            driverlicence.setVisible(false);
            isDriver = false;
        }


    }

}
