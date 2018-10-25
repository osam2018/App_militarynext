package com.example.user.mil.model;

public class TimeLine {

    private String id;
    private String title;
    private String description;
    private String userid;
    private int seeNum;
    private int reviewNum;

    public TimeLine(String id, String title, String description, String userid, int seeNum, int reviewNum) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.userid = userid;
        this.seeNum = seeNum;
        this.reviewNum = reviewNum;
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

    public int getSeeNum() {
        return seeNum;
    }

    public void setSeeNum(int seeNum) {
        this.seeNum = seeNum;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public int getReviewNum() {
        return reviewNum;
    }

    public void setReviewNum(int reviewNum) {
        this.reviewNum = reviewNum;
    }
}
