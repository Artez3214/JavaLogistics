package com.example.kursinis.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Currency;

public class Manager extends User implements Serializable {
    private int managedDrivers;
    private String Company;

    public Manager(String login, String name, String phoneNumber, String emailAddress, LocalDate birthDay, String username, String password, boolean isRetired, float salary, Currency currency, int managedDrivers) {
        super(login, name, phoneNumber, emailAddress, birthDay, username, password, isRetired, salary, currency);
        this.managedDrivers = managedDrivers;
    }

    public int getManagedDrivers() {
        return managedDrivers;
    }

    public void setManagedDrivers(int managedDrivers) {
        this.managedDrivers = managedDrivers;
    }

    public String getCompany() {
        return Company;
    }

    public void setCompany(String company) {
        Company = company;
    }
}
