package com.jiomoney.daggerpoc.package_one.api;


import android.location.Address;

import com.jiomoney.daggerpoc.model.UserAddress;
import com.jiomoney.daggerpoc.package_two.geocode.GeocodeAddresses;

import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by AnkitGarg on 07/07/16.
 */
public interface GeocoderApi {

    Observable<Address> getGeocode(double latitude, double longitude);

}
