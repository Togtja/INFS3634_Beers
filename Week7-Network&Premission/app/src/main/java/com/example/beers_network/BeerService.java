package com.example.beers_network;


import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface BeerService {
    @GET("beers/")
    Call<List<Beer>> keyOfUser(@Query("key") String key, @Query("withBreweries") String brew);
}
