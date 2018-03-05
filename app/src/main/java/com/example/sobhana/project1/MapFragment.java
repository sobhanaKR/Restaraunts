package com.example.sobhana.project1;

import android.app.Activity;
import android.app.Fragment;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

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

public class MapFragment extends Fragment  implements OnMapReadyCallback {
    String latitude;
    String longitude;
    Activity activity;
    LatLng origin;
    OnMapReadyCallback onMapReadyCallback;
    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN_MR1)
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.map_frag_layout, null, false);
        retrieveBundles();
        activity = getActivity();
        origin =new LatLng(Double.parseDouble(latitude),Double.parseDouble(longitude));
        ((SupportMapFragment) ((AppCompatActivity) activity).getSupportFragmentManager().findFragmentById(R.id.google_map)).getMapAsync(onMapReadyCallback);

        return  rootView;
    }


    private void retrieveBundles() {
        Bundle bundle = getArguments();
        latitude =bundle.getString("lat");
        longitude=bundle.getString("long");
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
