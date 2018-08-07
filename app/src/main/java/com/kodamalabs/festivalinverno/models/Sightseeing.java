package com.kodamalabs.festivalinverno.models;

import java.util.List;

/**
 * Created by leonardokodama on 23/07/2018.
 */

public class Sightseeing {

    private String name;

    private String description;

    private String latitude;

    private String longitude;

    private List<String> listImagesUrl;

    public Sightseeing(String name, String description, String latitude, String longitude, List<String> listImagesUrl) {
        this.name = name;
        this.description = description;
        this.latitude = latitude;
        this.longitude = longitude;
        this.listImagesUrl = listImagesUrl;
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

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public List<String> getListImagesUrl() {
        return listImagesUrl;
    }

    public void setListImagesUrl(List<String> listImagesUrl) {
        this.listImagesUrl = listImagesUrl;
    }
}
