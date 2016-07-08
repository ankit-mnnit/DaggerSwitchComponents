package com.jiomoney.daggerpoc.ui.flows;

import android.content.Context;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.widget.TextView;

/**
 * Created by AnkitGarg on 07/07/16.
 */
public class SnackBarFactory {
    public static Snackbar createSnackbar(Context context, View view, String message) {
        Snackbar snackbar = Snackbar.make(view, message, Snackbar.LENGTH_LONG);
        //ViewGroup group = (ViewGroup) snackbar.getView();
        //group.setBackgroundColor(ContextCompat.getColor(context, R.color.primary_light));
        snackbar.show();
        return snackbar;
    }

    public static Snackbar createSnackbarIndefinite(Context context, View view, String message) {
        Snackbar snackbar = Snackbar.make(view, message, Snackbar.LENGTH_INDEFINITE);
        //ViewGroup group = (ViewGroup) snackbar.getView();
        //group.setBackgroundColor(ContextCompat.getColor(context, R.color.primary_light));
        snackbar.show();
        return snackbar;
    }

    public static Snackbar createSnackbarMultiLine(Context context, View view, String message){
        Snackbar snackbar = Snackbar.make(view, message, Snackbar.LENGTH_SHORT);
        TextView snackbarTextView = (TextView) snackbar.getView().findViewById(android.support.design.R.id.snackbar_text);
        snackbarTextView.setMaxLines(999);
        snackbar.show();
        return snackbar;

    }
}
