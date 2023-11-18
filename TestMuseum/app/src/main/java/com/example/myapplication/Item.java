package com.example.myapplication;

public class Item {

    private String Title;
    private String Country;
    private String TimestampCreated;
    private String TimestampUpdate;
    private String ImageLink;
    private String ItemLink;


    public Item(String Title, String Country, String TimestampCreated, String TimestampUpdate, String ImageLink, String ItemLink){
        this.Title = Title;
        this.Country = Country;
        this.TimestampCreated = TimestampCreated;
        this.TimestampUpdate = TimestampUpdate;
        this.ImageLink = ImageLink;
        this.ItemLink = ItemLink;
    }

    public String getTitle() {
        return Title;
    }

    public String getCountry() {
        return Country;
    }

    public String getTimestampCreated() {
        return TimestampCreated;
    }

    public String getTimestampUpdate() {
        return TimestampUpdate;
    }

    public String getItemLink() {
        return ItemLink;
    }

    public String getImageLink() {
        return ImageLink;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public void setCountry(String country) {
        Country = country;
    }

    public void setTimestampCreated(String timestampCreated) {
        TimestampCreated = timestampCreated;
    }

    public void setTimestampUpdate(String  timestampUpdate) {
        TimestampUpdate = timestampUpdate;
    }

    public void setItemLink(String itemLink) {
        ItemLink = itemLink;
    }

    public void setImageLink(String imageLink) {
        ImageLink = imageLink;
    }
}

//https://www.geeksforgeeks.org/how-to-extract-data-from-json-array-in-android-using-volley-library/