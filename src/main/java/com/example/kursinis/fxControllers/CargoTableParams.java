package com.example.kursinis.fxControllers;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class CargoTableParams {

    private SimpleIntegerProperty cargId = new SimpleIntegerProperty();
    private SimpleStringProperty type = new SimpleStringProperty();

    private SimpleIntegerProperty orderIdd = new SimpleIntegerProperty();

    public int getOrderIdd() {
        return orderIdd.get();
    }

    public SimpleIntegerProperty orderIddProperty() {
        return orderIdd;
    }

    public void setOrderIdd(int orderIdd) {
        this.orderIdd.set(orderIdd);
    }

    public int getCargId() {
        return cargId.get();
    }

    public SimpleIntegerProperty cargIdProperty() {
        return cargId;
    }

    public void setCargId(int cargId) {
        this.cargId.set(cargId);
    }

    public String getType() {
        return type.get();
    }

    public SimpleStringProperty typeProperty() {
        return type;
    }

    public void setType(String type) {
        this.type.set(type);
    }
}
