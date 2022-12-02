package com.example.kursinis.repository;

import com.example.kursinis.model.Destination;
import com.example.kursinis.model.Vehicle;

import java.util.List;

public interface VehicleRepository {
    List<Vehicle> findAll();

    String insert(String destinationInfo);

    String delete(String destinationInfo);

    String update(String destinationInfo);
}
