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

public class CargoData {

    private int cargId;

    boolean IsUpdate;

    private MainPage cargoPage;

    @FXML
    private TextField CargoType;

    @FXML
    private TextField OrderIdd;

    public int getCargId() {
        return cargId;
    }

    public void setCargId(int cargId) {
        this.cargId = cargId;
    }

    public void confirmCargo(ActionEvent actionEvent) {

        DataBaseOperations connectNow = new DataBaseOperations();

        Connection connection = connectNow.connectToDb();

        String Query = "  UPDATE cargo SET `type` = ?, orderId = ? WHERE `cargo`.`cargoId` = ?";
        String QueryInsert = " INSERT INTO `cargo` (`cargoId`, `type`, `orderId`) VALUES  (NULL, ?,?)";

        try{


            if (!IsUpdate) {

                PreparedStatement preparedStatement2 = connection.prepareStatement(QueryInsert);
                preparedStatement2.setString(1, CargoType.getText());
                preparedStatement2.setString(2, OrderIdd.getText());
                preparedStatement2.executeUpdate();
            }
            else{
                PreparedStatement preparedStatement = connection.prepareStatement(Query);
                preparedStatement.setString(1, CargoType.getText());
                preparedStatement.setString(2, OrderIdd.getText());
                preparedStatement.setString(3, Integer.toString(cargId));

                preparedStatement.executeUpdate();

            }
        }
        catch (SQLException e)
        {
            Logger.getLogger(MainPage.class.getName()).log(Level.SEVERE, null,e);
            e.printStackTrace();
        }
        cargoPage.updateCargo();
    }

    public void cancel(ActionEvent actionEvent) throws IOException {
        Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("main-page.fxml"));

        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();

        stage.close();
    }

    public void setCargoData(CargoTableParams cargoTableParams) {
        CargoType.setText(cargoTableParams.getType());
        setCargId(cargoTableParams.getCargId());
        OrderIdd.setText(Integer.toString(cargoTableParams.getOrderIdd()));

    }

    public void setDataClass(MainPage cargopage,boolean isUpdate) {

        cargoPage = cargopage;

        IsUpdate = isUpdate;
    }
}
