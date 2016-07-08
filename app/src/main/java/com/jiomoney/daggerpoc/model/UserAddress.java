package com.jiomoney.daggerpoc.model;

import java.io.Serializable;

/**
 * Created by AnkitGarg on 07/07/16.
 */
public class UserAddress implements Serializable {

    private StringBuilder addressLine1 = new StringBuilder();
    private StringBuilder addressLine2 = new StringBuilder();
    private StringBuilder city = new StringBuilder();
    private StringBuilder state = new StringBuilder();
    private StringBuilder postalCode = new StringBuilder();
    private String locationThrough = "";

    public UserAddress(String addressLine1, String addressLine2, String city, String state, String postalCode, String locationThrough) {
        this.addressLine1.append(addressLine1);
        this.addressLine2.append(addressLine2);
        this.city.append(city);
        this.state.append(state);
        this.postalCode.append(postalCode);
        this.locationThrough = locationThrough;
    }

    public String getAddressLine1() {
        return addressLine1.toString();
    }

    public String getAddressLine2() {
        return addressLine2.toString();
    }

    public String getCity() {
        return city.toString();
    }

    public String getState() {
        return state.toString();
    }

    public String getPostalCode() {
        return postalCode.toString();
    }

    public String getLocationThrough() {
        return locationThrough;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("UserAddress{");
        sb.append("addressLine1=").append(addressLine1);
        sb.append(", addressLine2=").append(addressLine2);
        sb.append(", city=").append(city);
        sb.append(", state=").append(state);
        sb.append(", postalCode=").append(postalCode);
        sb.append(", locationThrough='").append(locationThrough).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
