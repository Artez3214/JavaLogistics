package com.example.kursinis.fxControllers;

import com.example.kursinis.HelloApplication;
import com.example.kursinis.utils.DataBaseOperations;
import com.example.kursinis.utils.FxUtils;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.fxml.FXML;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
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
            String sql = "SELECT count(*) FROM USER u WHERE u.username = ? AND u.password = ?";
           // Statement statement = connection.createStatement();
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, username.getText());
            preparedStatement.setString(2, password.getText());
            ResultSet rs = preparedStatement.executeQuery();
            while(rs.next())
            {
                if(rs.getInt(1) == 0)
                {
                    FxUtils.alertMessage(Alert.AlertType.ERROR,"Error", "Database error", "There is no such user");
                }
                else {
                    openMainWindow();
                }
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }


    }

    private void openMainWindow() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(LoginPage.class.getResource("com.example.kursinis.main-page.fxml"));
        Parent parent = fxmlLoader.load();
        MainPage mainPage = fxmlLoader.getController();
        mainPage.setData();

        Scene scene = new Scene(parent);
        Stage stage = (Stage) username.getScene().getWindow();
        stage.setTitle("kursinis");
        stage.setScene(scene);
        stage.show();
    }

    public void register(ActionEvent actionEvent) {
    }
}
