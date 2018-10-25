package com.example.user.mil.model;

public class CommonProduct {

    private String id;
    private String imageLink;
    private String name;
    private String brand;
    private int price;
    private int salePercent;
    private int buyNum;
    private String webLink;

    public CommonProduct() {

    }



    public CommonProduct(String id, String imageLink, String name, String brand, int price, int salePercent, int buyNum, String webLink) {
        this.id = id;
        this.imageLink = imageLink;
        this.name = name;
        this.brand = brand;
        this.price = price;
        this.salePercent = salePercent;
        this.buyNum = buyNum;
        this.webLink = webLink;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getImageLink() {
        return imageLink;
    }

    public void setImageLink(String imageLink) {
        this.imageLink = imageLink;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getWebLink() {
        return webLink;
    }

    public void setWebLink(String webLink) {
        this.webLink = webLink;
    }

    public int getBuyNum() {
        return buyNum;
    }

    public void setBuyNum(int buyNum) {
        this.buyNum = buyNum;
    }

    public int getSalePercent() {
        return salePercent;
    }

    public void setSalePercent(int salePercent) {
        this.salePercent = salePercent;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }
}
