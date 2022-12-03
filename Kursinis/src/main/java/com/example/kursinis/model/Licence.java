package com.example.kursinis.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Currency;

public class Licence implements Serializable {
    private String dateEnding;
    private String dateAquired;
    private String category;

    private int userId;

    private int id;

    public Licence(int id,String dateEnding, String dateAquired, String category,Integer userId) {
        this.dateEnding = dateEnding;
        this.dateAquired = dateAquired;
        this.category = category;
        this.id = id;
        this.userId = userId;
    }

    public String getDateEnding() {
        return dateEnding;
    }

    public void setDateEnding(String dateEnding) {
        this.dateEnding = dateEnding;
    }

    public String getDateAquired() {
        return dateAquired;
    }

    public void setDateAquired(String dateAquired) {
        this.dateAquired = dateAquired;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}
