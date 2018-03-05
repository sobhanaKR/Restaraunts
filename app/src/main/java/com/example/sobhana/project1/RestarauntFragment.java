package com.example.sobhana.project1;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

/**
 * Created by sobhana on 5/3/18.
 */

public class RestarauntFragment extends Fragment {
    RestarauntModel restarauntModel;
    Activity activity;
    RecyclerView recyclerView;
    RestarauntAdapter adapter;
    LinearLayout wholeLyt;
    String latitude,longitude;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.restaraunt_frag_layout, null, false);
        Log.i("check","success2");
        activity = getActivity();
        recyclerView =(RecyclerView)rootView.findViewById(R.id.recycler_view);
        return rootView;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        receiveBundles();
        Log.i("check","success3"+restarauntModel);
        setUpRecyclerView();
        Log.i("check","success4");
        if(restarauntModel!=null) {
            Log.i("check","success6");
            adapter = new RestarauntAdapter(activity, restarauntModel.restaurants.restaurant);
        }
        if(adapter!=null)
            recyclerView.setAdapter(adapter);

    }

    private void setUpRecyclerView() {
            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(activity);
            linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
            recyclerView.setHasFixedSize(true);
            Log.i("check","success5");
            recyclerView.setLayoutManager(linearLayoutManager);
    }

    private void receiveBundles() {
        Bundle bundle = getArguments();
         restarauntModel =bundle.getParcelable("Restaraunt");
    }
}
