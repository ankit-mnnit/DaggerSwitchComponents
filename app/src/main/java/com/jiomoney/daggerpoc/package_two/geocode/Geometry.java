package com.jiomoney.daggerpoc.package_two.geocode;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by AnkitGarg on 30/06/16.
 */
public class Geometry implements Serializable {
    public static final long serialVersionUID = 13L;

    @SerializedName("location_type")
    private String locationType;

    @SerializedName("location")
    private Location location;

    @SerializedName("viewport")
    private ViewPort viewPort;

    public ViewPort getViewPort() {
        return viewPort;
    }

    public void setViewPort(ViewPort viewPort) {
        this.viewPort = viewPort;
    }

    public String getLocationType() {
        return locationType;
    }

    public void setLocationType(String locationType) {
        this.locationType = locationType;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Geometry{");
        sb.append("locationType='").append(locationType).append('\'');
        sb.append(", location=").append(location);
        sb.append(", viewPort=").append(viewPort);
        sb.append('}');
        return sb.toString();
    }
}
