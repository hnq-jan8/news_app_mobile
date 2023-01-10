package com.example.newsapp.Api;

import com.example.newsapp.Models.NewsHeadlines;

import java.io.Serializable;
import java.util.List;

public class ApiResponse implements Serializable {
    String status;
    int totalResults;
    List<NewsHeadlines> articles;

    public String getStatus() {
        return status;
    }

    public int getTotalResults() {
        return totalResults;
    }

    public List<NewsHeadlines> getArticles() {
        return articles;
    }
}
