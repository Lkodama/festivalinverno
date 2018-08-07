package com.kodamalabs.festivalinverno.models;

public class LineUp {

  private int id;

  private String time;

  private String band;

  private String description;

  private String imgUrl;

  public LineUp(int id, String time, String band, String description, String imgUrl) {
    this.id = id;
    this.time = time;
    this.band = band;
    this.description = description;
    this.imgUrl = imgUrl;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getTime() {
    return time;
  }

  public void setTime(String time) {
    this.time = time;
  }

  public String getBand() {
    return band;
  }

  public void setBand(String band) {
    this.band = band;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public String getImgUrl() {
    return imgUrl;
  }

  public void setImgUrl(String imgUrl) {
    this.imgUrl = imgUrl;
  }
}
