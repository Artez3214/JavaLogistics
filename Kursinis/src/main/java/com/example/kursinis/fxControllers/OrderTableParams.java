package com.example.kursinis.fxControllers;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class OrderTableParams {
    private SimpleIntegerProperty ordId = new SimpleIntegerProperty();
    private SimpleStringProperty rout = new SimpleStringProperty();
    private SimpleIntegerProperty cargoId = new SimpleIntegerProperty();
    private SimpleIntegerProperty desId = new SimpleIntegerProperty();

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
