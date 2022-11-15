package com.example.kursinis.fxControllers;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.fxml.FXML;

public class UserTableParams {
    @FXML
    private SimpleIntegerProperty uId = new SimpleIntegerProperty();
    @FXML
    private SimpleStringProperty names = new SimpleStringProperty();

    public int getuId() {
        return uId.get();
    }

    public SimpleIntegerProperty uIdProperty() {
        return uId;
    }

    public void setuId(int uId) {
        this.uId.set(uId);
    }

    public String getNames() {
        return names.get();
    }

    public SimpleStringProperty namesProperty() {
        return names;
    }

    public void setNames(String names) {
        this.names.set(names);
    }
}
