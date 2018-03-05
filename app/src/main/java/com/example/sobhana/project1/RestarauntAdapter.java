package com.example.sobhana.project1;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by sobhana on 5/3/18.
 */

public class RestarauntAdapter extends RecyclerView.Adapter<RestarauntAdapter.ViewHolder> {
    ArrayList<Restaurant>restaurantArrayList;
    Activity activity;
    public RestarauntAdapter(Activity activity, ArrayList<Restaurant> restaurant) {
        this.activity =activity;
        this.restaurantArrayList = restaurant;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.restaraunts_layout_list, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        if(restaurantArrayList.get(position).name!=null)
         holder.name.setText(restaurantArrayList.get(position).name);
        if(restaurantArrayList.get(position).address!=null)
         holder.address.setText(restaurantArrayList.get(position).address);
        if(restaurantArrayList.get(position).telephone!=null)
         holder.telephone.setText(restaurantArrayList.get(position).telephone);
        if(restaurantArrayList.get(position).website!=null)
         holder.website.setText(restaurantArrayList.get(position).website);
        if(restaurantArrayList.get(position).openinghrs!=null)
         holder.timings.setText(restaurantArrayList.get(position).openinghrs);
        holder.name.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bundle bundle = new Bundle();
                bundle.putString("lat",restaurantArrayList.get(position).latitude);
                bundle.putString("long",restaurantArrayList.get(position).longitude);
                Intent intent= new Intent(activity, MapsActivity.class);
                intent.putExtra("lat",restaurantArrayList.get(position).latitude);
                intent.putExtra("lon",restaurantArrayList.get(position).longitude);
                activity.startActivity(intent);
            }
        });
    }



    @Override
    public int getItemCount() {
        return restaurantArrayList.size();
    }
    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView name,address,telephone,website,timings;

        public ViewHolder(View view) {
            super(view);
            name =(TextView)view.findViewById(R.id.name);
            address =(TextView)view.findViewById(R.id.address);
            telephone =(TextView)view.findViewById(R.id.telephone);
            website =(TextView)view.findViewById(R.id.website);
            timings =(TextView)view.findViewById(R.id.opening_time);

        }
    }
}
