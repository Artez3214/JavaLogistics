package com.example.kursinis.webControllers;

import com.example.kursinis.model.Driver;
import com.example.kursinis.model.User;
import com.example.kursinis.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

 /*   @Autowired
    private UserRepository userRepository;

    public UserController(UserRepository userRepository){
        this.userRepository = userRepository;
    }
*/
  /*   @GetMapping(value = "/allUsers")
    public @ResponseBody Iterable<User> getAllUsers(){
        return userRepository.findAll();
    }*/

    @GetMapping(value = "/")
    public String HI(){
        return "hi";
    }
}
