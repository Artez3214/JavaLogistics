package com.example.kursinis.utils;

import com.example.kursinis.model.CreatedForum;
import com.example.kursinis.repository.CreatedForumRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class JDBCCreatedForumRepository implements CreatedForumRepository {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<CreatedForum> findAll() {
        return jdbcTemplate.query(
                "select * from forum",
                (rs,rowNum) ->
                        new CreatedForum(
                                rs.getInt("forumId"),
                                rs.getString("forumTopic"),
                                rs.getInt("userId"))
        );
    }
    @Override
    public String delete(String destinationInfo){return "";}

    @Override
    public String update(String destinationInfo){return "";}

    @Override
    public String insert(String destinationInfo){return "";}
}
