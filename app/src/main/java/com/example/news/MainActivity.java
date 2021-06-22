package com.example.news;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    RecyclerView newsRecycler;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        newsRecycler=findViewById(R.id.newsRecycler);
        News news1 = new News("covid-19", "Warning for the third wave");
        News news2 = new News("ANdroid", "New Feature");
        List<News> newsList = new ArrayList<>();
        newsList.add(news1);
        newsList.add(news2);
        newsRecycler.setLayoutManager(new LinearLayoutManager(this));//default vertical
        NewsAdapter adapter = new NewsAdapter(MainActivity.this, newsList);
        newsRecycler.setAdapter(adapter);
    }
}