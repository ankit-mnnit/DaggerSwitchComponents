package com.jiomoney.daggerpoc.package_two.geocode;

import com.google.gson.annotations.SerializedName;
import com.jiomoney.daggerpoc.config.Constants;

import java.io.Serializable;
import java.util.List;

/**
 * Created by AnkitGarg on 30/06/16.
 */
public class GeocodeAddresses implements Serializable {
    public static final long serialVersionUID = 10L;

    @SerializedName("results")
    private List<AddressResults> results;

    private StringBuilder addressLine1 = new StringBuilder();
    private StringBuilder addressLine2 = new StringBuilder();
    private StringBuilder city = new StringBuilder();
    private StringBuilder state = new StringBuilder();
    private StringBuilder postalCode = new StringBuilder();

    public List<AddressResults> getResults() {
        return results;
    }

    public void setResults(List<AddressResults> results) {
        this.results = results;
    }

    public void processAddress() {
        if (results == null || results.isEmpty()) {
            throw new IllegalStateException("Geocode results can't be empty for processing");

        } else {
            List<Address> addresses = results.get(0).getAddresses();
            for (int i = 0; i < addresses.size(); ++i) {
                List<String> types = addresses.get(i).getTypes();
                for (int j = 0; j < types.size(); ++j) {

                    // process address line 1
                    if (Constants.GeocodeAddressConstants.PREMISE.equalsIgnoreCase(types.get(j))) {
                        addressLine1.append(addresses.get(i).getLongName());
                        addressLine1.append(", ");
                    }
                    if (Constants.GeocodeAddressConstants.ROUTE.equalsIgnoreCase(types.get(j))) {
                        addressLine1.append(addresses.get(i).getLongName());
                        addressLine1.append(", ");
                    }

                    // process address line 2
                    if (Constants.GeocodeAddressConstants.SUBLOCALITY_LEVEL_1.equalsIgnoreCase(types.get(j))) {
                        addressLine2.append(addresses.get(i).getLongName());
                        addressLine2.append(", ");
                    }
                    if (Constants.GeocodeAddressConstants.SUBLOCALITY_LEVEL_2.equalsIgnoreCase(types.get(j))) {
                        addressLine2.append(addresses.get(i).getLongName());
                        addressLine2.append(", ");

                    }
                    if (Constants.GeocodeAddressConstants.SUBLOCALITY_LEVEL_3.equalsIgnoreCase(types.get(j))) {
                        addressLine2.append(addresses.get(i).getLongName());
                        addressLine2.append(", ");
                    }

                    // process state name
                    if (Constants.GeocodeAddressConstants.ADMINISTRATIVE_LEVEL_1.equalsIgnoreCase(types.get(j))) {
                        state.append(addresses.get(i).getLongName());
                    }

                    // process city name
                    if (Constants.GeocodeAddressConstants.CITY_NAME.equalsIgnoreCase(types.get(j))) {
                        city.append(addresses.get(i).getLongName());
                    }

                    // process pin code
                    if (Constants.GeocodeAddressConstants.POSTAL_CODE.equalsIgnoreCase(types.get(j))) {
                        postalCode.append(addresses.get(i).getLongName());
                    }
                }
            }
        }
    }

    public String getAddressLine1() {
        return addressLine1.toString();
    }

    public String getAddressLine2() {
        return addressLine2.toString();
    }

    public String getState() {
        return state.toString();
    }

    public String getCity() {
        return city.toString();
    }

    public String getPostalCode() {
        return postalCode.toString();
    }


    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("GeocodeAddresses{");
        sb.append("results=").append(results);
        sb.append('}');
        return sb.toString();
    }
}
