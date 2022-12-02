package com.example.kursinis.utils;

import com.example.kursinis.model.Destination;
import com.example.kursinis.repository.DestinationRepository;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Properties;

@Repository
public class JdbcDestinationRepository implements DestinationRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public int count() {
        return jdbcTemplate
                .queryForObject("select count(*) from destination", Integer.class);
    }
    @Override
    public List<Destination> findAll() {
        return jdbcTemplate.query(
                "select * from Destination",
                (rs,rowNum) ->
                        new Destination(
                                rs.getInt("Id"),
                                rs.getString("PickupDestinationAddress"),
                                rs.getString("PickupDestinationDate"),
                                rs.getString("FinalDestinationDate"),
                                rs.getString("FinalDestinationAddress")

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
