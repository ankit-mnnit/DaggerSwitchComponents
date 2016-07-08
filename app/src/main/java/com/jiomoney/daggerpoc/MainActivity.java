package com.jiomoney.daggerpoc;

import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.jiomoney.daggerpoc.ui.flows.MainFragment;

import timber.log.Timber;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.add(R.id.mainContainer, new MainFragment(), "main");
        int commitid = ft.commit();
        Timber.e("fragment commit id: %d", commitid);
    }
}
