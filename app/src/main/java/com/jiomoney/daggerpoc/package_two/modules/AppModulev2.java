package com.jiomoney.daggerpoc.package_two.modules;

import android.content.Context;

import com.jiomoney.daggerpoc.ApplicationController;
import com.jiomoney.daggerpoc.annotations.ApplicationScope;
import com.jiomoney.daggerpoc.annotations.ViewScope;
import com.jiomoney.daggerpoc.package_one.usecase.GeocodeUsecase;
import com.jiomoney.daggerpoc.ui.flows.mvp.MainPresenter;
import com.jiomoney.daggerpoc.ui.flows.mvp.MainPresenterImpl;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by AnkitGarg on 07/07/16.
 */
@Module
public class AppModulev2 {

    private ApplicationController app;

    public AppModulev2(ApplicationController app) {
        this.app = app;
    }

    @Provides
    @Singleton
    public Context provideApplicationContext() {
        return app;
    }

    @Provides
    @Singleton
    public ApplicationController provideApplication() {
        return app;
    }

}
