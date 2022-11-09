package com.example.kursinis.fxControllers;

import com.example.kursinis.model.Destination;
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

public class DestinationPage implements Initializable {
    public TextField keyWordTextField;
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
    
    public void filterData(){


        FilteredList<DestinationTableParams> filteredData = new FilteredList<>(destinationObservableList, b -> true);

        keyWordTextField.textProperty().addListener((observable, oldValue, newValue) ->{
            filteredData.setPredicate(destinationSearchModel -> {
                if(newValue.isEmpty() || newValue.isBlank() || newValue ==null){
                    return true;
                }
                String searchKeyword = newValue.toLowerCase();

                if(destinationSearchModel.getStartDest().toLowerCase().indexOf(searchKeyword) > -1){
                    return true;
                } else if(destinationSearchModel.getStartDat().toString().indexOf(searchKeyword) > -1){
                        return true;
                    }
                    else if(destinationSearchModel.getEndDat().toString().indexOf(searchKeyword) > -1){
                        return true;
                    }
                else if(destinationSearchModel.getEndDest().toLowerCase().indexOf(searchKeyword) > -1) {
                    return true;
                } else
                    return false;
            });
        });

        SortedList<DestinationTableParams> sortedData = new SortedList<>(filteredData);

        sortedData.comparatorProperty().bind(destinationTableView.comparatorProperty());

        destinationTableView.setItems(sortedData);
    }

    public void updateData()
    {
        destinationObservableList.clear();
        DataBaseOperations connectNow = new DataBaseOperations();

        Connection connection = connectNow.connectToDb();

        String destinationViewQuery = "SELECT id,PickUpDestinationAddress,PickUpDestinationDate,FinalDestinationDate,FinalDestinationAddress FROM destination";

        try{
            Statement statement = connection.createStatement();
            ResultSet queryOutput = statement.executeQuery(destinationViewQuery);

            while(queryOutput.next())
            {
                DestinationTableParams destinationTableParams = new DestinationTableParams();
                destinationTableParams.setColId(queryOutput.getInt("id"));
                destinationTableParams.setStartDest(queryOutput.getString("PickUpDestinationAddress"));
                destinationTableParams.setEndDest(queryOutput.getString("PickUpDestinationDate"));
                destinationTableParams.setEndDat(queryOutput.getString("FinalDestinationDate"));
                destinationTableParams.setStartDat(queryOutput.getString("FinalDestinationAddress"));

                destinationObservableList.add(destinationTableParams);
            }


            desId.setCellValueFactory(new PropertyValueFactory<>("colId"));
            pickupDestinationAddr.setCellValueFactory(new PropertyValueFactory<>("startDest"));
            finalDestinationAddr.setCellValueFactory(new PropertyValueFactory<>("endDest"));
            pickupDestinationDt.setCellValueFactory(new PropertyValueFactory<>("startDat"));
            finalDestinationDt.setCellValueFactory(new PropertyValueFactory<>("endDat"));

            destinationTableView.setItems(destinationObservableList);
            filterData();

            DataBaseOperations.disconnectFromDb(connection,statement);
        }
        catch (SQLException e)
        {
            Logger.getLogger(DestinationPage.class.getName()).log(Level.SEVERE, null,e);
            e.printStackTrace();
        }

    }

    @Override
    public void initialize(URL url, ResourceBundle resource){
      updateData();
    }

    public void showInsertPage(boolean IsUpdating) throws IOException {
        DestinationTableParams destinationTableParams = destinationTableView.getSelectionModel().getSelectedItem();
        DestinationPage destinationpage = this;
        FXMLLoader fxmlLoader = new FXMLLoader(LoginPage.class.getResource("/DestinationData.fxml"));
        Parent parent = fxmlLoader.load();
        DestinationData destinationData = fxmlLoader.getController();
        Scene scene = new Scene(parent);
        Stage stage = new Stage();
        DestinationData controller = fxmlLoader.getController();
        if(IsUpdating)
        {
            controller.setData(destinationTableParams);
        }
        controller.setDataClass(destinationpage);
        stage.initOwner((Stage) destinationTableView.getScene().getWindow());
        stage.initModality(Modality.WINDOW_MODAL);
        stage.setScene(scene);
        stage.showAndWait();
        updateData();

    }

    public void Inserted(ActionEvent actionEvent) throws IOException {
        updateData();
        showInsertPage(false);
    }


    public void Deleted(ActionEvent actionEvent) {

        DestinationTableParams destinationTableParams = destinationTableView.getSelectionModel().getSelectedItem();
        try{
            Connection connection = DataBaseOperations.connectToDb();
            String destinationDeleteQuery = "DELETE FROM destination WHERE id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(destinationDeleteQuery);
            int Id  = destinationTableParams.getColId();
            preparedStatement.setString(1, Integer.toString(Id));
            preparedStatement.executeUpdate();
            destinationObservableList.remove(destinationTableParams);
            updateData();

        }
        catch (SQLException e)
        {
            Logger.getLogger(DestinationPage.class.getName()).log(Level.SEVERE, null,e);
            e.printStackTrace();
        }
    }



    public void Updating(ActionEvent actionEvent) throws IOException {
        showInsertPage(true);
    }
}
