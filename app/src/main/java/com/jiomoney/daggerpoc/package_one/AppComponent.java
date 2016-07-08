package com.jiomoney.daggerpoc.package_one;

import android.content.Context;

import com.jiomoney.daggerpoc.annotations.ApplicationScope;
import com.jiomoney.daggerpoc.package_one.modules.AppModule;
import com.jiomoney.daggerpoc.package_one.modules.DomainApiModule;
import com.jiomoney.daggerpoc.package_one.mvp.main.MainViewComponent;
import com.jiomoney.daggerpoc.package_one.mvp.main.MainViewModule;

import dagger.Component;

/**
 * Created by AnkitGarg on 07/07/16.
 */
@ApplicationScope
@Component(modules = {AppModule.class, DomainApiModule.class})
public interface AppComponent {

    Context appContext();

    MainViewComponent plus(MainViewModule viewModule);

}
