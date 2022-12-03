package com.example.kursinis.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.*;

public class User implements Serializable {

    private String userId;
    private String name;
    private String phoneNumber;
    private String emailAddress;
    private String birthDay;
    private String username;
    private String password;
    private boolean isRetired;
    private float salary;
    private String currency;

    public User(String userId, String name, String phoneNumber, String emailAddress, String birthDay, String username, String password, boolean isRetired, float salary, String currency) {
        this.userId = userId;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.emailAddress = emailAddress;
        this.birthDay = birthDay;
        this.username = username;
        this.password = password;
        this.isRetired = isRetired;
        this.salary = salary;
        this.currency = currency;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(String birthDay) {
        this.birthDay = birthDay;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isRetired() {
        return isRetired;
    }

    public void setRetired(boolean retired) {
        isRetired = retired;
    }

    public float getSalary() {
        return salary;
    }

    public void setSalary(float salary) {
        this.salary = salary;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }
}
