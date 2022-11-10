package com.example.kursinis.fxControllers;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class DestinationTableParams {


    private SimpleIntegerProperty colId = new SimpleIntegerProperty();
    private SimpleStringProperty startDest = new SimpleStringProperty();
    private SimpleStringProperty endDest = new SimpleStringProperty();

    private SimpleStringProperty startDat = new SimpleStringProperty();
    private SimpleStringProperty endDat = new SimpleStringProperty();

    public String getStartDat() {
        return startDat.get();
    }

    public SimpleStringProperty startDatProperty() {
        return startDat;
    }

    public void setStartDat(String startDat) {
        this.startDat.set(startDat);
    }

    public String getEndDat() {
        return endDat.get();
    }

    public SimpleStringProperty endDatProperty() {
        return endDat;
    }

    public void setEndDat(String endDat) {
        this.endDat.set(endDat);
    }

    public int getColId() {
        return colId.get();
    }

    public SimpleIntegerProperty colIdProperty() {
        return colId;
    }

    public void setColId(int colId) {
        this.colId.set(colId);
    }

    public String getStartDest() {
        return startDest.get();
    }

    public SimpleStringProperty startDestProperty() {
        return startDest;
    }

    public void setStartDest(String startDest) {
        this.startDest.set(startDest);
    }

    public String getEndDest() {
        return endDest.get();
    }

    public SimpleStringProperty endDestProperty() {
        return endDest;
    }

    public void setEndDest(String endDest) {
        this.endDest.set(endDest);
    }
}
