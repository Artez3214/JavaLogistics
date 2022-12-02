package com.example.kursinis.fxControllers;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.fxml.FXML;

public class OrderTableParams {
    @FXML
    private SimpleIntegerProperty ordId = new SimpleIntegerProperty();
    @FXML
    private SimpleStringProperty rout = new SimpleStringProperty();
    @FXML
    private SimpleIntegerProperty cargoId = new SimpleIntegerProperty();
    @FXML
    private SimpleIntegerProperty desId = new SimpleIntegerProperty();
    @FXML
    private SimpleIntegerProperty driverId = new SimpleIntegerProperty();

    public int getDriverId() {
        return driverId.get();
    }

    public SimpleIntegerProperty driverIdProperty() {
        return driverId;
    }

    public void setDriverId(int driverId) {
        this.driverId.set(driverId);
    }

    public int getOrdId() {
        return ordId.get();
    }

    public SimpleIntegerProperty ordIdProperty() {
        return ordId;
    }

    public void setOrdId(int ordId) {
        this.ordId.set(ordId);
    }

    public String getRout() {
        return rout.get();
    }

    public SimpleStringProperty routProperty() {
        return rout;
    }

    public void setRout(String rout) {
        this.rout.set(rout);
    }

    public int getCargoId() {
        return cargoId.get();
    }

    public SimpleIntegerProperty cargoIdProperty() {
        return cargoId;
    }

    public void setCargoId(int cargoId) {
        this.cargoId.set(cargoId);
    }

    public int getDesId() {
        return desId.get();
    }

    public SimpleIntegerProperty desIdProperty() {
        return desId;
    }

    public void setDesId(int desId) {
        this.desId.set(desId);
    }
}
