package com.example.user.mil.model;

public class Review {

    private String id;
    private float startRate;
    private String bookName;
    private String description;

    public Review(String id, float startRate, String bookName, String description) {

        this.id = id;
        this.startRate = startRate;
        this.bookName = bookName;
        this.description = description;
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public float getStartRate() {
        return startRate;
    }

    public void setStartRate(float startRate) {
        this.startRate = startRate;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
