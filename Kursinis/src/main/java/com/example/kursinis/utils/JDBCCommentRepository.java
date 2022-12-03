package com.example.kursinis.utils;

import com.example.kursinis.model.Cargo;
import com.example.kursinis.model.Comment;
import com.example.kursinis.model.Destination;
import com.example.kursinis.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class JDBCCommentRepository implements CommentRepository {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<Comment> findAll() {
        return jdbcTemplate.query(
                "select * from comment",
                (rs,rowNum) ->
                        new Comment(
                                rs.getInt("commentId"),
                                rs.getString("text"),
                                rs.getInt("forumId")
                        )
        );
    }
    @Override
    public String delete(String destinationInfo){return "";}

    @Override
    public String update(String destinationInfo){return "";}

    @Override
    public String insert(String destinationInfo){return "";}
}
