package com.example.droidcafe;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface MovieFetcher {
    @GET("/3/movie/{category}")
    Call<MovieResults> listOfMovies(@Path("category") String category, @Query("api_key") String apiKey, @Query("page") int pageNum);

    @GET("/3/movie/{movie_id}/videos")
    Call<TrailerResults> movieTrailers(@Path("movie_id") int movie_id, @Query("api_key") String apiKey);

    @GET("/3/movie/{movie_id}/reviews")
    Call<ReviewsResults> movieReviews(@Path("movie_id") int movie_id, @Query("api_key") String apiKey);

}
