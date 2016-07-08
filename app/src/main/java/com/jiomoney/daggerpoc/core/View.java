package com.jiomoney.daggerpoc.core;

import rx.Scheduler;

/**
 * Created by AnkitGarg on 07/07/16.
 */
public interface View {

    Scheduler getUiScheduler();

    void displayLoading();

    void displayServerError();

    void displayNetworkError();

    void displaySocketError();

}
