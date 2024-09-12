package com.example.carapp;

public class CarBrand {
    private String name;
    private String logoUrl;
    private String description;

    public CarBrand(String name, String logoUrl, String description) {
        this.name = name;
        this.logoUrl = logoUrl;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public String getLogoUrl() {
        return logoUrl;
    }

    public String getDescription() {
        return description;
    }
}
