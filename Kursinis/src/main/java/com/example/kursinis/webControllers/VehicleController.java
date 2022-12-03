package com.example.kursinis.webControllers;

import com.example.kursinis.model.Vehicle;
import com.example.kursinis.utils.JDBCVehicleRepository;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Properties;

@RestController
public class VehicleController {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private JDBCVehicleRepository jdbcVehicleRepository;

    public VehicleController(JDBCVehicleRepository jdbcVehicleRepository) {
        this.jdbcVehicleRepository = jdbcVehicleRepository;
    }

    @PostMapping(value = "/insertVehicle")
    public @ResponseBody String insert(@RequestBody String vehicleInfo){

        Gson gson = new Gson();
        Properties properties = gson.fromJson(vehicleInfo,Properties.class);
        String type    = properties.getProperty("type");
        String carNumber  = properties.getProperty("car Number");
        String wheelNumber  = properties.getProperty("wheel Number");
        Float locationDegreeX  = Float.valueOf(properties.getProperty("location Degree X"));
        Float locationDegreeY  = Float.valueOf(properties.getProperty("location Degree Y"));
        String name  = properties.getProperty("name");
        String company  = properties.getProperty("company");
        String ensurance  = properties.getProperty("ensurance");
        String dateCreated  = properties.getProperty("dateCreated");
        String userId  = properties.getProperty("userId");
        Vehicle vehicle = new Vehicle("0", type,carNumber,wheelNumber,locationDegreeX,locationDegreeY,name,company,ensurance,dateCreated);
        jdbcTemplate.update("INSERT INTO vehicle (vehicleId, type, carNumber, wheelNumber, locationDegreeX,locationDegreeY,name,company,ensurance,dateCreated,userId) VALUES (NULL, ?, ?, ?, ?,?,?,?,?,?,?)",type,
                carNumber,wheelNumber,locationDegreeX,locationDegreeY,name,company,ensurance,dateCreated,userId
        );
        return "records inserted are: " + type + " " + carNumber + " " + wheelNumber + " " + locationDegreeX + " " + locationDegreeY + " " + name + " " + company + " " + ensurance + " " + dateCreated;
    }
    @PostMapping(value = "/deleteVehicle")
    public @ResponseBody String delete(@RequestBody String vehicleInfo){
        Gson gson = new Gson();
        Properties properties = gson.fromJson(vehicleInfo,Properties.class);
        Integer vehicleId  = Integer.valueOf(properties.getProperty("vehicle Id"));
        try{
            jdbcTemplate.update("DELETE FROM `vehicle` WHERE vehicleId = ?", vehicleId);
            return "Item was deleted";
        }
        catch (Exception e){
            return e.toString();
        }
    }
    @PostMapping(value = "/updateVehicle")
    public @ResponseBody String update(@RequestBody String vehicleInfo){
        Gson gson = new Gson();
        Properties properties = gson.fromJson(vehicleInfo,Properties.class);
        Integer vehicleId  = Integer.valueOf(properties.getProperty("vehicle Id"));
        String type    = properties.getProperty("type");
        String carNumber  = properties.getProperty("car Number");
        String wheelNumber  = properties.getProperty("wheel Number");
        Float locationDegreeX  = Float.valueOf(properties.getProperty("location Degree X"));
        Float locationDegreeY  = Float.valueOf(properties.getProperty("location Degree Y"));
        String name  = properties.getProperty("name");
        String company  = properties.getProperty("company");
        String ensurance  = properties.getProperty("ensurance");
        String dateCreated  = properties.getProperty("dateCreated");
        String userId  = properties.getProperty("userId");
        try {
            jdbcTemplate.update(" UPDATE `vehicle` SET `type` = ?, carNumber = ?, wheelNumber = ?, locationDegreeX = ? , locationDegreeY = ?, name = ?, company = ?, ensurance = ?, dateCreated= ?,userId = ? WHERE `vehicle`.`vehicleId` = ? ", type,
                    carNumber, wheelNumber, locationDegreeX, locationDegreeY, name,company,ensurance,dateCreated,userId,vehicleId
            );
            return "record updated";
        }
        catch(Exception e){
            return e.toString();
        }

    }

    @GetMapping(value = "/allVehicle")
    public @ResponseBody List<Vehicle> findAll(){
        return jdbcVehicleRepository.findAll();
    }
}
