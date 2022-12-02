package com.example.kursinis.model;

import java.io.Serializable;

public class Comment implements Serializable {
    private int commentId;
    private String text;

    private int forumId;

    public Comment(int commentId, String text, int forumId) {
        this.commentId = commentId;
        this.text = text;
        this.forumId = forumId;
    }

    public int getCommentId() {
        return commentId;
    }

    public void setCommentId(int commentId) {
        this.commentId = commentId;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public int getForumId() {
        return forumId;
    }

    public void setForumId(int forumId) {
        this.forumId = forumId;
    }
}
