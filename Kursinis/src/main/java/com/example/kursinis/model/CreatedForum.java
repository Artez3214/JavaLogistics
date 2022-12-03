package com.example.kursinis.model;

import java.io.Serializable;

public class CreatedForum implements Serializable {
    private int forumId;
    private String forumTopic;

    public CreatedForum(int forumId, String forumTopic, Integer userId) {
        this.forumId = forumId;
        this.forumTopic = forumTopic;
    }

    public int getForumId() {
        return forumId;
    }

    public void setForumId(int forumId) {
        this.forumId = forumId;
    }

    public String getForumTopic() {
        return forumTopic;
    }

    public void setForumTopic(String forumTopic) {
        this.forumTopic = forumTopic;
    }
}
