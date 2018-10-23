package com.example.user.mil.model;

public class UsedProduct {

    private String tile;
    private int price;
    private String category;
    private String imageLink;
    private int seeCount;
    private int likedCount;

    private String userId;
    private String userIncluded;
    private String userName;

    public UsedProduct(String tile, int price, String category, String imageLink, int seeCount, int likedCount, String userId, String userIncluded, String userName) {
        this.tile = tile;
        this.price = price;
        this.category = category;
        this.imageLink = imageLink;
        this.seeCount = seeCount;
        this.likedCount = likedCount;
        this.userId = userId;
        this.userIncluded = userIncluded;
        this.userName= userName;
    }

    public String getTile() {
        return tile;
    }

    public void setTile(String tile) {
        this.tile = tile;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getImageLink() {
        return imageLink;
    }

    public void setImageLink(String imageLink) {
        this.imageLink = imageLink;
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

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserIncluded() {
        return userIncluded;
    }

    public void setUserIncluded(String userIncluded) {
        this.userIncluded = userIncluded;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
