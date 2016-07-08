package com.jiomoney.daggerpoc.package_one;

import com.jiomoney.daggerpoc.core.View;
import com.jiomoney.daggerpoc.error.AppException;

import rx.Subscriber;

/**
 * Created by AnkitGarg on 07/07/16.
 */
public abstract class UsecaseSubscriber<T> extends Subscriber<T> {



    @Override
    public void onCompleted() {

    }

    @Override
    public void onError(Throwable e) {
        onError(new AppException(e));
    }

    @Override
    public void onNext(T t) {
        onResult(t);
    }

    public abstract void onResult(T t);

    public abstract void onError(AppException e);
}
