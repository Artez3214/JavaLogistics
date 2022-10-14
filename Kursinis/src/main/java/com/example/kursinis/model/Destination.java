package com.example.kursinis.model;

import java.io.Serializable;
import java.time.LocalDate;

public abstract class Destination implements Serializable {
    private String Address;
    private int destinationId;
    private String finalDestinationAddress;
    private String pickupDestinationAddress;
    private LocalDate pickupDestinationDate;
    private LocalDate finalDestinationDate;

    public Destination(String address, int destinationId, String finalDestinationAddress, String pickupDestinationAddress, LocalDate pickupDestinationDate, LocalDate finalDestinationDate) {
        Address = address;
        this.destinationId = destinationId;
        this.finalDestinationAddress = finalDestinationAddress;
        this.pickupDestinationAddress = pickupDestinationAddress;
        this.pickupDestinationDate = pickupDestinationDate;
        this.finalDestinationDate = finalDestinationDate;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public int getDestinationId() {
        return destinationId;
    }

    public void setDestinationId(int destinationId) {
        this.destinationId = destinationId;
    }

    public String getFinalDestinationAddress() {
        return finalDestinationAddress;
    }

    public void setFinalDestinationAddress(String finalDestinationAddress) {
        this.finalDestinationAddress = finalDestinationAddress;
    }

    public String getPickupDestinationAddress() {
        return pickupDestinationAddress;
    }

    public void setPickupDestinationAddress(String pickupDestinationAddress) {
        this.pickupDestinationAddress = pickupDestinationAddress;
    }

    public LocalDate getPickupDestinationDate() {
        return pickupDestinationDate;
    }

    public void setPickupDestinationDate(LocalDate pickupDestinationDate) {
        this.pickupDestinationDate = pickupDestinationDate;
    }

    public LocalDate getFinalDestinationDate() {
        return finalDestinationDate;
    }

    public void setFinalDestinationDate(LocalDate finalDestinationDate) {
        this.finalDestinationDate = finalDestinationDate;
    }
}
