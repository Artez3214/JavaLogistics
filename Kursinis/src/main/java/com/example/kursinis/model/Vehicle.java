package com.example.kursinis.model;

import java.io.Serializable;
import java.time.LocalDate;

public class Vehicle implements Serializable {
    private String type;
    private String carNumber;
    private String wheels;
    private float locationDegreeX;
    private float locationDegreeY;
    private String carName;
    private String manufacturer;
    private String ensurance;
    private LocalDate dateCreated;

    public Vehicle(String type, String carNumber, String wheels, float locationDegreeX, float locationDegreeY, String carName, String manufacturer, String ensurance, LocalDate dateCreated) {
        this.type = type;
        this.carNumber = carNumber;
        this.wheels = wheels;
        this.locationDegreeX = locationDegreeX;
        this.locationDegreeY = locationDegreeY;
        this.carName = carName;
        this.manufacturer = manufacturer;
        this.ensurance = ensurance;
        this.dateCreated = dateCreated;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getCarNumber() {
        return carNumber;
    }

    public void setCarNumber(String carNumber) {
        this.carNumber = carNumber;
    }

    public String getWheels() {
        return wheels;
    }

    public void setWheels(String wheels) {
        this.wheels = wheels;
    }

    public float getLocationDegreeX() {
        return locationDegreeX;
    }

    public void setLocationDegreeX(float locationDegreeX) {
        this.locationDegreeX = locationDegreeX;
    }

    public float getLocationDegreeY() {
        return locationDegreeY;
    }

    public void setLocationDegreeY(float locationDegreeY) {
        this.locationDegreeY = locationDegreeY;
    }

    public String getCarName() {
        return carName;
    }

    public void setCarName(String carName) {
        this.carName = carName;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getEnsurance() {
        return ensurance;
    }

    public void setEnsurance(String ensurance) {
        this.ensurance = ensurance;
    }

    public LocalDate getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(LocalDate dateCreated) {
        this.dateCreated = dateCreated;
    }
}
