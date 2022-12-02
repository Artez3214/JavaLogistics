package com.example.kursinis.repository;

import com.example.kursinis.model.Destination;
import com.example.kursinis.model.Order;

import java.util.List;

public interface OrderRepository {
    List<Order> findAll();

    String insert(String destinationInfo);

    String delete(String destinationInfo);

    String update(String destinationInfo);
}
