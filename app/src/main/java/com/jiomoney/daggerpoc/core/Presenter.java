package com.jiomoney.daggerpoc.core;

/**
 * Created by AnkitGarg on 07/07/16.
 */
public interface Presenter<V extends View> {

    void attachView(V view);

    void detachView();

}
