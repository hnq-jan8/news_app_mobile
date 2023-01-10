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

import com.example.newsapp.Api.ApiRequest;
import com.example.newsapp.Api.ApiResponse;
import com.example.newsapp.Models.NewsHeadlines;

import java.util.List;

public class MainActivity extends AppCompatActivity implements SelectListener,View.OnClickListener{
    RecyclerView recyclerView;
    Adapter adapter;
    Button G_b,E_b,B_b,H_b,S_b,Sp_b,T_b;
    SearchView searchView;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        searchView = findViewById(R.id.search_view);

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                ApiRequest manager = new ApiRequest(MainActivity.this);
                manager.getSpecificNewsHeadlines(listener, "everything",query);

                return true;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                return false;
            }
        });


        G_b = findViewById(R.id.b1);
        G_b.setOnClickListener(this);
        E_b = findViewById(R.id.b2);
        E_b.setOnClickListener(this);
        B_b = findViewById(R.id.b3);
        B_b.setOnClickListener(this);
        H_b = findViewById(R.id.b4);
        H_b.setOnClickListener(this);
        S_b = findViewById(R.id.b5);
        S_b.setOnClickListener(this);
        Sp_b = findViewById(R.id.b6);
        Sp_b.setOnClickListener(this);
        T_b = findViewById(R.id.b7);
        T_b.setOnClickListener(this);

        ApiRequest manager = new ApiRequest(this);
        manager.getNewsHeadlines(listener, "general",null);
    }

    private final FetchData<ApiResponse> listener = new FetchData<ApiResponse>() {
        @Override
        public void onFetchData(List<NewsHeadlines> list, String message) {

            showNews(list);

        }

        @Override
        public void onError(String message) {

            Toast.makeText(MainActivity.this, "Error!", Toast.LENGTH_SHORT).show();

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

        startActivity(new Intent(MainActivity.this, NewDetails.class)
                .putExtra("data", headlines));

    }

    @Override
    public void onClick(View view) {

        Button button = (Button) view;
        String category = button.getText().toString();
        ApiRequest manager = new ApiRequest(this);
        manager.getNewsHeadlines(listener, category,null);

    }
}