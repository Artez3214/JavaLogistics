package com.example.kursinis.webControllers;

import com.example.kursinis.model.Destination;
import com.example.kursinis.model.User;
import com.example.kursinis.repository.DestinationRepository;
import com.example.kursinis.repository.UserRepository;
import com.example.kursinis.utils.JdbcDestinationRepository;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Properties;

@RestController
public class DestinationController {
    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Autowired
    private JdbcDestinationRepository jdbcDestinationRepository;

    public DestinationController(JdbcDestinationRepository jdbcDestinationRepository) {
        this.jdbcDestinationRepository = jdbcDestinationRepository;
    }

    @GetMapping(value = "/countDestinations")
    public @ResponseBody int countDestination(){
        return jdbcDestinationRepository.count();
     }

    @PostMapping(value = "/insertDestinations")
    public @ResponseBody String insert(@RequestBody String destinationInfo){

        Gson gson = new Gson();
        Properties properties = gson.fromJson(destinationInfo,Properties.class);
        String pickupDestinationAddres = properties.getProperty("pickup address");
        String finalDestinationAddres  = properties.getProperty("final address");
        String pickupDestinationDat    = properties.getProperty("destination date");
        String finalDestinationDat     = properties.getProperty("final destination date");
        Destination destination = new Destination(0,pickupDestinationAddres,finalDestinationAddres,pickupDestinationDat,finalDestinationDat);
        jdbcTemplate.update("INSERT INTO `destination` (`id`, `PickupDestinationAddress`, `PickUpDestinationDate`, `FinalDestinationDate`, `FinalDestinationAddress`) VALUES (NULL, ?, ?, ?, ?)",pickupDestinationAddres,
                finalDestinationAddres,pickupDestinationDat,finalDestinationDat
        );
        return "records inserted are: " + pickupDestinationAddres + " " + finalDestinationAddres + " " + pickupDestinationDat + " " + finalDestinationDat;
    }

    @PostMapping(value = "/deleteDestinations")
    public @ResponseBody String delete(@RequestBody String destinationInfo){
        Gson gson = new Gson();
        Properties properties = gson.fromJson(destinationInfo,Properties.class);
        String id = properties.getProperty("Id");
        try{
            jdbcTemplate.update("DELETE FROM destination WHERE id = ?", id);
            return "Item was deleted";
        }
        catch (Exception e){
            return e.toString();
        }
    }

    @PostMapping(value = "/updateDestinations")
    public @ResponseBody String update(@RequestBody String destinationInfo){
        Gson gson = new Gson();
        Properties properties = gson.fromJson(destinationInfo,Properties.class);
        String id = properties.getProperty("Id");
        String pickupDestinationAddres = properties.getProperty("pickup address");
        String finalDestinationAddres  = properties.getProperty("final address");
        String pickupDestinationDat    = properties.getProperty("destination date");
        String finalDestinationDat     = properties.getProperty("final destination date");
         try {
            jdbcTemplate.update("UPDATE destination SET PickupDestinationAddress = ?, PickUpDestinationDate = ?, FinalDestinationDate = ?, FinalDestinationAddress = ? WHERE id = ? ", pickupDestinationAddres,
                    finalDestinationAddres, pickupDestinationDat, finalDestinationDat, id
            );
            return "record updated";
        }
        catch(Exception e){
            return e.toString();
        }

    }
    @GetMapping(value = "/allDestinations")
    public @ResponseBody List<Destination> findAll(){
        return jdbcDestinationRepository.findAll();
    }
}
