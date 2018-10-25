package com.example.user.mil.model;

public class Notice {

    private String id;
    private String title;
    private String webLink;

    public Notice() {

    }

    public Notice(String id, String title, String webLink) {
        this.id = id;
        this.title = title;
        this.webLink = webLink;

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

    public String getWebLink() {
        return webLink;
    }

    public void setWebLink(String webLink) {
        this.webLink = webLink;
    }


}
