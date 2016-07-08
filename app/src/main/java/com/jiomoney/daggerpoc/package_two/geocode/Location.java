package com.jiomoney.daggerpoc.package_two.geocode;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by AnkitGarg on 30/06/16.
 */
public class Location implements Serializable {
    public static final long serialVersionUID = 15L;

    @SerializedName("lat")
    private double latitude;

    @SerializedName("lng")
    private double longitude;

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Location{");
        sb.append("latitude=").append(latitude);
        sb.append(", longitude=").append(longitude);
        sb.append('}');
        return sb.toString();
    }
}
