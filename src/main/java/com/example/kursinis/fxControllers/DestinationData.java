package com.example.kursinis.fxControllers;

import com.example.kursinis.utils.DataBaseOperations;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;


import java.io.IOException;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;


public class DestinationData {
    @FXML
    private TextField pickupaddress;
    @FXML
    private TextField finaldesaddress;
    @FXML
    private TextField pickupdate;
    @FXML
    private TextField finaldate;

    private MainPage destinationPage;

    @FXML
    Button returnb;
    private int id;
    private String pickupDestinationAddres, finalDestinationAddres;

    private String pickupDestinationDat, finalDestinationDat;

    private boolean IsUpdate;


    public TextField getPickupaddress() {
        return pickupaddress;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setPickupaddress(TextField pickupaddress) {
        this.pickupaddress = pickupaddress;
    }

    public TextField getFinaldesaddress() {
        return finaldesaddress;
    }

    public void setFinaldesaddress(TextField finaldesaddress) {
        this.finaldesaddress = finaldesaddress;
    }

    public TextField getPickupdate() {
        return pickupdate;
    }

    public void setPickupdate(TextField pickupdate) {
        this.pickupdate = pickupdate;
    }

    public TextField getFinaldate() {
        return finaldate;
    }

    public void setFinaldate(TextField finaldate) {
        this.finaldate = finaldate;
    }

    public String getPickupDestinationAddres() {
        return pickupDestinationAddres;
    }

    public void setPickupDestinationAddres(String pickupDestinationAddres) {
        this.pickupDestinationAddres = pickupDestinationAddres;
    }

    public String getFinalDestinationAddres() {
        return finalDestinationAddres;
    }

    public void setFinalDestinationAddres(String finalDestinationAddres) {
        this.finalDestinationAddres = finalDestinationAddres;
    }

    public String getPickupDestinationDat() {
        return pickupDestinationDat;
    }

    public void setPickupDestinationDat(String pickupDestinationDat) {
        this.pickupDestinationDat = pickupDestinationDat;
    }

    public String getFinalDestinationDat() {
        return finalDestinationDat;
    }

    public void setFinalDestinationDat(String finalDestinationDat) {
        this.finalDestinationDat = finalDestinationDat;
    }

    public void confirm(ActionEvent actionEvent) {
        DataBaseOperations connectNow = new DataBaseOperations();

        Connection connection = connectNow.connectToDb();


        String Query = "UPDATE destination SET PickupDestinationAddress = ?, PickUpDestinationDate = ?, FinalDestinationDate = ?, FinalDestinationAddress = ? WHERE id = ? ";
        String QueryInsert = "INSERT INTO `destination` (`id`, `PickupDestinationAddress`, `PickUpDestinationDate`, `FinalDestinationDate`, `FinalDestinationAddress`) VALUES (NULL, ?, ?, ?, ?)";

        try{


                if (!IsUpdate) {
                    PreparedStatement preparedStatement2 = connection.prepareStatement(QueryInsert);

                    preparedStatement2.setString(1, pickupaddress.getText());
                    preparedStatement2.setString(2, pickupdate.getText());
                    preparedStatement2.setString(3, finaldate.getText());
                    preparedStatement2.setString(4, finaldesaddress.getText());
                    preparedStatement2.executeUpdate();
                }
                else{
                    PreparedStatement preparedStatement = connection.prepareStatement(Query);

                    preparedStatement.setString(1, pickupaddress.getText());
                    preparedStatement.setString(2, pickupdate.getText());
                    preparedStatement.setString(3, finaldate.getText());
                    preparedStatement.setString(4, finaldesaddress.getText());
                    preparedStatement.setInt(5, id);
                    preparedStatement.executeUpdate();
                }
        }
        catch (SQLException e)
        {
            Logger.getLogger(MainPage.class.getName()).log(Level.SEVERE, null,e);
            e.printStackTrace();
        }
        destinationPage.updateDestinationData();
    }


    public void cancel(ActionEvent actionEvent) throws IOException {

        Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("main-page.fxml"));

        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();

        stage.close();

    }

    public void setData(DestinationTableParams destinationTableParams) {
        pickupaddress.setText(destinationTableParams.getStartDest());
        finaldesaddress.setText(destinationTableParams.getEndDest());
        pickupdate.setText(destinationTableParams.getStartDat());
        finaldate.setText(destinationTableParams.getEndDat());
        setId(destinationTableParams.getColId());
    }


    public void setDataClass(MainPage destinationpage,boolean isUpdate) {

        destinationPage = destinationpage;
        IsUpdate = isUpdate;
    }



}
