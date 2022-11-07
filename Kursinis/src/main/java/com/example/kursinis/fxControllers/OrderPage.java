package com.example.kursinis.fxControllers;

import com.example.kursinis.utils.DataBaseOperations;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

public class OrderPage implements Initializable {
    public TextField keyWordTextField1;
    @FXML
    private TableView<OrderTableParams> orderTableView;

    @FXML
    private TableColumn<OrderTableParams, Integer> orderId;

    @FXML
    private TableColumn<OrderTableParams, String> route;

    @FXML
    private TableColumn<OrderTableParams, Integer> cargoId;

    @FXML
    private TableColumn<OrderTableParams, Integer> destinationId;

    ObservableList<OrderTableParams> orderObservableList = FXCollections.observableArrayList();

    @Override
    public void initialize(URL url, ResourceBundle resource){
        DataBaseOperations connectNow = new DataBaseOperations();

        Connection connection = connectNow.connectToDb();

        String destinationViewQuery = "SELECT orderId, route  FROM order";

        try{
            Statement statement = connection.createStatement();
            ResultSet queryOutput = statement.executeQuery(destinationViewQuery);

            while(queryOutput.next())
            {
                OrderTableParams orderTableParams = new OrderTableParams();
                orderTableParams.setOrdId(queryOutput.getInt("id"));
                orderTableParams.setRout(queryOutput.getString("route"));
                orderTableParams.setCargoId(queryOutput.getInt(0));
                orderTableParams.setDesId(queryOutput.getInt(0));

                orderObservableList.add(orderTableParams);
            }


            orderId.setCellValueFactory(new PropertyValueFactory<>("ordId"));
            route.setCellValueFactory(new PropertyValueFactory<>("startDest"));
            cargoId.setCellValueFactory(new PropertyValueFactory<>("endDest"));
            destinationId.setCellValueFactory(new PropertyValueFactory<>("startDat"));


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
