package com.example.sobhana.project1;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

/**
 * Created by sobhana on 5/3/18.
 */

public class MapActivity extends FragmentActivity implements OnMapReadyCallback {
    String latitude,longitude;
    LatLng origin;
    OnMapReadyCallback onMapReadyCallback;
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState, @Nullable PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);
        setContentView(R.layout.map_frag_layout);
        retrieveBundles();
        origin =new LatLng(Double.parseDouble(latitude),Double.parseDouble(longitude));
        ((SupportMapFragment) this.getSupportFragmentManager().findFragmentById(R.id.google_map)).getMapAsync(onMapReadyCallback);
    }

    private void retrieveBundles() {
        Bundle bundle = getIntent().getExtras();
        if(bundle.getString("lat")!=null)
            latitude =bundle.getString("lat");
        if(bundle.getString("lon")!=null)
            longitude=bundle.getString("lon");
    }

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
                    new CameraPosition.Builder().target(origin).zoom(6).build()));
        }

    }
}
