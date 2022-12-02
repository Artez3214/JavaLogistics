package com.example.kursinis.webControllers;

import com.example.kursinis.model.Comment;
import com.example.kursinis.utils.JDBCCommentRepository;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Properties;

public class CommentController {


    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Autowired
    private JDBCCommentRepository jdbcCommentRepository;

    public CommentController(JDBCCommentRepository jdbcCommentRepository) {
        this.jdbcCommentRepository = jdbcCommentRepository;
    }
    @PostMapping(value = "/insertComment")
    public @ResponseBody String insert(@RequestBody String commentInfo){
        Gson gson = new Gson();
        Properties properties = gson.fromJson(commentInfo,Properties.class);
        String text = properties.getProperty("text");
        Integer forumId = Integer.valueOf(properties.getProperty("forum Id"));
        Comment comment = new Comment(0,text,forumId);
        jdbcTemplate.update("INSERT INTO comment (commentId,text,forumId) VALUES (null,?,?)",text,forumId);
        return "records inserted are: " + text + " " + forumId;
    }
    @PostMapping(value = "/deleteComment")
    public @ResponseBody String delete(@RequestBody String commentInfo){
        Gson gson = new Gson();
        Properties properties = gson.fromJson(commentInfo,Properties.class);
        String commentId = properties.getProperty("commentId");
        try{
            jdbcTemplate.update("DELETE FROM comment WHERE commentId = ?", commentId);
            return "Item was deleted";
        }
        catch (Exception e){
            return e.toString();
        }
    }
    @PostMapping(value = "/updateComment")
    public @ResponseBody String update(@RequestBody String commentInfo){
        Gson gson = new Gson();
        Properties properties = gson.fromJson(commentInfo,Properties.class);
        String commentId = properties.getProperty("commentId");
        String text = properties.getProperty("text");
        Integer forumId = Integer.valueOf(properties.getProperty("forum Id"));
        try {
            jdbcTemplate.update("UPDATE comment SET text = ?, forumId = ? WHERE commentId = ? ", text,
                    forumId, commentId
            );
            return "record updated";
        }
        catch(Exception e){
            return e.toString();
        }
    }

    @GetMapping(value = "/allCargo")
    public @ResponseBody List<Comment> findAll(){
        return jdbcCommentRepository.findAll();
    }

}
