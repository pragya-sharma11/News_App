package com.example.news;

import com.example.news.modelclasses.NewsModel;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface NewsInterface {
    //everything after ? is query so retrofit has an annotation called query
    @GET("v2/top-headlines?country=in&apiKey=3ecb725ad3614d879cb6b89c9974a733") //given end point.
    Call<NewsModel> getNewsData(@Query("category") String category); //here parameter category will be set in category query .

}
