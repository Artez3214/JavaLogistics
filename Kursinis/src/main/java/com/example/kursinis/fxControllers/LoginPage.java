package com.example.kursinis.fxControllers;

import com.example.kursinis.utils.DataBaseOperations;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.fxml.FXML;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class LoginPage {
    @FXML
    public TextField username;
    @FXML
    public PasswordField password;

    public void validate(ActionEvent actionEvent) {

        try
        {
            Connection connection = DataBaseOperations.connectToDb();
            String sql = "SELECT count(*) FROM DRIVER d WHERE d.username = '" + username.getText() + "' AND d.password = '" + password.getText() + "'";
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            while(rs.next())
            {
                if(rs.getInt(1) == 0)
                {
                    Alert alert = new Alert(Alert.AlertType.WARNING);
                    alert.setTitle("Warning");
                    alert.setHeaderText("there was an error");
                    alert.setContentText("No such user, please choose other credentials");

                    alert.showAndWait();
                }
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }


    }

    public void register(ActionEvent actionEvent) {
    }
}
