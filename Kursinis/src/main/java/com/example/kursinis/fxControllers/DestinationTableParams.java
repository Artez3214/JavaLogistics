package com.example.kursinis.fxControllers;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class DestinationTableParams {

    private SimpleIntegerProperty colId = new SimpleIntegerProperty();
    private SimpleStringProperty startDest = new SimpleStringProperty();
    private SimpleStringProperty endDest = new SimpleStringProperty();

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
