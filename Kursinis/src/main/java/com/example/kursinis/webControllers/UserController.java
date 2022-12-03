package com.example.kursinis.webControllers;

import com.example.kursinis.model.Driver;
import com.example.kursinis.model.User;
import com.example.kursinis.repository.UserRepository;
import com.example.kursinis.utils.JDBCUserRepository;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Properties;

@RestController
public class UserController {
    @Autowired
    private
    JdbcTemplate jdbcTemplate;
    @Autowired
    private JDBCUserRepository jdbcUserRepository;

    public UserController(JDBCUserRepository jdbcUserRepository) {
        this.jdbcUserRepository = jdbcUserRepository;
    }

    @PostMapping(value = "/insertUser")
    public @ResponseBody String insert(@RequestBody String userInfo){

        Gson gson = new Gson();
        Properties properties = gson.fromJson(userInfo,Properties.class);
        String name    = properties.getProperty("name");
        String phoneNumber  = properties.getProperty("phone Number");
        String emailAddress  = properties.getProperty("email Address");
        String birthDay  = properties.getProperty("birth Day");
        String username  = properties.getProperty("username");
        String password  = properties.getProperty("password");
        Boolean isRetired  = Boolean.valueOf(properties.getProperty("is Retired"));
        Float salary  = Float.valueOf(properties.getProperty("salary"));
        String currency  = properties.getProperty("currency");
        User user = new User("0", name,phoneNumber,emailAddress,birthDay,username,password,isRetired,salary,currency);
        jdbcTemplate.update("INSERT INTO user (userId, name, phoneNumber, emailAddress, birthDay,username,password,isRetired,salary,currency) VALUES (NULL, ?, ?, ?, ?,?,?,?,?,?)",name,
                phoneNumber,emailAddress,birthDay,username,password,isRetired,salary,currency
        );
        return "records inserted are: " + name + " " + phoneNumber + " " + emailAddress + " " + birthDay + " " + username + " " + password + " " + isRetired + " " + salary + " " + currency;
    }

    @PostMapping(value = "/deleteUser")
    public @ResponseBody String delete(@RequestBody String orderInfo){
        Gson gson = new Gson();
        Properties properties = gson.fromJson(orderInfo,Properties.class);
        Integer userId  = Integer.valueOf(properties.getProperty("user Id"));
        try{
            jdbcTemplate.update("DELETE FROM `user` WHERE userId = ?", userId);
            return "Item was deleted";
        }
        catch (Exception e){
            return e.toString();
        }
    }

    @PostMapping(value = "/updateUser")
    public @ResponseBody String update(@RequestBody String destinationInfo){
        Gson gson = new Gson();
        Properties properties = gson.fromJson(destinationInfo,Properties.class);
        String name    = properties.getProperty("name");
        String phoneNumber  = properties.getProperty("phone Number");
        String emailAddress  = properties.getProperty("email Address");
        String birthDay  = properties.getProperty("birth Day");
        String username  = properties.getProperty("username");
        String password  = properties.getProperty("password");
        Boolean isRetired  = Boolean.valueOf(properties.getProperty("is Retired"));
        Float salary  = Float.valueOf(properties.getProperty("salary"));
        String currency  = properties.getProperty("currency");
        try {
            jdbcTemplate.update(" UPDATE `user` SET `name` = ?, phoneNumber = ?, emailAddress = ?, birthDay = ? , username = ?, password = ?, isRetired = ?, salary = ?, currency= ? WHERE `user`.`userId` = ? ", name,
                    phoneNumber, emailAddress, birthDay, username, password,isRetired,salary,currency
            );
            return "record updated";
        }
        catch(Exception e){
            return e.toString();
        }

    }
    @GetMapping(value = "/allUser")
    public @ResponseBody List<User> findAll(){
        return jdbcUserRepository.findAll();
    }

}
