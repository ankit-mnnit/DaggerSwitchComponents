package com.jiomoney.daggerpoc.ui.flows;

import android.Manifest;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationManager;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.location.LocationListener;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationServices;
import com.jiomoney.daggerpoc.ApplicationController;
import com.jiomoney.daggerpoc.R;
import com.jiomoney.daggerpoc.model.UserAddress;
import com.jiomoney.daggerpoc.package_one.mvp.main.MainViewModule;
import com.jiomoney.daggerpoc.package_two.mvp.main.MainViewModulev2;
import com.jiomoney.daggerpoc.ui.flows.mvp.MainPresenter;
import com.jiomoney.daggerpoc.ui.flows.mvp.MainView;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import timber.log.Timber;

/**
 * Created by AnkitGarg on 07/07/16.
 */
public class MainFragment extends BaseFragment implements MainView, GoogleApiClient.ConnectionCallbacks, LocationListener, GoogleApiClient.OnConnectionFailedListener {

    @Inject
    MainPresenter presenter;

    @BindView(R.id.tvAddressLine1)
    TextView tvAddressLine1;

    @BindView(R.id.tvAddressLine2)
    TextView tvAddressLine2;

    @BindView(R.id.tvCity)
    TextView tvCity;

    @BindView(R.id.tvState)
    TextView tvState;

    @BindView(R.id.tvPostalCode)
    TextView tvPostalCode;

    @BindView(R.id.tvLocationThrough)
    TextView tvLocationThrough;

    private Context mContext;

    int counter = 0;

    private Location mLastLocation;
    private GoogleApiClient mGoogleApiClient;
    private BroadcastReceiver m_gpsChangeReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            Timber.e("providers changed. Intent: " + intent.getFlags());

            final LocationManager manager = (LocationManager) mContext.getSystemService( Context.LOCATION_SERVICE );

            if ( manager.isProviderEnabled( LocationManager.GPS_PROVIDER ) ) {
                isGpsOn = true;
            } else {
                isGpsOn = false;
            }

