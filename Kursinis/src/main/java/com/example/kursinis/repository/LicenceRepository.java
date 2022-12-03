package com.example.kursinis.repository;

import com.example.kursinis.model.Licence;

import java.util.List;

public interface LicenceRepository {
    List<Licence> findAll();

    String insert(String destinationInfo);

    String delete(String destinationInfo);

    String update(String destinationInfo);
}
