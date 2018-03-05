package com.example.sobhana.project1;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;

/**
 * Created by sobhana on 5/3/18.
 */

class Restaurants implements Parcelable {
    public ArrayList<Restaurant> restaurant;

    protected Restaurants(Parcel in) {
        restaurant = in.createTypedArrayList(Restaurant.CREATOR);
    }

    public static final Creator<Restaurants> CREATOR = new Creator<Restaurants>() {
        @Override
        public Restaurants createFromParcel(Parcel in) {
            return new Restaurants(in);
        }

        @Override
        public Restaurants[] newArray(int size) {
            return new Restaurants[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeTypedList(restaurant);
    }
}

