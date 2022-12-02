package com.example.kursinis.utils;

import com.example.kursinis.model.Cargo;
import com.example.kursinis.model.Destination;
import com.example.kursinis.repository.CargoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class JDBCargoRepository implements CargoRepository {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<Cargo> findAll() {
        return jdbcTemplate.query(
                "select * from Cargo",
                (rs,rowNum) ->
                        new Cargo(
                                rs.getInt("cargoId"),
                                rs.getString("type")
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
