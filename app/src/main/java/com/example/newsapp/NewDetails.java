package com.example.newsapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.newsapp.Models.NewsHeadlines;
import com.squareup.picasso.Picasso;

public class NewDetails extends AppCompatActivity {

    NewsHeadlines headlines;
    TextView title,author,time,detail,content;
    ImageView img_news;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.news_deatails_layout);
        title = findViewById(R.id.text_detail_title);
        author = findViewById(R.id.text_detail_author);
        time = findViewById(R.id.text_detail_time);
        detail = findViewById(R.id.text_detail_detail);
        content = findViewById(R.id.text_detail_content);
        img_news = findViewById(R.id.img_detail_news);

        headlines= (NewsHeadlines) getIntent().getSerializableExtra("data");

        title.setText(headlines.getTitle());
        author.setText(headlines.getAuthor());
        time.setText(headlines.getPublishedAt());
        detail.setText(headlines.getDescription());
        content.setText(headlines.getContent());
        Picasso.get().load(headlines.getUrlToImage()).into(img_news);

    }

    public void openUrl(View view) {

        String url = headlines.getUrl();
        Intent i = new Intent(Intent.ACTION_VIEW);
        i.setData(Uri.parse(url));
        startActivity(i);

    }
}