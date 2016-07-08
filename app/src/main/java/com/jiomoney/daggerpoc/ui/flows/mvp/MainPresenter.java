package com.jiomoney.daggerpoc.ui.flows.mvp;

import com.jiomoney.daggerpoc.core.Presenter;

/**
 * Created by AnkitGarg on 07/07/16.
 */
public interface MainPresenter extends Presenter<MainView> {

    void getUserAddress(double latitude, double longitude);

}
