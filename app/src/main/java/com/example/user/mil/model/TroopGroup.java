package com.example.user.mil.model;

public class TroopGroup {

    private int currentNum;
    private int maxNum;
    private String groupName;
    private String groupOwner;
    private String groupContent;

    public TroopGroup() {

    }

    public TroopGroup(int currentNum, int maxNum, String groupName, String groupOwner, String groupContent) {
        this.currentNum = currentNum;
        this.maxNum = maxNum;
        this.groupName = groupName;
        this.groupOwner = groupOwner;
        this.groupContent = groupContent;
    }

    public int getCurrentNum() {
        return currentNum;
    }

    public void setCurrentNum(int currentNum) {
        this.currentNum = currentNum;
    }

    public int getMaxNum() {
        return maxNum;
    }

    public void setMaxNum(int maxNum) {
        this.maxNum = maxNum;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public String getGroupOwner() {
        return groupOwner;
    }

    public void setGroupOwner(String groupOwner) {
        this.groupOwner = groupOwner;
    }

    public String getGroupContent() {
        return groupContent;
    }

    public void setGroupContent(String groupContent) {
        this.groupContent = groupContent;
    }
}
