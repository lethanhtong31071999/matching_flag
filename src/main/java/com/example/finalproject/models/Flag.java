package com.example.finalproject.models;

public class Flag {
    private String name;
    private String imageUrl;
    private String continent;

    public Flag(String name, String imageUrl, String continent) {
        this.name = name;
        this.imageUrl = imageUrl;
        this.continent = continent;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getContinent() {
        return continent;
    }

    public void setContinent(String continent) {
        this.continent = continent;
    }
}
