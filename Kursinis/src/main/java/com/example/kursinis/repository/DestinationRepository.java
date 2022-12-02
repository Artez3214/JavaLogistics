package com.example.kursinis.repository;

import com.example.kursinis.model.Destination;

import java.util.List;

public interface DestinationRepository {


    int count();

    List<Destination> findAll();

    String insert(String destinationInfo);

    String delete(String destinationInfo);

    String update(String destinationInfo);

}
