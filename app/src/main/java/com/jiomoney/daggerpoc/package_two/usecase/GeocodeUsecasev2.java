package com.jiomoney.daggerpoc.package_two.usecase;

import com.jiomoney.daggerpoc.package_two.api.GeocoderApiv2;
import com.jiomoney.daggerpoc.package_two.geocode.GeocodeAddresses;

import javax.inject.Inject;

import rx.Observable;
import timber.log.Timber;

/**
 * Created by AnkitGarg on 07/07/16.
 */
public class GeocodeUsecasev2 {

    private GeocoderApiv2 api;

    @Inject
    public GeocodeUsecasev2(GeocoderApiv2 api) {
        this.api = api;
    }

    public Observable<GeocodeAddresses> getAddressDetails(String latlng) {
        return api.getGeocodeAddress(latlng);
    }
}
