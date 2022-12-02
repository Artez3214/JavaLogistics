package com.example.kursinis.repository;

import com.example.kursinis.model.Destination;
import com.example.kursinis.model.Driver;
import com.example.kursinis.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.swing.text.html.parser.Entity;
import java.util.List;

public interface UserRepository /*extends JpaRepository<User,Integer>*/ {

    List<User> findAll();

    String insert(String destinationInfo);

    String delete(String destinationInfo);

    String update(String destinationInfo);
}
