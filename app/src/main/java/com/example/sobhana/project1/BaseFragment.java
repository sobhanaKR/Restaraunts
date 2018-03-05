package com.example.sobhana.project1;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by sobhana on 5/3/18.
 */

public class BaseFragment extends Fragment {
    Retrofit retrofit = null;
    RestarauntModel restarauntModel;
    EventModel eventModel;
    Context context;
    Activity activity;
    LinearLayout mainLyt;
    FragmentManager fragmentManager;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.base_frag_layout, null, false);
        activity = getActivity();
        Button restarauntBtn,eventBtn;
        restarauntBtn = (Button)rootView.findViewById(R.id.restaraunt);
        eventBtn = (Button)rootView.findViewById(R.id.event);
        mainLyt = (LinearLayout)rootView.findViewById(R.id.main_layout);
        restarauntBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getAPIData("restaraunt");

            }
        });
        eventBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getAPIData("event");
            }
        });
        return rootView;
    }

    private void getAPIData(String type) {
        if (retrofit ==null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl("http://www.opendatamalta.org/ckan/dataset/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        NetworkInterface apiService =
                retrofit.create(NetworkInterface.class);
        if(type.equals("restaraunt")) {

            Call<RestarauntModel> call = apiService.fetchRestarauntList();
            call.enqueue(new Callback<RestarauntModel>() {
                @Override
                public void onResponse(Call<RestarauntModel> call, Response<RestarauntModel> response) {
                    if(response.isSuccessful()){
                        Log.i("check","success"+response.body().toString());
                        if(response.body()!=null){
                            Log.i("check","success1");
                            mainLyt.setVisibility(View.GONE);
                            restarauntModel = response.body();
                            Bundle bundle=new Bundle();
                            bundle.putParcelable("Restaraunt", restarauntModel);
                            RestarauntFragment restarauntFrag= new RestarauntFragment();
                            restarauntFrag.setArguments(bundle);
                            fragmentManager = activity.getFragmentManager();
                            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                            fragmentTransaction.addToBackStack(null);
                            fragmentTransaction.replace(R.id.container, restarauntFrag, "RestarauntFragment");
                            fragmentTransaction.commit();
                        }
                    }
                    else{
                        Log.i("check","failurecall"+response.body().toString());
                    }
                }

                @Override
                public void onFailure(Call<RestarauntModel> call, Throwable t) {
                    Log.i("check","failure");
                    // Log error here since request failed
                }
            });
        }
        else{
            Call<EventModel> call = apiService.fetchEventList();
            call.enqueue(new Callback<EventModel>() {
                @Override
                public void onResponse(Call<EventModel> call, Response<EventModel> response) {
                    if(response.isSuccessful()){
                        if(response.body()!=null){
                            Log.i("check","success1");
                            mainLyt.setVisibility(View.GONE);
                            eventModel = response.body();
                            Bundle bundle=new Bundle();
                            bundle.putParcelable("event", eventModel);
                            EventFragment eventFragment= new EventFragment();
                            eventFragment.setArguments(bundle);
                            fragmentManager = activity.getFragmentManager();
                            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                            fragmentTransaction.replace(R.id.container,eventFragment ,"eventfragment");
                            fragmentTransaction.addToBackStack(null);
                            fragmentTransaction.commit();
                        }
                    }
                    else{
                        Log.i("check","failurecall"+response.body().toString());
                    }
                }

                @Override
                public void onFailure(Call<EventModel> call, Throwable t) {

                }
            });


        }

    }



}
