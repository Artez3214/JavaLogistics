package com.example.kursinis.utils;

import com.example.kursinis.model.Destination;
import com.example.kursinis.model.User;
import com.example.kursinis.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.Currency;
import java.util.List;
@Repository
public class JDBCUserRepository implements UserRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<User> findAll() {
        return jdbcTemplate.query(
                "select * from user",
                (rs,rowNum) ->
                        new User(
                                rs.getString("userId"),
                                rs.getString("name"),
                                rs.getString("phoneNumber"),
                                rs.getString("emailAddress"),
                                rs.getString("birthDay"),
                                rs.getString("username"),
                                rs.getString("password"),
                                rs.getBoolean("isRetired"),
                                rs.getInt("salary"),
                                rs.getString("currency")
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
