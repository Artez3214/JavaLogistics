package com.example.kursinis.webControllers;

import com.example.kursinis.model.Cargo;
import com.example.kursinis.utils.JDBCargoRepository;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Properties;
@RestController
public class CargoController {

    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Autowired
    private JDBCargoRepository jdbCargoRepository;

    public CargoController(JDBCargoRepository jdbCargoRepository) {
        this.jdbCargoRepository = jdbCargoRepository;
    }

    @PostMapping(value = "/insertCargo")
    public @ResponseBody String insert(@RequestBody String cargoInfo){
        Gson gson = new Gson();
        Properties properties = gson.fromJson(cargoInfo,Properties.class);
        String type = properties.getProperty("type");
        String orderId = properties.getProperty("orderId");
        Cargo cargo = new Cargo(0,type);
        jdbcTemplate.update("INSERT INTO cargo (cargoId,type,orderId) VALUES (NULL,?,?)",type,orderId);
        return "records inserted are: " + type;
    }

    @PostMapping(value = "/deleteCargo")
    public @ResponseBody String delete(@RequestBody String cargoInfo){
        Gson gson = new Gson();
        Properties properties = gson.fromJson(cargoInfo,Properties.class);
        String cargoId = properties.getProperty("cargo Id");
        try{
            jdbcTemplate.update("DELETE FROM cargo WHERE cargoId = ?", cargoId);
            return "Item was deleted";
        }
        catch (Exception e){
            return e.toString();
        }
    }

    @PostMapping(value = "/updateCargo")
    public @ResponseBody String update(@RequestBody String cargoInfo){
        Gson gson = new Gson();
        Properties properties = gson.fromJson(cargoInfo,Properties.class);
        String cargoId = properties.getProperty("cargo Id");
        String type = properties.getProperty("type");
        String orderId = properties.getProperty("orderId");
        try {
            jdbcTemplate.update("UPDATE destination SET type = ?, orderId = ? WHERE cargoId = ? ", type,
                    orderId, cargoId
            );
            return "record updated";
        }
        catch(Exception e){
            return e.toString();
        }
    }

    @GetMapping(value = "/allCargo")
    public @ResponseBody List<Cargo> findAll(){
        return jdbCargoRepository.findAll();
    }
}
