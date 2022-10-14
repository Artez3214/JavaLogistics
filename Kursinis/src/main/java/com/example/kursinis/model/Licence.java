package com.example.kursinis.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Currency;

public class Licence extends Driver implements Serializable {
    private LocalDate dateEnding;
    private LocalDate dateAquired;
    private String category;

    public Licence(String login, String name, String phoneNumber, String emailAddress, LocalDate birthDay, String username, String password, boolean isRetired, float salary, Currency currency, LocalDate healthEndDate, LocalDate driverLicenceEndDate, LocalDate dateEnding, LocalDate dateAquired, String category) {
        super(login, name, phoneNumber, emailAddress, birthDay, username, password, isRetired, salary, currency, healthEndDate, driverLicenceEndDate);
        this.dateEnding = dateEnding;
        this.dateAquired = dateAquired;
        this.category = category;
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
