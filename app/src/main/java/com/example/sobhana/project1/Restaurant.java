package com.example.sobhana.project1;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by sobhana on 5/3/18.
 */

class Restaurant implements Parcelable{
    public String name;
    public String address;
    public String latitude;
    public String longitude;
    public String telephone;
    public String website;
    public String openinghrs="opening-hours";

    protected Restaurant(Parcel in) {
        name = in.readString();
        address = in.readString();
        latitude = in.readString();
        longitude = in.readString();
        telephone = in.readString();
        website = in.readString();
        if(openinghrs.equals("opening-hours"))
          openinghrs = in.readString();
    }

    public static final Creator<Restaurant> CREATOR = new Creator<Restaurant>() {
        @Override
        public Restaurant createFromParcel(Parcel in) {
            return new Restaurant(in);
        }

        @Override
        public Restaurant[] newArray(int size) {
            return new Restaurant[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(name);
        parcel.writeString(address);
        parcel.writeString(latitude);
        parcel.writeString(longitude);
        parcel.writeString(telephone);
        parcel.writeString(website);
        parcel.writeString(openinghrs);
    }
}
