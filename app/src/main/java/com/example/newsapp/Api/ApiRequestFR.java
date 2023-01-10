package com.example.newsapp.Api;

import android.content.Context;

import com.example.newsapp.FetchData;
import com.example.newsapp.R;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiRequestFR {
    Context context;

    Retrofit retrofit = new Retrofit.Builder()
            .baseUrl("https://newsapi.org/v2/")
            .addConverterFactory(GsonConverterFactory.create())
            .build();

    public void getNewsHeadlines(FetchData listener, String category, String query)
    {
        ApiInterface callNewsApi = retrofit.create(ApiInterface.class);
        Call<ApiResponse> call = callNewsApi.callHeadlines("fr",category,query,context.getString(R.string.api_key));

        try{
            call.enqueue(new Callback<ApiResponse>() {
                @Override
                public void onResponse(Call<ApiResponse> call, Response<ApiResponse> response) {
                    listener.onFetchData(response.body().getArticles(), response.message());

                }

                @Override
                public void onFailure(Call<ApiResponse> call, Throwable t) {
                    listener.onError("Request Failed");
                }
            });
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

    public void getSpecificNewsHeadlines(FetchData listener, String category, String query)
    {
        ApiInterface callNewsApi = retrofit.create(ApiInterface.class);
        Call<ApiResponse> call = callNewsApi.callSpecificHeadlines(query,context.getString(R.string.api_key));

        try{
            call.enqueue(new Callback<ApiResponse>() {
                @Override
                public void onResponse(Call<ApiResponse> call, Response<ApiResponse> response) {
                    listener.onFetchData(response.body().getArticles(), response.message());

                }

                @Override
                public void onFailure(Call<ApiResponse> call, Throwable t) {
                    listener.onError("Request Failed");
                }
            });
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }


    public ApiRequestFR(Context context) { this.context = context;}

}

