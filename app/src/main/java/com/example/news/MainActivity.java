package com.example.news;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    RecyclerView newsRecycler;
    private Retrofit retrofit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        newsRecycler=findViewById(R.id.newsRecycler);
        retrofit = new Retrofit.Builder().baseUrl("https://newsapi.org/").addConverterFactory(GsonConverterFactory.create()).build();//base url has added.
        //data has come here.


        newsRecycler.setLayoutManager(new LinearLayoutManager(this));//default vertical
        NewsAdapter adapter = new NewsAdapter(MainActivity.this, newsList);
        newsRecycler.setAdapter(adapter);
    }
}