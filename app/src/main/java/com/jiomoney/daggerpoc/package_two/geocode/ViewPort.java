package com.jiomoney.daggerpoc.package_two.geocode;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by AnkitGarg on 30/06/16.
 */
public class ViewPort implements Serializable {

    public static final long serialVersionUID = 16L;

    @SerializedName("northeast")
    private Location northeast;

    @SerializedName("southwest")
    private Location southwest;

    public Location getNortheast() {
        return northeast;
    }

    public void setNortheast(Location northeast) {
        this.northeast = northeast;
    }

    public Location getSouthwest() {
        return southwest;
    }

    public void setSouthwest(Location southwest) {
        this.southwest = southwest;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("ViewPort{");
        sb.append("northeast=").append(northeast);
        sb.append(", southwest=").append(southwest);
        sb.append('}');
        return sb.toString();
    }
}
