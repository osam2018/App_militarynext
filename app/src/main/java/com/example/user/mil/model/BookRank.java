package com.example.user.mil.model;

public class BookRank {

    private String userName;
    private int readNum;

    public BookRank() {

    }


    public BookRank(String userName, int readNum) {
        this.userName = userName;
        this.readNum = readNum;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getReadNum() {
        return readNum;
    }

    public void setReadNum(int readNum) {
        this.readNum = readNum;
    }
}
