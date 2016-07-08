package com.jiomoney.daggerpoc.ui.flows.mvp;

import com.jiomoney.daggerpoc.core.View;
import com.jiomoney.daggerpoc.model.UserAddress;

/**
 * Created by AnkitGarg on 07/07/16.
 */
public interface MainView extends View {

    void displayResult(UserAddress userAddress);

}
