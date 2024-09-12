package com.example.carapp;
public class CarModel {
    private String name;
    private String shortDescription;
    private String fullDescription;
    private String imgUrl;
    private boolean isExpanded;


    public CarModel(String name, String shortDescription, String fullDescription, String imgUrl) {
        this.name = name;
        this.shortDescription = shortDescription;
        this.fullDescription = fullDescription;
        this.imgUrl = imgUrl;
        this.isExpanded = false;
    }

    public String getName() {
        return name;
    }

    public String getShortDescription() {
        return shortDescription;
    }

    public String getFullDescription() {
        return fullDescription;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public boolean isExpanded() {
        return isExpanded;
    }

    public void setExpanded(boolean expanded) {
        isExpanded = expanded;
    }
}
