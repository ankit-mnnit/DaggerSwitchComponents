package com.jiomoney.daggerpoc.ui.flows;

import android.Manifest;
import android.content.DialogInterface;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AlertDialog;

import com.jiomoney.daggerpoc.ApplicationController;
import com.jiomoney.daggerpoc.core.View;
import com.jiomoney.daggerpoc.package_one.ComponentHolder;

import rx.Scheduler;
import rx.android.schedulers.AndroidSchedulers;

/**
 * Created by AnkitGarg on 07/07/16.
 */
public abstract class BaseFragment extends Fragment implements View {

    private static final int REQUEST_LOCATION = 1008;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestForLocationPermission();
    }

    public Scheduler getUiScheduler() {
        return AndroidSchedulers.mainThread();
    }


    public void requestForLocationPermission() {
        final String permission = Manifest.permission.ACCESS_FINE_LOCATION;
        if (ContextCompat.checkSelfPermission(getContext(), permission)
                != PackageManager.PERMISSION_GRANTED) {
            if (ActivityCompat.shouldShowRequestPermissionRationale(getActivity(), permission)) {
                showPermissionRationaleDialog("Location", permission);
            } else {
                requestForPermission(permission);
            }
        } else {
            launch();
        }
    }


    private void showPermissionRationaleDialog(final String message, final String permission) {
        new AlertDialog.Builder(getContext())
                .setMessage(message)
                .setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        requestForPermission(permission);
                    }
                })
                .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                })
                .create()
                .show();
    }


    private void requestForPermission(final String permission) {
        ActivityCompat.requestPermissions(getActivity(), new String[]{permission}, REQUEST_LOCATION);
    }

    public void launch() {
        //Intent startCustomCameraIntent = new Intent(getContext(), CameraActivity.class);
        //startActivityForResult(startCustomCameraIntent, REQUEST_CAMERA_BASE);
    }
}
