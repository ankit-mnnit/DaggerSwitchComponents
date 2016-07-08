package com.jiomoney.daggerpoc;

import android.app.Application;

import com.jiomoney.daggerpoc.package_one.AppComponent;
import com.jiomoney.daggerpoc.package_one.ComponentHolder;
import com.jiomoney.daggerpoc.package_one.DaggerAppComponent;
import com.jiomoney.daggerpoc.package_one.modules.AppModule;
import com.jiomoney.daggerpoc.package_two.AppComponentv2;
import com.jiomoney.daggerpoc.package_two.DaggerAppComponentv2;
import com.jiomoney.daggerpoc.package_two.modules.AppModulev2;
import com.jiomoney.daggerpoc.package_two.modules.NetModulev2;

import timber.log.Timber;

/**
 * Created by AnkitGarg on 07/07/16.
 */
public class ApplicationController extends Application {

    private static ApplicationController mInstance;
    private static ComponentHolder componentHolder;
    private static AppComponentv2 appComponentv2;
    private static AppComponent appComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        mInstance = this;

        Timber.plant(new Timber.DebugTree());

        initDagger();

    }

    private void initDagger() {



        appComponent = DaggerAppComponent
                .builder()
                .appModule(new AppModule(this))
                .build();

        appComponentv2 = DaggerAppComponentv2
                .builder()
                .appModulev2(new AppModulev2(this))
                .netModulev2(new NetModulev2("http://maps.google.com/"))
                .build();

        //componentHolder = new ComponentHolder(appComponent);


    }

    public static AppComponent getAppComponent() {
        return appComponent;
    }

    public static AppComponentv2 getAppComponentv2() {
        return appComponentv2;
    }

    public static ComponentHolder componentHolder() {
        return componentHolder;
    }
}
