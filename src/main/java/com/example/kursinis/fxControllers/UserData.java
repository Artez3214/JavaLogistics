package com.example.kursinis.fxControllers;

import com.example.kursinis.utils.DataBaseOperations;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class UserData {
    boolean IsUpdate;
    private int usrId;
    private MainPage userPagee;
    @FXML
    private TextField name;

    public void setUsrId(int usrId) {
        this.usrId = usrId;
    }

    public void confirmUser(ActionEvent actionEvent) {

        DataBaseOperations connectNow = new DataBaseOperations();

        Connection connection = connectNow.connectToDb();

        String Query = "  UPDATE user SET name = ? WHERE userId = ?";
        String QueryInsert = " INSERT INTO `user` (`userId`, `name`, `phoneNumber`, `emailAddress`, `birthDay`, `username`, `password`, `isRetired`, `salary`, `currency`) VALUES  (NULL, ?,0,' ',' ',' ',' ',0,0,' ')";

        try{


            if (!IsUpdate) {

                PreparedStatement preparedStatement2 = connection.prepareStatement(QueryInsert);
                preparedStatement2.setString(1, name.getText());
                preparedStatement2.executeUpdate();
            }
            else{
                PreparedStatement preparedStatement = connection.prepareStatement(Query);
                preparedStatement.setString(1, name.getText());
                preparedStatement.setInt(2, usrId);

                preparedStatement.executeUpdate();

            }
        }
        catch (SQLException e)
        {
            Logger.getLogger(MainPage.class.getName()).log(Level.SEVERE, null,e);
            e.printStackTrace();
        }
        userPagee.updateUser();
    }

    public void cancel(ActionEvent actionEvent) throws IOException {
        Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("main-page.fxml"));

        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();

        stage.close();
    }
    public void setUserData(UserTableParams userTableParams) {
        name.setText(userTableParams.getNames());
        setUsrId(userTableParams.getuId());
    }

    public void setDataClass(MainPage userPage, boolean isUpdating) {
        userPagee = userPage;
        IsUpdate = isUpdating;
    }
}
