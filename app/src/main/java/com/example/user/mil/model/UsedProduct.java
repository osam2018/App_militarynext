package com.example.user.mil.model;

public class UsedProduct {

    private String id;
    private String name;
    private String imageLink;
    private String description;
    private int price;
    private int seeCount;
    private int likedCount;
    private String milNumber;

    public UsedProduct(String id, String name, String imageLink, String description, int price, int seeCount, int likedCount, String milNumber) {
        this.id = id;
        this.name = name;
        this.imageLink = imageLink;
        this.description = description;
        this.price = price;
        this.seeCount = seeCount;
        this.likedCount = likedCount;
        this.milNumber = milNumber;
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

    public String getImageLink() {
        return imageLink;
    }

    public void setImageLink(String imageLink) {
        this.imageLink = imageLink;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getSeeCount() {
        return seeCount;
    }

    public void setSeeCount(int seeCount) {
        this.seeCount = seeCount;
    }

    public int getLikedCount() {
        return likedCount;
    }

    public void setLikedCount(int likedCount) {
        this.likedCount = likedCount;
    }

    public String getMilNumber() {
        return milNumber;
    }

    public void setMilNumber(String milNumber) {
        this.milNumber = milNumber;
    }
}
