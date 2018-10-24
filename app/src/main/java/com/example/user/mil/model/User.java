package com.example.user.mil.model;

public class User {

    private String milNumber;
    private String password;
    private String name;
    private String grade;
    private String troopName;
    private int bookNum;

    public User() {

    }

    public User(String milNumber, String password, String name, String grade, String troopName, int bookNum) {
        this.milNumber = milNumber;
        this.password = password;
        this.name = name;
        this.grade = grade;
        this.troopName = troopName;
        this.bookNum = bookNum;
    }

    public String getMilNumber() {
        return milNumber;
    }

    public void setMilNumber(String milNumber) {
        this.milNumber = milNumber;
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

    public String getTroopName() {
        return troopName;
    }

    public void setTroopName(String troopName) {
        this.troopName = troopName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getBookNum() {
        return bookNum;
    }

    public void setBookNum(int bookNum) {
        this.bookNum = bookNum;
    }
}
