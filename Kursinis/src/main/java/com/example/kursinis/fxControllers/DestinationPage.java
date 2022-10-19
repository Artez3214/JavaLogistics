package com.example.kursinis.fxControllers;

import com.example.kursinis.model.Destination;
import com.example.kursinis.utils.DataBaseOperations;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import com.example.kursinis.model.Destination;

import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DestinationPage implements Initializable {
    @FXML
    private TableView<DestinationTableParams> destinationTableView;

    @FXML
    private TableColumn<DestinationTableParams, Integer> desId;

    @FXML
    private TableColumn<DestinationTableParams, String> pickupDestinationAddr;

    @FXML
    private TableColumn<DestinationTableParams, String> finalDestinationAddr;

    @FXML
    private TableColumn<DestinationTableParams, String> pickupDestinationDt;

    @FXML
    private TableColumn<DestinationTableParams, String> finalDestinationDt;

    ObservableList<DestinationTableParams> destinationObservableList = FXCollections.observableArrayList();

    @Override
    public void initialize(URL url, ResourceBundle resource){

        System.out.println("hello there");
        DataBaseOperations connectNow = new DataBaseOperations();

        Connection connection = connectNow.connectToDb();

        String destinationViewQuery = "SELECT destinationId,PickUpDestinationAddress,PickUpDestinationDate,FinalDestinationDate,FinalDestinationAddress FROM destination";

        try{
            Statement statement = connection.createStatement();
            ResultSet queryOutput = statement.executeQuery(destinationViewQuery);

            while(queryOutput.next())
            {
                DestinationTableParams destinationTableParams = new DestinationTableParams();
                destinationTableParams.setColId(queryOutput.getInt("destinationId"));
                destinationTableParams.setStartDest(queryOutput.getString("PickUpDestinationAddress"));
                destinationTableParams.setEndDest(queryOutput.getString("PickUpDestinationDate"));
//                String  queryFinalDestinationDate = queryOutput.getString("FinalDestinationDate");
//                String  queryFinalDestinationAddress = queryOutput.getString("FinalDestinationAddress");



                //destinationObservableList.add(new Destination(queryDestinationId,queryPickUpDestinationAddress,queryPickUpDestinationDate,queryFinalDestinationDate,queryFinalDestinationAddress));
            destinationObservableList.add(destinationTableParams);
            }

            //  System.out.println(queryDestinationId + " " + queryPickUpDestinationAddress  + " " + queryPickUpDestinationDate  + " " + queryFinalDestinationDate + " " +  queryFinalDestinationAddress);
            System.out.println(destinationObservableList.toString());
            desId.setCellValueFactory(new PropertyValueFactory<>("colId"));
            pickupDestinationAddr.setCellValueFactory(new PropertyValueFactory<>("startDest"));
            finalDestinationAddr.setCellValueFactory(new PropertyValueFactory<>("endDest"));
//            pickupDestinationDt.setCellValueFactory(new PropertyValueFactory<>("pickupDestinationDat"));
//            finalDestinationDt.setCellValueFactory(new PropertyValueFactory<>("finalDestinationDat"));

            destinationTableView.setItems(destinationObservableList);

        }
        catch (SQLException e)
        {
            Logger.getLogger(DestinationPage.class.getName()).log(Level.SEVERE, null,e);
            e.printStackTrace();
        }

    }
}
