package com.example.user.mil.model;

public class Book {

    private String id;
    private String name;
    private String imageUrl;
    private String webUrl;
    private String author;
    private int popularity;

    public Book() {

    }

    public Book(String id, String name, String imageUrl, String webUrl, String author, int popularity) {
        this.id = id;
        this.name = name;
        this.imageUrl = imageUrl;
        this.webUrl = webUrl;
        this.author = author;
        this.popularity = popularity;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getWebUrl() {
        return webUrl;
    }

    public void setWebUrl(String webUrl) {
        this.webUrl = webUrl;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getPopularity() {
        return popularity;
    }

    public void setPopularity(int popularity) {
        this.popularity = popularity;
    }
}
