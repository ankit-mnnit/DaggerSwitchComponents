package com.jiomoney.daggerpoc.package_two.mvp.main;

import com.jiomoney.daggerpoc.annotations.UserScope;
import com.jiomoney.daggerpoc.package_two.modules.AppModulev2;
import com.jiomoney.daggerpoc.package_two.modules.DomainApiModulev2;
import com.jiomoney.daggerpoc.package_two.modules.NetModulev2;
import com.jiomoney.daggerpoc.ui.flows.MainFragment;

import dagger.Component;
import dagger.Subcomponent;

/**
 * Created by AnkitGarg on 07/07/16.
 */
@UserScope
@Subcomponent(modules = {MainViewModulev2.class})
public interface MainViewComponentv2 {

    void inject(MainFragment fragment);
}
