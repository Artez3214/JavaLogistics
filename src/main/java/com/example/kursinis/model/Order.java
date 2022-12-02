package com.example.kursinis.model;

import java.io.Serializable;

public class Order implements Serializable {
    private int orderId;
    private String route;

    private int cargoId;

    private int destinationId;

    private int driverId;

    public Order(int orderId, String route, int cargoId, int destinationId, int driverId) {
        this.orderId = orderId;
        this.route = route;
        this.cargoId = cargoId;
        this.destinationId = destinationId;
        this.driverId = driverId;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public String getRoute() {
        return route;
    }

    public void setRoute(String route) {
        this.route = route;
    }

    public int getCargoId() {
        return cargoId;
    }

    public void setCargoId(int cargoId) {
        this.cargoId = cargoId;
    }

    public int getDestinationId() {
        return destinationId;
    }

    public void setDestinationId(int destinationId) {
        this.destinationId = destinationId;
    }

    public int getDriverId() {
        return driverId;
    }

    public void setDriverId(int driverId) {
        this.driverId = driverId;
    }
}
