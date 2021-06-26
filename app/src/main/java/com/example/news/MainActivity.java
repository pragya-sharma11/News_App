package com.example.news;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import com.example.news.modelclasses.ArticlesItem;
import com.example.news.modelclasses.NewsModel;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    RecyclerView newsRecycler;
    private Retrofit retrofit;
    private  NewsInterface newsInterface;
    List<ArticlesItem>  news;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        newsRecycler=findViewById(R.id.newsRecycler);
        String category="health";
        setNewsRetrofit(category);



    }
    public void setNewsRetrofit(String category){
        retrofit = new Retrofit.Builder().baseUrl("https://newsapi.org/").addConverterFactory(GsonConverterFactory.create()).build();//base url has added.
        //data has come here.
        newsInterface = retrofit.create(NewsInterface.class);
        Call<NewsModel> responseNews = newsInterface.getNewsData(category);
        //whn we do all these thing then our UI will be lagging , so to remove this indescrepency, Retrofit has a method
        //enqueue will do these data fetching things in background thread.
        responseNews.enqueue(new Callback<NewsModel>() {
            @Override
            public void onResponse(Call<NewsModel> call, Response<NewsModel> response) {
                if(response.isSuccessful()){
                    NewsModel mainResponse = response.body();
                    news = mainResponse.getArticles();
                    for (ArticlesItem articlesItem : news) {
                        Log.d("tag", articlesItem.getTitle()); //for testing
                    }
                    newsRecycler.setLayoutManager(new LinearLayoutManager(MainActivity.this));//default vertical
                    NewsAdapter adapter = new NewsAdapter(MainActivity.this, news);
                    newsRecycler.setAdapter(adapter);
                }
            }

            @Override
            public void onFailure(Call<NewsModel> call, Throwable t) {

            }
        });
    }
}