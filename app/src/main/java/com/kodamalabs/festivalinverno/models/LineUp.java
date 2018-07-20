package com.kodamalabs.festivalinverno.models;

public class LineUp {

  private int id;

  private String time;

  private Band band;

  public LineUp(int id, String time, Band band) {
    this.id = id;
    this.time = time;
    this.band = band;
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

  public Band getBand() {
    return band;
  }

  public void setBand(Band band) {
    this.band = band;
  }
}
