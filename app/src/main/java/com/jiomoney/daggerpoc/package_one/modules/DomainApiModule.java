package com.jiomoney.daggerpoc.package_one.modules;

import com.jiomoney.daggerpoc.ApplicationController;
import com.jiomoney.daggerpoc.annotations.ApplicationScope;
import com.jiomoney.daggerpoc.package_one.api.GeocoderApi;
import com.jiomoney.daggerpoc.package_one.impl.GeocoderApiImpl;


import dagger.Module;
import dagger.Provides;

/**
 * Created by AnkitGarg on 07/07/16.
 */
@Module
public class DomainApiModule {

    @Provides
    @ApplicationScope
    public GeocoderApi getGeocoderApi(ApplicationController applicationController) {
        return new GeocoderApiImpl(applicationController);
    }

}
