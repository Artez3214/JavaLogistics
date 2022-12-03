package com.example.kursinis.utils;

import com.example.kursinis.model.Licence;
import com.example.kursinis.model.Order;
import com.example.kursinis.repository.OrderRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
@Repository
public class JDBCOrderRepository implements OrderRepository {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<Order> findAll() {
        return jdbcTemplate.query(
                "SELECT * FROM `order` WHERE 1",
                (rs,rowNum) ->
                        new Order(
                                rs.getInt("orderId"),
                                rs.getString("route"),
                                rs.getInt("cargoId"),
                                rs.getInt("destinationId"),
                                rs.getInt("driverId")
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
