package com.example.kursinis.fxControllers;

import com.example.kursinis.utils.DataBaseOperations;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import lombok.ToString;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class OrderData {
    @FXML
    private TextField route;

    @FXML
    private TextField cargoid;

    @FXML
    private TextField destinationid;

    @FXML
    private TextField driverId;

    private int ordId;

    boolean IsUpdate;

    private MainPage orderPage;

    public int getOrdId() {
        return ordId;
    }

    public void setOrdId(int ordId) {
        this.ordId = ordId;
    }

    public TextField getRoute() {
        return route;
    }

    public void setRoute(TextField route) {
        this.route = route;
    }

    public TextField getCargoid() {
        return cargoid;
    }

    public void setCargoid(TextField cargoid) {
        this.cargoid = cargoid;
    }

    public TextField getDestinationid() {
        return destinationid;
    }

    public void setDestinationid(TextField destinationid) {
        this.destinationid = destinationid;
    }

    public TextField getDriverId() {
        return driverId;
    }

    public void setDriverId(TextField driverId) {
        this.driverId = driverId;
    }

    public void setOrderData(OrderTableParams orderTableParams) {
        route.setText(orderTableParams.getRout());
        cargoid.setText(Integer.toString(orderTableParams.getCargoId()));
        destinationid.setText(Integer.toString(orderTableParams.getDesId()));
        driverId.setText(Integer.toString(orderTableParams.getDriverId()));
        setOrdId(orderTableParams.getOrdId());
    }

    public void setDataClass(MainPage orderpage,boolean isUpdate) {

        orderPage = orderpage;

        IsUpdate = isUpdate;
    }
    public void confirmOrder(ActionEvent actionEvent) {

        DataBaseOperations connectNow = new DataBaseOperations();

        Connection connection = connectNow.connectToDb();


        String Query = "  UPDATE `order` SET `route` = ?, cargoid = ?, destinationid = ?, driverId = ? WHERE `order`.`orderId` = ?";
        String QueryInsert = "INSERT INTO `order` (`orderId`,`route`, `cargoId`, `destinationId`, `driverId`) VALUES (NULL, ?, ?, ?, ?)";

        try{


            if (!IsUpdate) {

                PreparedStatement preparedStatement2 = connection.prepareStatement(QueryInsert);
                preparedStatement2.setString(1, route.getText());
                preparedStatement2.setString(2, cargoid.getText());
                preparedStatement2.setString(3, destinationid.getText());
                preparedStatement2.setString(4, driverId.getText());


                preparedStatement2.executeUpdate();
                System.out.println(IsUpdate);
            }
            else{
                PreparedStatement preparedStatement = connection.prepareStatement(Query);
                preparedStatement.setString(1, route.getText());
                preparedStatement.setString(2, cargoid.getText());
                preparedStatement.setString(3, destinationid.getText());
                preparedStatement.setString(4, driverId.getText());
                preparedStatement.setInt(5, ordId);
                preparedStatement.executeUpdate();
                System.out.println(2);
            }
        }
        catch (SQLException e)
        {
            Logger.getLogger(MainPage.class.getName()).log(Level.SEVERE, null,e);
            e.printStackTrace();
        }
        orderPage.updateOrder();
    }

    public void cancel(ActionEvent actionEvent) throws IOException {

        Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("main-page.fxml"));

        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();

        stage.close();
    }


}
