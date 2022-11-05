package com.example.kursinis.fxControllers;

import com.example.kursinis.HelloApplication;
import com.example.kursinis.utils.DataBaseOperations;
import com.example.kursinis.utils.FxUtils;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;


import java.net.URL;
import java.sql.*;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;


public class DestinationData{
    @FXML
    private TextField pickupaddress;
    @FXML
    private TextField finaldesaddress;
    @FXML
    private TextField pickupdate;
    @FXML
    private TextField finaldate;

    private String pickupDestinationAddres, finalDestinationAddres;

    private String pickupDestinationDat, finalDestinationDat;


    public TextField getPickupaddress() {
        return pickupaddress;
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
      /*  DataBaseOperations connectNow = new DataBaseOperations();

        Connection connection = connectNow.connectToDb();

        String Query = "UPDATE destination SET PickupDestinationAddress = ?, PickUpDestinationDate = ?, FinalDestinationDate = ?, FinalDestinationAddress = ? WHERE id = ? ";

        try{
            PreparedStatement preparedStatement = connection.prepareStatement(Query);
            //private String pickupDestinationAddres, finalDestinationAddres;

           // private String pickupDestinationDat, finalDestinationDat;
            preparedStatement.setString(5, Integer.toString(id));
            preparedStatement.setString(1, pickupDestinationAddres);
            preparedStatement.setString(2, pickupDestinationDat);
            preparedStatement.setString(3, finalDestinationDat);
            preparedStatement.setString(4, finalDestinationAddres);
            preparedStatement.executeUpdate();
            updateData();
            DataBaseOperations.disconnectFromDb(connection,preparedStatement);

        }
        catch (SQLException e)
        {
            Logger.getLogger(DestinationPage.class.getName()).log(Level.SEVERE, null,e);
            e.printStackTrace();
        }*/
    }

    public void cancel(ActionEvent actionEvent) {
    }
}
