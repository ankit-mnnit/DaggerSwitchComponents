package com.jiomoney.daggerpoc.package_one.mvp.main;

import com.jiomoney.daggerpoc.annotations.ViewScope;
import com.jiomoney.daggerpoc.package_one.usecase.GeocodeUsecase;
import com.jiomoney.daggerpoc.ui.flows.mvp.MainPresenter;
import com.jiomoney.daggerpoc.ui.flows.mvp.MainPresenterImpl;

import dagger.Module;
import dagger.Provides;

/**
 * Created by AnkitGarg on 07/07/16.
 */
@Module
public class MainViewModule {

    @Provides
    @ViewScope
    public MainPresenter getMainPresenter(GeocodeUsecase geocodeUsecase) {
        return new MainPresenterImpl(geocodeUsecase);
    }
}
