package com.example.kursinis.fxControllers;

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
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ResourceBundle;

public class LoginPage {
    @FXML
    private AnchorPane loginpages;

    @FXML
    public TextField username;

    @FXML
    public PasswordField password;


    @FXML
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
                    Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("main-page.fxml"));
                    Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
                    Scene scene = new Scene(root);
                    stage.setScene(scene);
                    stage.show();
                }
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }



    @FXML
    public void register(ActionEvent actionEvent) throws IOException {
        Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("register-page.fxml"));
        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}
