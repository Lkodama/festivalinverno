package com.kodamalabs.festivalinverno.models;

import android.os.Parcel;
import android.os.Parcelable;

public class FoodTruck implements Parcelable{

    private String name;

    private String description;

    private String imageUrl;

    public FoodTruck(String name, String description, String imageUrl) {
        this.name = name;
        this.description = description;
        this.imageUrl = imageUrl;
    }

    public FoodTruck(Parcel parcel){
        this.name = parcel.readString();
        this.description = parcel.readString();
        this.imageUrl = parcel.readString();
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

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(name);
        parcel.writeString(description);
        parcel.writeString(imageUrl);
    }

    public static final Parcelable.Creator<FoodTruck> CREATOR = new
            Parcelable.Creator<FoodTruck>() {
                public FoodTruck createFromParcel(Parcel in) {
                    return new FoodTruck(in);
                }

                public FoodTruck[] newArray(int size) {
                    return new FoodTruck[size];
                }};
}
