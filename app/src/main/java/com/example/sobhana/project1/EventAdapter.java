package com.example.sobhana.project1;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by sobhana on 5/3/18.
 */

public class EventAdapter extends RecyclerView.Adapter<EventAdapter.ViewHolder> {
    ArrayList<EventListModel>EventList;
    Activity activity;
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
    public void onBindViewHolder(ViewHolder holder, int position) {
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
//                Bundle bundle = new Bundle();
//                bundle.putString("lat",EventList.get(position).latitude);
//                bundle.putString("long",restaurantArrayList.get(position).longitude);
//                Intent intent= new Intent(activity, MapsActivity.class);
//                intent.putExtra("lat",restaurantArrayList.get(position).latitude);
//                intent.putExtra("lon",restaurantArrayList.get(position).longitude);
//                activity.startActivity(intent);
            }
        });
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
