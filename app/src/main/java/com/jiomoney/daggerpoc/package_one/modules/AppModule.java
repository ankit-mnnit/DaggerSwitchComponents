package com.jiomoney.daggerpoc.package_one.modules;

import android.content.Context;

import com.jiomoney.daggerpoc.ApplicationController;
import com.jiomoney.daggerpoc.annotations.ApplicationScope;

import dagger.Module;
import dagger.Provides;

/**
 * Created by AnkitGarg on 07/07/16.
 */
@Module
public class AppModule {

    private ApplicationController app;

    public AppModule(ApplicationController app) {
        this.app = app;
    }

    @Provides
    @ApplicationScope
    public Context provideApplicationContext() {
        return app;
    }

    @Provides
    @ApplicationScope
    public ApplicationController provideApplication() {
        return app;
    }


}
