package com.example.news;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        News news1 = new News("covid-19", "Warning for the third wave");
        News news2 = new News("ANdroid", "New Feature");
        List<News> newsList = new ArrayList<>();
        newsList.add(news1);
        newsList.add(news2);
        NewsAdapter adapter = new NewsAdapter(MainActivity.this, newsList);
    }
}