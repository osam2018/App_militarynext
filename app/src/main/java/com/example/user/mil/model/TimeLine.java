package com.example.user.mil.model;

public class TimeLine {

    private String id;
    private String title;
    private String description;
    private String nickName;
    private int seeNum;
    private int likedNum;

    public TimeLine(String id, String title, String description, String nickName, int seeNum, int likedNum) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.nickName = nickName;
        this.seeNum = seeNum;
        this.likedNum = likedNum;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public int getSeeNum() {
        return seeNum;
    }

    public void setSeeNum(int seeNum) {
        this.seeNum = seeNum;
    }

    public int getLikedNum() {
        return likedNum;
    }

    public void setLikedNum(int likedNum) {
        this.likedNum = likedNum;
    }


}
