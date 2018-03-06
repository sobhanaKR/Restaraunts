package com.example.sobhana.project1;

import android.app.Activity;
import android.content.Intent;
import android.location.Address;
import android.location.Geocoder;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by sobhana on 5/3/18.
 */

public class EventAdapter extends RecyclerView.Adapter<EventAdapter.ViewHolder> {
    ArrayList<EventListModel>EventList;
    Activity activity;
    double lat,lon;
    public EventAdapter(Activity activity, ArrayList<EventListModel> EventList) {
        this.activity =activity;
        this.EventList = EventList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.events_layout_list, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        if(EventList.get(position).Identifier!=null)
            holder.identifier.setText(EventList.get(position).Identifier);
        if(EventList.get(position).EventDate!=null)
            holder.eventdate.setText(EventList.get(position).EventDate);
        if(EventList.get(position).Title!=null)
            holder.title.setText(EventList.get(position).Title);
        if(EventList.get(position).Location!=null)
            holder.location.setText(EventList.get(position).Location);
        if(EventList.get(position).Venue!=null)
            holder.venue.setText(EventList.get(position).Venue);
        if(EventList.get(position).EventType!=null)
            holder.eventType.setText(EventList.get(position).EventType);
        holder.title.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bundle bundle = new Bundle();
                getLocationFromAddress(EventList.get(position).Location);
                bundle.putString("lat",String.valueOf(lat));
                bundle.putString("lon",String.valueOf(lon));
                Intent intent= new Intent(activity, MapsActivity.class);
                intent.putExtra("lat",String.valueOf(lat));
                intent.putExtra("lon",String.valueOf(lon));
                activity.startActivity(intent);
            }
        });
    }

    private void getLocationFromAddress(String strAddress) {
        Geocoder coder = new Geocoder(activity);
        List<Address> address;

        try {
            address = coder.getFromLocationName(strAddress,strAddress.length());
            if (address==null) {
                return ;
            }
            Address location=address.get(0);
            lat=location.getLatitude();
            lon=location.getLongitude();
            Log.i("check","lat-lon"+lat+" "+lon);
            return ;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return ;
    }


    @Override
    public int getItemCount() {
        return EventList.size();
    }
    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView identifier,eventType,eventdate,title,location,venue;

        public ViewHolder(View view) {
            super(view);
            identifier =(TextView)view.findViewById(R.id.Identifier);
            eventdate =(TextView)view.findViewById(R.id.EventDate);
            title =(TextView)view.findViewById(R.id.Title);
            location =(TextView)view.findViewById(R.id.Location);
            venue =(TextView)view.findViewById(R.id.Venue);
            eventType = (TextView)view.findViewById(R.id.EventType);

        }
    }
}
