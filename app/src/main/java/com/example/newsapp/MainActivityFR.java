package com.example.newsapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.newsapp.Api.ApiRequestFR;
import com.example.newsapp.Models.ApiResponse;
import com.example.newsapp.Models.NewsHeadlines;

import java.util.List;


public class MainActivityFR extends AppCompatActivity implements SelectListener,View.OnClickListener{
    RecyclerView recyclerView;
    Adapter adapter;
    Button b1,b2,b3,b4,b5,b6,b7;
    SearchView searchView;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_fr);

        searchView = findViewById(R.id.search_view);

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                ApiRequestFR manager = new ApiRequestFR(MainActivityFR.this);
                manager.getSpecificNewsHeadlines(listener, "everything",query);

                return true;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                return false;
            }
        });


        b1 = findViewById(R.id.btn_1);
        b1.setOnClickListener(this);
        b2 = findViewById(R.id.btn_2);
        b2.setOnClickListener(this);
        b3 = findViewById(R.id.btn_3);
        b3.setOnClickListener(this);
        b4 = findViewById(R.id.btn_4);
        b4.setOnClickListener(this);
        b5 = findViewById(R.id.btn_5);
        b5.setOnClickListener(this);
        b6 = findViewById(R.id.btn_6);
        b6.setOnClickListener(this);
        b7 = findViewById(R.id.btn_7);
        b7.setOnClickListener(this);

        ApiRequestFR manager = new ApiRequestFR(this);
        manager.getNewsHeadlines(listener, "general",null);
    }

    private final FetchData<ApiResponse> listener = new FetchData<ApiResponse>() {
        @Override
        public void onFetchData(List<NewsHeadlines> list, String message) {
            if(list.isEmpty()){
                Toast.makeText(MainActivityFR.this, "No data found!!!", Toast.LENGTH_SHORT).show();
            }
            else{
                showNews(list);
            }
        }

        @Override
        public void onError(String message) {
            Toast.makeText(MainActivityFR.this, "An Error Occured!!!", Toast.LENGTH_SHORT).show();

        }
    };

    private void showNews(List<NewsHeadlines> list) {
        recyclerView = findViewById(R.id.recycler_main);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new GridLayoutManager(this,1));
        adapter = new Adapter(this,list,this  );
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void OnNewsClicked(NewsHeadlines headlines) {
        startActivity(new Intent(MainActivityFR.this, NewDetails.class)
                .putExtra("data", headlines));

    }

    @Override
    public void onClick(View view) {
        Button button = (Button) view;
        String category = button.getContentDescription().toString();
        ApiRequestFR manager = new ApiRequestFR(this);
        manager.getNewsHeadlines(listener, category,null);
    }
}