package com.jiomoney.daggerpoc.package_one.impl;

import android.location.Address;
import android.location.Geocoder;

import com.jiomoney.daggerpoc.ApplicationController;
import com.jiomoney.daggerpoc.package_one.api.GeocoderApi;

import java.io.IOException;
import java.util.List;
import java.util.Locale;

import rx.Observable;
import rx.Subscriber;
import timber.log.Timber;

/**
 * Created by AnkitGarg on 07/07/16.
 */
public class GeocoderApiImpl implements GeocoderApi {


    private ApplicationController applicationController;

    private Geocoder geocoder;

    public GeocoderApiImpl(ApplicationController applicationController) {
        this.applicationController = applicationController;
    }

    @Override
    public Observable<Address> getGeocode(final double latitude, final double longitude) {
        return Observable.create(new Observable.OnSubscribe<Address>() {
            @Override
            public void call(Subscriber<? super Address> subscriber) {

                geocoder = new Geocoder(applicationController, Locale.ENGLISH);
                try {
                    List<Address> addresses = geocoder.getFromLocation(latitude, longitude, 1);
                    subscriber.onNext(addresses != null ? addresses.get(0) : null);
                    subscriber.onCompleted();

                } catch (IOException e) {
                    Timber.e("Exception: %s", e.getMessage());
                    if (!subscriber.isUnsubscribed()) {
                        subscriber.onError(e);
                    }
                }
            }
        });

    }

}
