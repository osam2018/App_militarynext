package com.example.user.mil.model;

public class User {

    private String milNumber;
    private String included;
    private String name;
    private String grade;
    private String phoneNumber;
    private String photoUrl;

    public User(String milNumber, String included, String name, String grade, String phoneNumber, String photoUrl) {
        this.milNumber = milNumber;
        this.included = included;
        this.name = name;
        this.grade = grade;
        this.phoneNumber = phoneNumber;
        this.photoUrl = photoUrl;
    }

    public String getMilNumber() {
        return milNumber;
    }

    public void setMilNumber(String milNumber) {
        this.milNumber = milNumber;
    }

    public String getIncluded() {
        return included;
    }

    public void setIncluded(String included) {
        this.included = included;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getPhotoUrl() {
        return photoUrl;
    }

    public void setPhotoUrl(String photoUrl) {
        this.photoUrl = photoUrl;
    }
}
