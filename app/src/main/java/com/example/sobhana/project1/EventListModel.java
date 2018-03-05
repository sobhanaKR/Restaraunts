package com.example.sobhana.project1;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by sobhana on 5/3/18.
 */

class EventListModel implements Parcelable{
    String Identifier;
    String EventDate;
    String Title;
    String Location;
    String Venue;
    String EventType;

    protected EventListModel(Parcel in) {
        Identifier = in.readString();
        EventDate = in.readString();
        Title = in.readString();
        Location = in.readString();
        Venue = in.readString();
        EventType = in.readString();
    }

    public static final Creator<EventListModel> CREATOR = new Creator<EventListModel>() {
        @Override
        public EventListModel createFromParcel(Parcel in) {
            return new EventListModel(in);
        }

        @Override
        public EventListModel[] newArray(int size) {
            return new EventListModel[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(Identifier);
        parcel.writeString(EventDate);
        parcel.writeString(Title);
        parcel.writeString(Location);
        parcel.writeString(Venue);
        parcel.writeString(EventType);
    }
}
