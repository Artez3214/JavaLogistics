package com.example.kursinis.model;

import java.io.Serializable;

public class Comment implements Serializable {
    private int commentId;
    private String text;

    public Comment(int commentId, String text) {
        this.commentId = commentId;
        this.text = text;
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
}
