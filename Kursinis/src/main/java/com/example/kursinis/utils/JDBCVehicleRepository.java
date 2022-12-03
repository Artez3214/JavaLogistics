package com.example.kursinis.utils;

import com.example.kursinis.model.User;
import com.example.kursinis.model.Vehicle;
import com.example.kursinis.repository.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.Currency;
import java.util.List;
@Repository
public class JDBCVehicleRepository implements VehicleRepository {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<Vehicle> findAll() {
        return jdbcTemplate.query(
                "select * from vehicle",
                (rs,rowNum) ->
                        new Vehicle(
                                rs.getString("vehicleId"),
                                rs.getString("type"),
                                rs.getString("carNumber"),
                                rs.getString("wheelNumber"),
                                rs.getFloat("locationDegreeX"),
                                rs.getFloat("locationDegreeY"),
                                rs.getString("name"),
                                rs.getString("company"),
                                rs.getString("ensurance"),
                                rs.getString("dateCreated")
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
