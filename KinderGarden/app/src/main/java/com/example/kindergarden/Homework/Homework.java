package com.example.kindergarden.Homework;

public class Homework {
    private String dataTitle;
    private String dataDesc;
    private String dataChildName;
    private String dataImage;
    private String key;
    public String getKey() {
        return key;
    }
    public void setKey(String key) {
        this.key = key;
    }
    public String getDataTitle() {
        return dataTitle;
    }
    public String getDataDesc() {
        return dataDesc;
    }
    public String dataChildName() {
        return dataChildName;
    }
    public String getDataImage() {
        return dataImage;
    }
    public Homework(String dataTitle, String dataDesc, String dataChildName, String dataImage) {
        this.dataTitle = dataTitle;
        this.dataDesc = dataDesc;
        this.dataChildName = dataChildName;
        this.dataImage = dataImage;
    }
    public Homework(){
    }
}