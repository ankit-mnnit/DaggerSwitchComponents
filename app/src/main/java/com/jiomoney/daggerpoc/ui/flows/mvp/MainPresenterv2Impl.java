package com.jiomoney.daggerpoc.ui.flows.mvp;

import com.jiomoney.daggerpoc.error.AppException;
import com.jiomoney.daggerpoc.model.UserAddress;
import com.jiomoney.daggerpoc.package_one.UsecaseSubscriber;
import com.jiomoney.daggerpoc.package_two.geocode.GeocodeAddresses;
import com.jiomoney.daggerpoc.package_two.usecase.GeocodeUsecasev2;

import rx.Subscription;
import rx.schedulers.Schedulers;
import rx.subscriptions.CompositeSubscription;
import timber.log.Timber;

/**
 * Created by AnkitGarg on 08/07/16.
 */
public class MainPresenterv2Impl implements MainPresenter {

    private MainView view;
    private GeocodeUsecasev2 usecase;
    private CompositeSubscription compositeSubscription;

    public MainPresenterv2Impl(GeocodeUsecasev2 usecase) {
        this.usecase = usecase;
        this.compositeSubscription = new CompositeSubscription();
    }

    @Override
    public void getUserAddress(double latitude, double longitude) {
        Timber.d("through maps.google.com");
        String latlng = latitude + "," + longitude;
        Subscription subscription = usecase.getAddressDetails(latlng)
                .subscribeOn(Schedulers.newThread())
                .observeOn(view.getUiScheduler())
                .subscribe(new UsecaseSubscriber<GeocodeAddresses>() {
                    @Override
                    public void onResult(GeocodeAddresses geocodeAddresses) {
                        geocodeAddresses.processAddress();
                        String addressLine1 = geocodeAddresses.getAddressLine1();
                        String addressLine2 = geocodeAddresses.getAddressLine2();
                        String state = geocodeAddresses.getState();
                        String city = geocodeAddresses.getCity();
                        String postalCode = geocodeAddresses.getPostalCode();

                        UserAddress userAddress = new UserAddress(
                                addressLine1,
                                addressLine2,
                                city,
                                state,
                                postalCode,
                                "maps.google.com"
                        );

                        view.displayResult(userAddress);
                    }

                    @Override
                    public void onError(AppException e) {
                        Timber.e("Exception: " + e.toString());
                        view.displayServerError();
                    }
                });
        compositeSubscription.add(subscription);
    }

    @Override
    public void attachView(MainView view) {
        if (this.view == null) {
            this.view = view;
        }
    }

    @Override
    public void detachView() {
        this.view = null;
        if (compositeSubscription != null) {
            compositeSubscription.clear();
        }
    }
}
