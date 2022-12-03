package com.example.kursinis.webControllers;

import com.example.kursinis.model.Licence;
import com.example.kursinis.utils.JDBCLicenceRepository;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Properties;

@RestController
public class LicenceController {
    @Autowired
private JdbcTemplate jdbcTemplate;
    @Autowired
    private JDBCLicenceRepository jdbcLicenceRepository;

    public LicenceController(JDBCLicenceRepository jdbcLicenceRepository) {
        this.jdbcLicenceRepository = jdbcLicenceRepository;
    }

    @PostMapping(value = "/insertLicence")
    public @ResponseBody String insert(@RequestBody String destinationInfo){

        Gson gson = new Gson();
        Properties properties = gson.fromJson(destinationInfo,Properties.class);
        String dateEnding  = properties.getProperty("date ending");
        String dateAcquired    = properties.getProperty("date acquired");
        String category     = properties.getProperty("category");
        Integer userId                 = Integer.valueOf(properties.getProperty("user Id"));
        Licence licence = new Licence(0, dateEnding,dateAcquired,category,userId);
        jdbcTemplate.update("INSERT INTO `licence` (`licenceId`, `dateEnding`, `dateAcquireq`, `category`, `userId`) VALUES (NULL, ?, ?, ?, ?)",dateEnding,
                dateAcquired,category,userId
        );
        return "records inserted are: " + dateEnding + " " + dateAcquired + " " + category + " " + userId;
    }


    @PostMapping(value = "/deleteLicence")
    public @ResponseBody String delete(@RequestBody String destinationInfo){
        Gson gson = new Gson();
        Properties properties = gson.fromJson(destinationInfo,Properties.class);
        String id = properties.getProperty("Id");
        try{
            jdbcTemplate.update("DELETE FROM licence WHERE licenceid = ?", id);
            return "Item was deleted";
        }
        catch (Exception e){
            return e.toString();
        }
    }

    @PostMapping(value = "/updateLicence")
    public @ResponseBody String update(@RequestBody String destinationInfo){
        Gson gson = new Gson();
        Properties properties = gson.fromJson(destinationInfo,Properties.class);
        String id = properties.getProperty("Id");
        String dateEnding  = properties.getProperty("date ending");
        String dateAcquired    = properties.getProperty("date acquired");
        String category     = properties.getProperty("category");
        Integer userId                 = Integer.valueOf(properties.getProperty("user Id"));
        try {
            jdbcTemplate.update("UPDATE licence SET dateEnding = ?, dateAcquireq = ?, category = ?, userId  = ? WHERE licenceId  = ? ", dateEnding,
                    dateAcquired, category, userId, id
            );
            return "record updated";
        }
        catch(Exception e){
            return e.toString();
        }

    }
    @GetMapping(value = "/allLicence")
    public @ResponseBody List<Licence> findAll(){
        return jdbcLicenceRepository.findAll();
    }
}
