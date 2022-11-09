package com.example.kursinis.fxControllers;

import com.example.kursinis.utils.DataBaseOperations;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import com.example.kursinis.model.Destination;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.*;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
public class OrderPage implements Initializable {
    public TextField keyWordTextField1;
    @FXML
    private TableView<OrderTableParams> orderTableView;

    @FXML
    private TableColumn<OrderTableParams, Integer> orderIdd;

    @FXML
    private TableColumn<OrderTableParams, String> routee;

    @FXML
    private TableColumn<OrderTableParams, Integer> cargoIdd;

    @FXML
    private TableColumn<OrderTableParams, Integer> destinationIdd;
    @FXML
    private TableColumn<OrderTableParams, Integer> driverIdd;

    ObservableList<OrderTableParams> orderObservableList = FXCollections.observableArrayList();

    @Override
    public void initialize(URL url, ResourceBundle resource){
        DataBaseOperations connectNow = new DataBaseOperations();

        Connection connection = connectNow.connectToDb();

        String destinationViewQuery = "SELECT 'orderId','route','cargoId'','destinationId','driverId' FROM order";

        try{
            Statement statement = connection.createStatement();
            ResultSet queryOutput = statement.executeQuery(destinationViewQuery);

            while(queryOutput.next())
            {
                OrderTableParams orderTableParams = new OrderTableParams();
                orderTableParams.setOrdId(queryOutput.getInt("id"));
                orderTableParams.setRout(queryOutput.getString("route"));
                orderTableParams.setCargoId(queryOutput.getInt(0));
                orderTableParams.setDesId(queryOutput.getInt("desId"));
                orderTableParams.setDriverId(queryOutput.getInt("driverId"));
                orderObservableList.add(orderTableParams);
            }

            orderIdd.setCellValueFactory(new PropertyValueFactory<>("orderId"));
            routee.setCellValueFactory(new PropertyValueFactory<>("route"));
            cargoIdd.setCellValueFactory(new PropertyValueFactory<>("cargoId"));
            destinationIdd.setCellValueFactory(new PropertyValueFactory<>("destinationId"));
            driverIdd.setCellValueFactory(new PropertyValueFactory<>("driverId"));

            orderTableView.setItems(orderObservableList);
          //  filterData();

            DataBaseOperations.disconnectFromDb(connection,statement);
        }
        catch (SQLException e)
        {
            Logger.getLogger(DestinationPage.class.getName()).log(Level.SEVERE, null,e);
            e.printStackTrace();
        }

    }
}
