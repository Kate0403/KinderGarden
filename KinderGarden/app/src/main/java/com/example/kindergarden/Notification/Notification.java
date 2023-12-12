package com.example.kindergarden.Notification;

public class Notification {
    private String Title;
    private String Description;
    private String Date;
    private String key;

    public Notification(String title, String description, String date) {
        Title = title;
        Description = description;
        Date = date;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public String getDate() {
        return Date;
    }

    public void setDate(String date) {
        Date = date;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public Notification(){

    }
}