            Timber.e("gps state : " + isGpsOn);

        }
    };
    private LocationRequest mLocationRequest;

    public static final int MILLISECONDS_PER_SECOND = 700;
    public static final int UPDATE_INTERVAL_IN_SECONDS = 1;
    public static final int FAST_CEILING_IN_SECONDS = 1;

    public static final long UPDATE_INTERVAL_IN_MILLISECONDS = MILLISECONDS_PER_SECOND
            * UPDATE_INTERVAL_IN_SECONDS;

    public static final long FAST_INTERVAL_CEILING_IN_MILLISECONDS = MILLISECONDS_PER_SECOND
            * FAST_CEILING_IN_SECONDS;
    private boolean isGpsOn;
    private boolean userRequestedCurrentLocation;
    private MenuItem menuItem;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mContext = getContext();

        //ApplicationController.getAppComponentv2().plus(new MainViewModulev2()).inject(this);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_main, container, false);

        setHasOptionsMenu(true);
        ButterKnife.bind(this, view);


        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        if (mGoogleApiClient == null) {
            mGoogleApiClient = new GoogleApiClient.Builder(this.getActivity())
                    .addConnectionCallbacks(this)
                    .addOnConnectionFailedListener(this)
                    .addApi(LocationServices.API)
                    .build();
        }

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        presenter.detachView();
    }

    @Override
    public void displayResult(UserAddress userAddress) {
        Timber.e("useraddress: %s", userAddress.toString());
        tvAddressLine1.setText(getResources().getString(R.string.addressLine1, userAddress.getAddressLine1()));
        tvAddressLine2.setText(getResources().getString(R.string.addressLine2, userAddress.getAddressLine2()));
        tvCity.setText(getResources().getString(R.string.city, userAddress.getCity()));
        tvState.setText(getResources().getString(R.string.state, userAddress.getState()));
        tvPostalCode.setText(getResources().getString(R.string.postal_code, userAddress.getPostalCode()));
        tvLocationThrough.setText(getResources().getString(R.string.location_through, userAddress.getLocationThrough()));
    }

    @Override
    public void displayLoading() {

    }

    @Override
    public void displayServerError() {

    }

    @Override
    public void displayNetworkError() {

    }

    @Override
    public void displaySocketError() {

    }

    @Override
    public void onConnected(@Nullable Bundle bundle) {
        Timber.e("google api client connected");
        handleGPSconnectivity();
    }

    private void handleGPSconnectivity() {
        final LocationManager manager = (LocationManager) mContext.getSystemService( Context.LOCATION_SERVICE );

        if ( !manager.isProviderEnabled( LocationManager.GPS_PROVIDER ) ) {
            showGPSSnackbar(R.string.gps_not_enabled);
        } else {
            isGpsOn = true;
            startLocationService();

        }
    }

    private void startLocationService() {
        if (ActivityCompat.checkSelfPermission(this.getActivity(), Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED
            /*&& ActivityCompat.checkSelfPermission(this.getActivity(), Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED*/) {

            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return;
        }

        if (mGoogleApiClient != null) {
            if (mGoogleApiClient.isConnected()) {
                mLocationRequest = getLocationRequest();
                LocationServices.FusedLocationApi
                        .requestLocationUpdates(mGoogleApiClient, mLocationRequest,
                                this);
                //startLocationUpdates();
                mLastLocation = LocationServices.FusedLocationApi.getLastLocation(
                        mGoogleApiClient);
            } else {
                mGoogleApiClient.connect();
            }
        }
    }

    private LocationRequest getLocationRequest() {
        LocationRequest locationRequest = LocationRequest.create();
        locationRequest.setInterval(UPDATE_INTERVAL_IN_MILLISECONDS);
        locationRequest.setPriority(LocationRequest.PRIORITY_HIGH_ACCURACY);
        locationRequest.setFastestInterval(FAST_INTERVAL_CEILING_IN_MILLISECONDS);

        return locationRequest;
    }

    private void showGPSSnackbar(int stringResId) {
        if (stringResId == R.string.location_being_retrieved) {
            SnackBarFactory.createSnackbar(getActivity(), getView(), getString(stringResId)).setAction(android.R.string.ok, new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Timber.e("snackbar ok button clicked" + v.getId());
                }
            });
        } else {
            SnackBarFactory.createSnackbar(getActivity(), getView(), getString(stringResId)).setAction(R.string.enable, new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    startActivity(new Intent(android.provider.Settings.ACTION_LOCATION_SOURCE_SETTINGS));
                }
            });
        }
    }

    @Override
    public void onConnectionSuspended(int i) {
        Timber.e("Connection suspended: %d", i);
    }

    @Override
    public void onLocationChanged(Location location) {
        LocationServices.FusedLocationApi
                .removeLocationUpdates(mGoogleApiClient,
                        this);
        mLastLocation = location;

        Timber.e("Location changed: %s", mLastLocation.toString());

        if (presenter != null) {
            presenter.getUserAddress(mLastLocation.getLatitude(), mLastLocation.getLongitude());
        }
    }

    @Override
    public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {
        Timber.e("Google api client connection failed: %s", connectionResult.toString());
    }

    @Override
    public void onResume() {
        super.onResume();
        mContext.registerReceiver(m_gpsChangeReceiver, new IntentFilter(LocationManager.PROVIDERS_CHANGED_ACTION));

        //mGoogleApiClient.connect();
    }

    @Override
    public void onPause() {
        super.onPause();
        mContext.unregisterReceiver(m_gpsChangeReceiver);
        mGoogleApiClient.disconnect();
    }

    @Override
    public void launch() {
        super.launch();

    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);

        inflater.inflate(R.menu.menu_component_switcher, menu);
        Timber.e("menu title: %s", menu.findItem(R.id.switch_controller).getTitle().toString());
        menuItem = menu.findItem(R.id.switch_controller);
        onOptionsItemSelected(menuItem);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.switch_controller:
                Timber.d("Counter: %d", counter);
                if (counter % 2 == 0) {
                    ApplicationController.getAppComponentv2().plus(new MainViewModulev2()).inject(this);
                } else {
                    ApplicationController.getAppComponent().plus(new MainViewModule()).inject(this);
                }
                presenter.attachView(this);

                if (mGoogleApiClient != null && !mGoogleApiClient.isConnected()) {
                    mGoogleApiClient.connect();
                } else {

                    handleGPSconnectivity();

                }
                ++counter;
                break;
        }
        return true;
    }
}
