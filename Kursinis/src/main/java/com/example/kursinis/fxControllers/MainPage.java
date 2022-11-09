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
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.*;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MainPage implements Initializable {
    @FXML
    private TextField keyWordTextField;

    @FXML
    private TextField keyWordTextField2;

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
    @FXML
    private TableColumn<OrderTableParams, Integer> driverId;
    ObservableList<OrderTableParams> orderObservableList = FXCollections.observableArrayList();

    public void filterOrder(){

        FilteredList<OrderTableParams> filteredData = new FilteredList<>(orderObservableList, b -> true);

        keyWordTextField2.textProperty().addListener((observable, oldValue, newValue) ->{
            filteredData.setPredicate(destinationSearchModel -> {
                if(newValue.isEmpty() || newValue.isBlank() || newValue ==null){
                    return true;
                }
                String searchKeyword = newValue.toLowerCase();

                if(String.valueOf(destinationSearchModel.getOrdId()).toLowerCase().indexOf(searchKeyword) > -1){
                    return true;
                } else if(destinationSearchModel.getRout().toString().indexOf(searchKeyword) > -1){
                    return true;
                }
                else if(String.valueOf(destinationSearchModel.getCargoId()).toLowerCase().indexOf(searchKeyword) > -1){
                    return true;
                }
                else if(String.valueOf(destinationSearchModel.getDriverId()).toLowerCase().indexOf(searchKeyword) > -1) {
                    return true;
                }
                else if(String.valueOf(destinationSearchModel.getDesId()).toLowerCase().indexOf(searchKeyword) > -1) {
                    return true;
                } else
                    return false;
            });
        });

        SortedList<OrderTableParams> sortedData = new SortedList<>(filteredData);

        sortedData.comparatorProperty().bind(orderTableView.comparatorProperty());

        orderTableView.setItems(sortedData);
    }
    public void updateOrder(){
        DataBaseOperations connectNow = new DataBaseOperations();

        Connection connection = connectNow.connectToDb();

        String destinationViewQuery = "SELECT * FROM `order` WHERE 1";

        try{
            Statement statement = connection.createStatement();
            ResultSet queryOutput = statement.executeQuery(destinationViewQuery);

            while(queryOutput.next())
            {
                System.out.println();
                System.out.println();
                OrderTableParams orderTableParams = new OrderTableParams();
                orderTableParams.setOrdId(queryOutput.getInt("orderId"));
                orderTableParams.setRout(queryOutput.getString("route"));
                orderTableParams.setCargoId(queryOutput.getInt("cargoId"));
                orderTableParams.setDesId(queryOutput.getInt("destinationId"));
                orderTableParams.setDriverId(queryOutput.getInt("driverId"));
                orderObservableList.add(orderTableParams);
            }

            orderId.setCellValueFactory(new PropertyValueFactory<>("ordId"));
            route.setCellValueFactory(new PropertyValueFactory<>("rout"));
            cargoId.setCellValueFactory(new PropertyValueFactory<>("cargoId"));
            destinationId.setCellValueFactory(new PropertyValueFactory<>("desId"));
            driverId.setCellValueFactory(new PropertyValueFactory<>("driverId"));

            orderTableView.setItems(orderObservableList);
            filterOrder();

            DataBaseOperations.disconnectFromDb(connection,statement);
        }
        catch (SQLException e)
        {
            Logger.getLogger(MainPage.class.getName()).log(Level.SEVERE, null,e);
            e.printStackTrace();
        }
    }
    
    public void filterDestinationData(){


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

    public void updateDestinationData()
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
            filterDestinationData();

            DataBaseOperations.disconnectFromDb(connection,statement);

        }
        catch (SQLException e)
        {
            Logger.getLogger(MainPage.class.getName()).log(Level.SEVERE, null,e);
            e.printStackTrace();
        }

    }

    @Override
    public void initialize(URL url, ResourceBundle resource){
      updateDestinationData();
      updateOrder();
    }

    public void showDestinationInsertPage(boolean IsUpdating) throws IOException {
        DestinationTableParams destinationTableParams = destinationTableView.getSelectionModel().getSelectedItem();
        MainPage destinationpage = this;
        FXMLLoader fxmlLoader = new FXMLLoader(LoginPage.class.getResource("/DestinationData.fxml"));
        Parent parent = fxmlLoader.load();
        Scene scene = new Scene(parent);
        Stage stage = new Stage();
        DestinationData controller = fxmlLoader.getController();
        System.out.println(IsUpdating);
        if(IsUpdating)
        {
            controller.setData(destinationTableParams);
        }
        controller.setDataClass(destinationpage,IsUpdating);
        stage.initOwner((Stage) destinationTableView.getScene().getWindow());
        stage.initModality(Modality.WINDOW_MODAL);
        stage.setScene(scene);
        stage.showAndWait();
        updateDestinationData();

    }

    public void Inserted(ActionEvent actionEvent) throws IOException {
        showDestinationInsertPage(false);
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

        }
        catch (SQLException e)
        {
            Logger.getLogger(MainPage.class.getName()).log(Level.SEVERE, null,e);
            e.printStackTrace();
        }
    }



    public void Updating(ActionEvent actionEvent) throws IOException {
        showDestinationInsertPage(true);
    }

    public void click(ActionEvent actionEvent) {
    }
}
