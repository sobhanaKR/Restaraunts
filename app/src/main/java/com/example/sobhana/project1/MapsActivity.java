package com.example.sobhana.project1;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap map;
    String latitude,longitude;
    LatLng origin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        retrieveBundles();
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }
    private void retrieveBundles() {
        Bundle bundle = getIntent().getExtras();
        if(bundle.getString("lat")!=null)
            latitude =bundle.getString("lat");
        if(bundle.getString("lon")!=null)
            longitude=bundle.getString("lon");
        origin = new LatLng(Double.parseDouble(latitude),Double.parseDouble(longitude));
    }


    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap map) {
        if (map != null ) {
            map.setMapType(GoogleMap.MAP_TYPE_NORMAL);
            map.setBuildingsEnabled(true);
            map.getUiSettings().setZoomControlsEnabled(true);
            map.getUiSettings().setIndoorLevelPickerEnabled(true);
            map.getUiSettings().setAllGesturesEnabled(true);
            map.getUiSettings().setMyLocationButtonEnabled(true);
            map.getUiSettings().setRotateGesturesEnabled(true);
            map.getUiSettings().setCompassEnabled(true);
            map.addMarker(new MarkerOptions().position(origin));
            map.animateCamera(CameraUpdateFactory.newCameraPosition(
                    new CameraPosition.Builder().target(origin).zoom(18).build()));
        }


    }
}
