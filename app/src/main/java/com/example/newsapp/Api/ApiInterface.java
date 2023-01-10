package com.example.newsapp.Api;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiInterface {
    @GET("top-headlines")
    Call<ApiResponse> callHeadlines(
            @Query("country") String country,
            @Query("category") String category,
            @Query("q") String query,
            @Query("apiKey") String api_key
    );

    @GET("everything")
    Call<ApiResponse> callSpecificHeadlines(
            @Query("q") String query,
            @Query("apiKey") String api_key
    );


}
