package com.example.kursinis.fxControllers;

import com.example.kursinis.model.Cargo;
import com.example.kursinis.utils.DataBaseOperations;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
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
    private TextField keyWordTextField3;
    @FXML
    private TextField keyWordTextField4;
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
    @FXML
    private TableView<CargoTableParams> cargoTableView;

    @FXML
    private TableColumn<CargoTableParams, Integer> cargoIdd;
    @FXML
    private TableColumn<CargoTableParams, String> type;
    @FXML
    private TableColumn<CargoTableParams, Integer> orderIdd;

    ObservableList<CargoTableParams> cargoObservableList = FXCollections.observableArrayList();

    @FXML
    private TableView<UserTableParams> userTableView;
    @FXML
    private TableColumn<UserTableParams, Integer> userId;
    @FXML
    private TableColumn<UserTableParams, String> firstName;


    ObservableList<UserTableParams> userObservableList = FXCollections.observableArrayList();

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
        orderObservableList.clear();
        DataBaseOperations connectNow = new DataBaseOperations();

        Connection connection = connectNow.connectToDb();

        String orderViewQuery = "SELECT * FROM `order` WHERE 1";

        try{
            Statement statement = connection.createStatement();
            ResultSet queryOutput = statement.executeQuery(orderViewQuery);

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
    public void updateCargo(){
        cargoObservableList.clear();
        DataBaseOperations connectNow = new DataBaseOperations();

        Connection connection = connectNow.connectToDb();

        String cargoViewQuery = "SELECT cargoId,type,orderId FROM cargo";

        try{
            Statement statement = connection.createStatement();
            ResultSet queryOutput = statement.executeQuery(cargoViewQuery);

            while(queryOutput.next())
            {
                CargoTableParams cargoTableParams = new CargoTableParams();
                cargoTableParams.setCargId(queryOutput.getInt("cargoId"));
                cargoTableParams.setType(queryOutput.getString("type"));
                cargoTableParams.setOrderIdd(queryOutput.getInt("orderId"));

                cargoObservableList.add(cargoTableParams);
            }


            cargoIdd.setCellValueFactory(new PropertyValueFactory<>("cargId"));
            type.setCellValueFactory(new PropertyValueFactory<>("type"));
            orderIdd.setCellValueFactory(new PropertyValueFactory<>("orderIdd"));

            cargoTableView.setItems(cargoObservableList);
            filterCargoData();

            DataBaseOperations.disconnectFromDb(connection,statement);

        }
        catch (SQLException e)
        {
            Logger.getLogger(MainPage.class.getName()).log(Level.SEVERE, null,e);
            e.printStackTrace();
        }
    }

    private void filterCargoData() {
        FilteredList<CargoTableParams> filteredData = new FilteredList<>(cargoObservableList, b -> true);

        keyWordTextField3.textProperty().addListener((observable, oldValue, newValue) ->{
            filteredData.setPredicate(cargoSearchModel -> {
                if(newValue.isEmpty() || newValue.isBlank() || newValue ==null){
                    return true;
                }
                String searchKeyword3 = newValue.toLowerCase();

                if(Integer.toString(cargoSearchModel.getCargId()).toLowerCase().indexOf(searchKeyword3) > -1){
                    return true;
                } else if(cargoSearchModel.getType().toString().indexOf(searchKeyword3) > -1){
                    return true;
                }
                else if(Integer.toString(cargoSearchModel.getOrderIdd()).toLowerCase().indexOf(searchKeyword3) > -1){
                    return true;
                }
                return false;
            });
        });

        SortedList<CargoTableParams> sortedData = new SortedList<>(filteredData);

        sortedData.comparatorProperty().bind(cargoTableView.comparatorProperty());

        cargoTableView.setItems(sortedData);
    }

    @Override
    public void initialize(URL url, ResourceBundle resource){
      updateDestinationData();
      updateOrder();
      updateCargo();
      updateUser();
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

    private void showOrderPage(boolean IsUpdating) throws IOException {
        OrderTableParams orderTableParams = orderTableView.getSelectionModel().getSelectedItem();
        MainPage orderpage = this;
        FXMLLoader fxmlLoader = new FXMLLoader(LoginPage.class.getResource("/OrderData.fxml"));
        Parent parent = fxmlLoader.load();
        Scene scene = new Scene(parent);
        Stage stage = new Stage();
        OrderData controller = fxmlLoader.getController();
        System.out.println(IsUpdating);
        if(IsUpdating)
        {
            controller.setOrderData(orderTableParams);
        }
        controller.setDataClass(orderpage,IsUpdating);
        stage.initOwner((Stage) orderTableView.getScene().getWindow());
        stage.initModality(Modality.WINDOW_MODAL);
        stage.setScene(scene);
        stage.showAndWait();
        updateOrder();
    }
    private void showCargoPage(boolean IsUpdating) throws IOException {
       CargoTableParams cargoTableParams = cargoTableView.getSelectionModel().getSelectedItem();
        MainPage cargopage = this;
        FXMLLoader fxmlLoader = new FXMLLoader(LoginPage.class.getResource("/CargoData.fxml"));
        Parent parent = fxmlLoader.load();
        Scene scene = new Scene(parent);
        Stage stage = new Stage();
        CargoData controller = fxmlLoader.getController();
        System.out.println(IsUpdating);
        if(IsUpdating)
        {
            controller.setCargoData(cargoTableParams);
        }
        controller.setDataClass(cargopage,IsUpdating);
        stage.initOwner((Stage) cargoTableView.getScene().getWindow());
        stage.initModality(Modality.WINDOW_MODAL);
        stage.setScene(scene);
        stage.showAndWait();
        updateCargo();
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


    public void confirmOrder(ActionEvent actionEvent) throws IOException {
        showOrderPage(false);
    }


    public void deleteOrder(ActionEvent actionEvent) {

        OrderTableParams orderTableParams = orderTableView.getSelectionModel().getSelectedItem();
        try{
            Connection connection = DataBaseOperations.connectToDb();
            String orderDeleteQuery = "DELETE FROM `order` WHERE orderId = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(orderDeleteQuery);
            int Id  = orderTableParams.getOrdId();
            preparedStatement.setInt(1, Id);
            preparedStatement.executeUpdate();
            destinationObservableList.remove(orderTableParams);
            updateOrder();
        }
        catch (SQLException e)
        {
            Logger.getLogger(MainPage.class.getName()).log(Level.SEVERE, null,e);
            e.printStackTrace();
        }
    }

    public void updateOrderButton(ActionEvent actionEvent) throws IOException {
        showOrderPage(true);
    }

    public void cargoInsert(ActionEvent actionEvent) throws IOException {
        showCargoPage(false);
    }

    public void cargoDelete(ActionEvent actionEvent) {
        CargoTableParams cargoTableParams = cargoTableView.getSelectionModel().getSelectedItem();
        try{
            Connection connection = DataBaseOperations.connectToDb();
            String cargoDeleteQuery = "DELETE FROM cargo WHERE cargoId = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(cargoDeleteQuery);
            int Id  = cargoTableParams.getCargId();
            preparedStatement.setString(1, Integer.toString(Id));
            preparedStatement.executeUpdate();
            cargoObservableList.remove(cargoTableParams);

        }
        catch (SQLException e)
        {
            Logger.getLogger(MainPage.class.getName()).log(Level.SEVERE, null,e);
            e.printStackTrace();
        }
    }

    public void cargoUpdate(ActionEvent actionEvent) throws IOException {
        showCargoPage(true);
    }
    public void updateUser(){


        userObservableList.clear();
        DataBaseOperations connectNow = new DataBaseOperations();

        Connection connection = connectNow.connectToDb();

        String userViewQuery = "SELECT * FROM user";

        try{
            Statement statement = connection.createStatement();
            ResultSet queryOutput = statement.executeQuery(userViewQuery);

            while(queryOutput.next())
            {
                UserTableParams userTableParams = new UserTableParams();
                userTableParams.setuId(queryOutput.getInt("userId"));
                userTableParams.setNames(queryOutput.getString("name"));

                userObservableList.add(userTableParams);
            }

            userId.setCellValueFactory(new PropertyValueFactory<>("uId"));
            firstName.setCellValueFactory(new PropertyValueFactory<>("names"));


            userTableView.setItems(userObservableList);
            filterUsers();

            DataBaseOperations.disconnectFromDb(connection,statement);
        }
        catch (SQLException e)
        {
            Logger.getLogger(MainPage.class.getName()).log(Level.SEVERE, null,e);
            e.printStackTrace();
        }
    }
    public void filterUsers(){

        FilteredList<UserTableParams> filteredData = new FilteredList<>(userObservableList, b -> true);

        keyWordTextField4.textProperty().addListener((observable, oldValue, newValue) ->{
            filteredData.setPredicate(userSearchModel -> {
                if(newValue.isEmpty() || newValue.isBlank() || newValue ==null){
                    return true;
                }
                String searchKeyword = newValue.toLowerCase();

                if(String.valueOf(userSearchModel.getuId()).toLowerCase().indexOf(searchKeyword) > -1){
                    return true;
                } else if(userSearchModel.getNames().toString().indexOf(searchKeyword) > -1){
                    return true;
                }
                 else
                    return false;
            });
        });

        SortedList<UserTableParams> sortedData = new SortedList<>(filteredData);

        sortedData.comparatorProperty().bind(userTableView.comparatorProperty());

        userTableView.setItems(sortedData);
    }
    public void createUser(ActionEvent actionEvent) throws IOException {
        showUserPage(false);
    }

    public void deleteUser(ActionEvent actionEvent) {
        UserTableParams userTableParams = userTableView.getSelectionModel().getSelectedItem();
        try{
            Connection connection = DataBaseOperations.connectToDb();
            String userDeleteQuery = "DELETE FROM user WHERE userId = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(userDeleteQuery);
            int Id  = userTableParams.getuId();
            preparedStatement.setString(1, Integer.toString(Id));
            preparedStatement.executeUpdate();
            userObservableList.remove(userTableParams);

        }
        catch (SQLException e)
        {
            Logger.getLogger(MainPage.class.getName()).log(Level.SEVERE, null,e);
            e.printStackTrace();
        }
    }

    public void updateUserr(ActionEvent actionEvent) throws IOException {
        showUserPage(true);
    }
    private void showUserPage(boolean IsUpdating) throws IOException {
        UserTableParams userTableParams = userTableView.getSelectionModel().getSelectedItem();
        MainPage orderpage = this;
        FXMLLoader fxmlLoader = new FXMLLoader(LoginPage.class.getResource("/UserData.fxml"));
        Parent parent = fxmlLoader.load();
        Scene scene = new Scene(parent);
        Stage stage = new Stage();
        UserData controller = fxmlLoader.getController();

        if(IsUpdating)
        {
            controller.setUserData(userTableParams);
        }
        controller.setDataClass(orderpage,IsUpdating);
        stage.initOwner((Stage) userTableView.getScene().getWindow());
        stage.initModality(Modality.WINDOW_MODAL);
        stage.setScene(scene);
        stage.showAndWait();
        updateUser();
    }

    public void logout(ActionEvent actionEvent) throws IOException {
   //     destinationTableView.getItems().clear();
    //    destinationObservableList.clear();
      //  cargoTableView.getItems().clear();
      //  cargoObservableList.clear();
     //   userTableView.getItems().clear();
     //   userObservableList.clear();
    //    orderTableView.getItems().clear();
       // orderObservableList.clear();
        Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("/login-page.fxml"));
        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}
