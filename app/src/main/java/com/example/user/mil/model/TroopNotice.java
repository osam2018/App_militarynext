package com.example.user.mil.model;

public class TroopNotice {
    private String id;
    private String title;
    private boolean isDeleted;

    public TroopNotice() {

    }

    public TroopNotice(String id, String title, boolean isDeleted) {
        this.id = id;
        this.title = title;
        this.isDeleted = isDeleted;
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

    public boolean isDeleted() {
        return isDeleted;
    }

    public void setDeleted(boolean deleted) {
        isDeleted = deleted;
    }
}
