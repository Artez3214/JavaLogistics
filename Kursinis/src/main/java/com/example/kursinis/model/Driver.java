package com.example.kursinis.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Currency;

public class Driver extends User implements Serializable {
    private LocalDate healthEndDate;
    private LocalDate driverLicenceEndDate;

    public Driver(String login, String name, String phoneNumber, String emailAddress, LocalDate birthDay, String username, String password, boolean isRetired, float salary, Currency currency, LocalDate healthEndDate, LocalDate driverLicenceEndDate) {
        super(login, name, phoneNumber, emailAddress, birthDay, username, password, isRetired, salary, currency);
        this.healthEndDate = healthEndDate;
        this.driverLicenceEndDate = driverLicenceEndDate;
    }

    public LocalDate getHealthEndDate() {
        return healthEndDate;
    }

    public void setHealthEndDate(LocalDate healthEndDate) {
        this.healthEndDate = healthEndDate;
    }

    public LocalDate getDriverLicenceEndDate() {
        return driverLicenceEndDate;
    }

    public void setDriverLicenceEndDate(LocalDate driverLicenceEndDate) {
        this.driverLicenceEndDate = driverLicenceEndDate;
    }
}
