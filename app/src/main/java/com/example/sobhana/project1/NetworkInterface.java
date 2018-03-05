package com.example.sobhana.project1;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by sobhana on 5/3/18.
 */

public interface NetworkInterface {
    @GET("1d5df898-1481-42cf-85a5-673c6cdec65e/resource/73e13022-0ae6-445e-9bb5-d3d91f154a7b/download/restaurants.json")
    Call<RestarauntModel> fetchRestarauntList();
    @GET("dfdefba9-745e-4618-bddd-fbd179e910c8/resource/90f81009-fbc9-41ef-b031-fe3ae8bef03b/download/events.json")
    Call<EventModel> fetchEventList();
}
