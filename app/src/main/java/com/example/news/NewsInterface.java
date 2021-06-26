package com.example.news;

import com.example.news.modelclasses.NewsModel;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface NewsInterface {
    String s1="v2/top-headlines?country=in&category=", s2="technology";
    //everything after ? is query so retrofit has an annotation called query
    String s3="&apiKey=3ecb725ad3614d879cb6b89c9974a733";
    @GET("v2/top-headlines?country=in&apiKey=3ecb725ad3614d879cb6b89c9974a733") //given end point.
    Call<NewsModel> getNewsData(@Query("category") String category); //here parameter category will be set in category query .

}
