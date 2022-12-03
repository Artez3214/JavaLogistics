package com.example.kursinis.webControllers;

import com.example.kursinis.model.Comment;
import com.example.kursinis.model.CreatedForum;
import com.example.kursinis.utils.JDBCCommentRepository;
import com.example.kursinis.utils.JDBCCreatedForumRepository;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Properties;
@RestController
public class CreatedForumController {
    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Autowired
    private JDBCCreatedForumRepository jdbcCreatedForumRepository;

    public CreatedForumController(JDBCCreatedForumRepository jdbcCreatedForumRepository) {
        this.jdbcCreatedForumRepository = jdbcCreatedForumRepository;
    }

    @PostMapping(value = "/insertForum")
    public @ResponseBody String insert(@RequestBody String forumInfo){
        Gson gson = new Gson();
        Properties properties = gson.fromJson(forumInfo,Properties.class);
        String forumTopic = properties.getProperty("forumTopic");
        Integer userId = Integer.valueOf(properties.getProperty("user Id"));
        CreatedForum createdForum = new CreatedForum(0,forumTopic,userId);
        jdbcTemplate.update("INSERT INTO forum (forumId,forumTopic,userId) VALUES (null,?,?)",forumTopic,userId);
        return "records inserted are: " + forumTopic + " " + userId;
    }

    @PostMapping(value = "/deleteForum")
    public @ResponseBody String delete(@RequestBody String forumInfo){
        Gson gson = new Gson();
        Properties properties = gson.fromJson(forumInfo,Properties.class);
        String forumId = properties.getProperty("forumId");
        try{
            jdbcTemplate.update("DELETE FROM forum WHERE commentId = ?", forumId);
            return "Item was deleted";
        }
        catch (Exception e){
            return e.toString();
        }
    }

    @PostMapping(value = "/updateForum")
    public @ResponseBody String update(@RequestBody String commentInfo){
        Gson gson = new Gson();
        Properties properties = gson.fromJson(commentInfo,Properties.class);
        String forumId = properties.getProperty("forumId");
        String forumTopic = properties.getProperty("forumTopic");
        Integer userId = Integer.valueOf(properties.getProperty("user Id"));
        try {
            jdbcTemplate.update("UPDATE forum SET text = ?, forumId = ? WHERE commentId = ? ", forumTopic,
                    userId, forumId
            );
            return "record updated";
        }
        catch(Exception e){
            return e.toString();
        }
    }
    @GetMapping(value = "/allForum")
    public @ResponseBody List<CreatedForum> findAll(){
        return jdbcCreatedForumRepository.findAll();
    }
    /*


   */
}
