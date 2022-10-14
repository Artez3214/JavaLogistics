package com.example.kursinis.model;

import java.io.Serializable;

public class Cargo implements Serializable {
    private int cargoId;
    private String type;

    public Cargo(int cargoId, String type) {
        this.cargoId = cargoId;
        this.type = type;
    }

    public int getCargoId() {
        return cargoId;
    }

    public void setCargoId(int cargoId) {
        this.cargoId = cargoId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
