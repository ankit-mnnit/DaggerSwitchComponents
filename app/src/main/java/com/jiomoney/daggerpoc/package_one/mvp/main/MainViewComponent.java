package com.jiomoney.daggerpoc.package_one.mvp.main;

import com.jiomoney.daggerpoc.annotations.ViewScope;
import com.jiomoney.daggerpoc.ui.flows.MainFragment;

import dagger.Subcomponent;

/**
 * Created by AnkitGarg on 07/07/16.
 */
@ViewScope
@Subcomponent(modules = MainViewModule.class)
public interface MainViewComponent {

    void inject(MainFragment mainFragment);
}
