package com.example.kursinis.repository;

import com.example.kursinis.model.Comment;
import com.example.kursinis.model.Destination;

import java.util.List;

public interface CommentRepository {
    List<Comment> findAll();

    String insert(String destinationInfo);

    String delete(String destinationInfo);

    String update(String destinationInfo);
}
