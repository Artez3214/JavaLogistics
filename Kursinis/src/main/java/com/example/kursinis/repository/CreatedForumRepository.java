package com.example.kursinis.repository;

import com.example.kursinis.model.CreatedForum;
import com.example.kursinis.model.Destination;

import java.util.List;

public interface CreatedForumRepository {
    List<CreatedForum> findAll();

    String insert(String destinationInfo);

    String delete(String destinationInfo);

    String update(String destinationInfo);
}
