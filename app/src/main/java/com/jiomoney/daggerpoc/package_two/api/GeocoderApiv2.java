package com.jiomoney.daggerpoc.package_two.api;

import com.jiomoney.daggerpoc.package_two.geocode.GeocodeAddresses;

import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by AnkitGarg on 07/07/16.
 */
public interface GeocoderApiv2 {

    @GET("/maps/api/geocode/json?sensor=true")
    Observable<GeocodeAddresses> getGeocodeAddress(
            @Query("latlng") String latlng);

}
