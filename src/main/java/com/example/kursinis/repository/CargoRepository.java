package com.example.kursinis.repository;

import com.example.kursinis.model.Cargo;
import com.example.kursinis.model.Destination;

import java.util.List;

public interface CargoRepository{
    List<Cargo> findAll();

    String insert(String destinationInfo);

    String delete(String destinationInfo);

    String update(String destinationInfo);
}
