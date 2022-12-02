package com.example.kursinis.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Currency;

public class Licence implements Serializable {
    private LocalDate dateEnding;
    private LocalDate dateAquired;
    private String category;

    private int id;

    public Licence(int id,LocalDate dateEnding, LocalDate dateAquired, String category) {
        this.dateEnding = dateEnding;
        this.dateAquired = dateAquired;
        this.category = category;
        this.id = id;
    }

    public LocalDate getDateEnding() {
        return dateEnding;
    }

    public void setDateEnding(LocalDate dateEnding) {
        this.dateEnding = dateEnding;
    }

    public LocalDate getDateAquired() {
        return dateAquired;
    }

    public void setDateAquired(LocalDate dateAquired) {
        this.dateAquired = dateAquired;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}
