package com.kodamalabs.festivalinverno.models;

/**
 * Created by leonardokodama on 23/07/2018.
 */

public class Services {

    private String name;

    private String description;

    private String address;

    private String longitude;

    private String latitude;

    private String imageUrl;

    public Services(String name, String description, String address, String longitude, String latitude, String imageUrl) {
        this.name = name;
        this.description = description;
        this.address = address;
        this.longitude = longitude;
        this.latitude = latitude;
        this.imageUrl = imageUrl;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
}
