package com.example.sobhana.project1;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;

/**
 * Created by sobhana on 5/3/18.
 */

class EventModel implements Parcelable {
    public String License;
    ArrayList<EventListModel>EventList;

    protected EventModel(Parcel in) {
        License = in.readString();
        EventList = in.createTypedArrayList(EventListModel.CREATOR);
    }

    public static final Creator<EventModel> CREATOR = new Creator<EventModel>() {
        @Override
        public EventModel createFromParcel(Parcel in) {
            return new EventModel(in);
        }

        @Override
        public EventModel[] newArray(int size) {
            return new EventModel[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(License);
    }
}
