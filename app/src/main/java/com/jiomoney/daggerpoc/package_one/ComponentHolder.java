package com.jiomoney.daggerpoc.package_one;

import android.content.Context;

import com.jiomoney.daggerpoc.package_one.mvp.main.MainViewComponent;
import com.jiomoney.daggerpoc.package_two.AppComponentv2;

/**
 * Created by AnkitGarg on 07/07/16.
 */
public class ComponentHolder {
    private AppComponent appComponent;
    private AppComponentv2 appComponentv2;
    private MainViewComponent mainViewComponent;

    public ComponentHolder(AppComponentv2 componentv2) {
        if (componentv2 == null) {
            throw new IllegalStateException("App component v2 must not be null");
        }
        this.appComponentv2 = componentv2;
    }

    public ComponentHolder(AppComponent component) {
        if (component == null) {
            throw new IllegalStateException("App component cannot be null");
        }

        this.appComponent = component;
    }

    public AppComponentv2 appComponentv2() {
        if (appComponentv2 == null) {
            throw new IllegalStateException("App component v2 cannot be null");
        }

        return appComponentv2;
    }

    public AppComponent appComponent() {
        if (appComponent == null) {
            throw new IllegalStateException("App component cannot be null");
        }

        return appComponent;
    }

    public MainViewComponent initMainViewComponent() {
        if (mainViewComponent == null) {
            Context context = appComponent.appContext();
        }

        return mainViewComponent;
    }
}
