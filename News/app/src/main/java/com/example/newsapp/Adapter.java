package com.example.newsapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.newsapp.Models.NewsHeadlines;
import com.squareup.picasso.Picasso;

import java.util.List;

public class Adapter extends RecyclerView.Adapter<ViewHolder>{
    private Context context;
    private List<NewsHeadlines> headlines;

    public Adapter(Context context, List<NewsHeadlines> headlines) {
        this.context = context;
        this.headlines = headlines;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(context).inflate(R.layout.layout_items,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.news_title.setText(headlines.get(position).getTitle());
        holder.news_source.setText(headlines.get(position).getSource().getName());
        holder.news_publishedAt.setText(headlines.get(position).getPublishedAt());
        holder.news_content.setText(headlines.get(position).getContent());
        if (headlines.get(position).getUrlToImage()!=null){
            Picasso.get().load(headlines.get(position).getUrlToImage()).into(holder.img_headline);

        }
    }

    @Override
    public int getItemCount() {

        return headlines.size();
    }
}
