package com.example.kursinis.model;

import java.io.Serializable;
import java.time.LocalDate;

public class Destination implements Serializable {

    private int dessId;

    private String pickupDestinationAddres, finalDestinationAddres;

    private String pickupDestinationDat, finalDestinationDat;

    public Destination(int dessId, String pickupDestinationAddres, String finalDestinationAddres, String pickupDestinationDat, String finalDestinationDat) {
        this.dessId = dessId;
        this.pickupDestinationAddres = pickupDestinationAddres;
        this.finalDestinationAddres = finalDestinationAddres;
        this.pickupDestinationDat = pickupDestinationDat;
        this.finalDestinationDat = finalDestinationDat;
    }

    public int getDessId() {
        return dessId;
    }

    public void setDesId(int dessId) {
        this.dessId = dessId;
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
}
