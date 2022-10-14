package com.example.kursinis.model;

import java.io.Serializable;

public class Order implements Serializable {
    private int orderId;
    private String route;

    public Order(int orderId, String route) {
        this.orderId = orderId;
        this.route = route;
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
}
