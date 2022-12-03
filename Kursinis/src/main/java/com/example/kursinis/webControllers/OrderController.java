package com.example.kursinis.webControllers;

import com.example.kursinis.model.Order;
import com.example.kursinis.utils.JDBCOrderRepository;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Properties;

@RestController
public class OrderController {
    @Autowired
private
    JdbcTemplate jdbcTemplate;
    @Autowired
    private JDBCOrderRepository jdbcOrderRepository;

    public OrderController(JDBCOrderRepository jdbcOrderRepository) {
        this.jdbcOrderRepository = jdbcOrderRepository;
    }
    @PostMapping(value = "/insertOrder")
    public @ResponseBody String insert(@RequestBody String orderInfo){

        Gson gson = new Gson();
        Properties properties = gson.fromJson(orderInfo,Properties.class);
        String route    = properties.getProperty("route");
        Integer cargoId  = Integer.valueOf(properties.getProperty("cargo Id"));
        Integer destinationId  = Integer.valueOf(properties.getProperty("destination Id"));
        Integer driverId  = Integer.valueOf(properties.getProperty("driver Id"));
        Order order = new Order(0, route,cargoId,destinationId,driverId);
        jdbcTemplate.update("INSERT INTO `order` (`orderId`, `route`, `cargoId`, `destinationId`, `driverId`) VALUES (NULL, ?, ?, ?, ?)",route,
                cargoId,destinationId,driverId
        );
        return "records inserted are: " + route + " " + cargoId + " " + destinationId + " " + driverId;
    }
    @PostMapping(value = "/deleteOrder")
    public @ResponseBody String delete(@RequestBody String orderInfo){
        Gson gson = new Gson();
        Properties properties = gson.fromJson(orderInfo,Properties.class);
        Integer orderId  = Integer.valueOf(properties.getProperty("order Id"));
        try{
            jdbcTemplate.update("DELETE FROM `order` WHERE orderId = ?", orderId);
            return "Item was deleted";
        }
        catch (Exception e){
            return e.toString();
        }
    }

    @PostMapping(value = "/updateOrder")
    public @ResponseBody String update(@RequestBody String destinationInfo){
        Gson gson = new Gson();
        Properties properties = gson.fromJson(destinationInfo,Properties.class);
        Integer orderId  = Integer.valueOf(properties.getProperty("order Id"));
        String route    = properties.getProperty("route");
        Integer cargoId  = Integer.valueOf(properties.getProperty("cargo Id"));
        Integer destinationId  = Integer.valueOf(properties.getProperty("destination Id"));
        Integer driverId  = Integer.valueOf(properties.getProperty("driver Id"));
        try {
            jdbcTemplate.update(" UPDATE `order` SET `route` = ?, cargoid = ?, destinationid = ?, driverId = ? WHERE `order`.`orderId` = ? ", route,
                    cargoId, destinationId, driverId, orderId
            );
            return "record updated";
        }
        catch(Exception e){
            return e.toString();
        }

    }

    @GetMapping(value = "/allOrder")
    public @ResponseBody List<Order> findAll(){
        return jdbcOrderRepository.findAll();
    }
}
