package com.example.newsapp;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

public class ViewHolder extends RecyclerView.ViewHolder{
    TextView news_title,news_source, news_content, news_publishedAt;
    ImageView img_headline;
    CardView cardView;

    public ViewHolder(@NonNull View itemView) {
        super(itemView);
        news_content = itemView.findViewById(R.id.mContent);
        news_publishedAt = itemView.findViewById(R.id.mPublishedAt);
        news_title = itemView.findViewById(R.id.mTitle);
        news_source = itemView.findViewById(R.id.mSource);
        img_headline = itemView.findViewById(R.id.image_headline);
        cardView = itemView.findViewById(R.id.main_container);
    }
}
