package com.example.user.mil.model;

public class Comment {

    private String id;
    private String userName;
    private String description;

    public Comment() {

    }

    public Comment(String id, String userName, String description) {
        this.id = id;
        this.userName = userName;
        this.description = description;
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
