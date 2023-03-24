package com.example.droidcafe;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitSingleton {

    private static RetrofitSingleton instance = null;
    private final MovieFetcher myInterface;

    private RetrofitSingleton() {
        String BASE_URL = "https://api.themoviedb.org";
        Retrofit retrofit = new Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create()).build();
        myInterface = retrofit.create(MovieFetcher.class);
    }

    public static RetrofitSingleton getInstance() {
        if (instance == null) {
            instance = new RetrofitSingleton();
        }
        return instance;
    }

    public MovieFetcher getMovieFetcher() {
        return myInterface;
    }
}