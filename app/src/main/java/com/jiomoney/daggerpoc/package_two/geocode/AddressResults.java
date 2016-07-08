package com.jiomoney.daggerpoc.package_two.geocode;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

/**
 * Created by AnkitGarg on 30/06/16.
 */
public class AddressResults implements Serializable {

    public static final long serialVersionUID = 12L;

    @SerializedName("address_components")
    private List<Address> addresses;

    @SerializedName("formatted_address")
    private String formattedAddress;

    @SerializedName("geometry")
    private Geometry geometry;

    @SerializedName("place_id")
    private String placeId;

    @SerializedName("types")
    private List<String> types;


    public List<Address> getAddresses() {
        return addresses;
    }

    public void setAddresses(List<Address> addresses) {
        this.addresses = addresses;
    }

    public String getFormattedAddress() {
        return formattedAddress;
    }

    public void setFormattedAddress(String formattedAddress) {
        this.formattedAddress = formattedAddress;
    }

    public Geometry getGeometry() {
        return geometry;
    }

    public void setGeometry(Geometry geometry) {
        this.geometry = geometry;
    }

    public String getPlaceId() {
        return placeId;
    }

    public void setPlaceId(String placeId) {
        this.placeId = placeId;
    }

    public List<String> getTypes() {
        return types;
    }

    public void setTypes(List<String> types) {
        this.types = types;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("AddressResults{");
        sb.append("addresses=").append(addresses);
        sb.append(", formattedAddress='").append(formattedAddress).append('\'');
        sb.append(", geometry=").append(geometry);
        sb.append(", placeId='").append(placeId).append('\'');
        sb.append(", types=").append(types);
        sb.append('}');
        return sb.toString();
    }
}
