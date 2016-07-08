package com.jiomoney.daggerpoc.package_two.geocode;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

/**
 * Created by AnkitGarg on 30/06/16.
 */
public class Address implements Serializable {
    public static final long serialVersionUID = 17L;

    @SerializedName("long_name")
    private String longName;

    @SerializedName("short_name")
    private String shortName;

    @SerializedName("types")
    private List<String> types;

    public String getLongName() {
        return longName;
    }

    public void setLongName(String longName) {
        this.longName = longName;
    }

    public String getShortName() {
        return shortName;
    }

    public void setShortName(String shortName) {
        this.shortName = shortName;
    }

    public List<String> getTypes() {
        return types;
    }

    public void setTypes(List<String> types) {
        this.types = types;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Address{");
        sb.append("longName='").append(longName).append('\'');
        sb.append(", shortName='").append(shortName).append('\'');
        sb.append(", types=").append(types);
        sb.append('}');
        return sb.toString();
    }
}
