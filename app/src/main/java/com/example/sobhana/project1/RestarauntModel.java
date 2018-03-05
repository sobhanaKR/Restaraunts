package com.example.sobhana.project1;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by sobhana on 5/3/18.
 */

class RestarauntModel implements Parcelable{
    public Restaurants restaurants;


    protected RestarauntModel(Parcel in) {
        restaurants = in.readParcelable(Restaurants.class.getClassLoader());
    }

    public static final Creator<RestarauntModel> CREATOR = new Creator<RestarauntModel>() {
        @Override
        public RestarauntModel createFromParcel(Parcel in) {
            return new RestarauntModel(in);
        }

        @Override
        public RestarauntModel[] newArray(int size) {
            return new RestarauntModel[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeParcelable(restaurants, i);
    }
}
