package com.example.news;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.ProgressBar;

import com.example.news.modelclasses.ArticlesItem;
import com.example.news.modelclasses.NewsModel;
import com.google.android.material.bottomnavigation.BottomNavigationItemView;
import com.google.android.material.bottomnavigation.BottomNavigationView;

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
    ProgressBar progressBar;
    private ActionBar actionBar;
    //String sports="sports", health = "health", technology = "technnology",
      //      entertainment = "entertainment", general = "general" ,business = "business";
    BottomNavigationView bottomNavigationView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        newsRecycler=findViewById(R.id.newsRecycler);
        bottomNavigationView = findViewById(R.id.bottomNavigation);
        progressBar = findViewById(R.id.progressBar);
        actionBar = getSupportActionBar();
        String category="general";
        setNavigationListener();
        setNewsRetrofit(category); // by default general will open for we have set general when we open the app at first.



    }
    public void setNewsRetrofit(String category){
        String s1=new String(String.valueOf(Character.toUpperCase(category.charAt(0))));
        actionBar.setTitle(s1+category.substring(1));//set action bar i.e title at the top of the app.
        progressBar.setVisibility(View.VISIBLE);
        newsRecycler.setVisibility(View.INVISIBLE);//at this function, the data is set so we make visibility here above it.
        retrofit = new Retrofit.Builder().baseUrl("https://newsapi.org/").addConverterFactory(GsonConverterFactory.create()).build();//base url has added.
        //data has come here.
        newsInterface = retrofit.create(NewsInterface.class);
        Call<NewsModel> responseNews = newsInterface.getNewsData(category);
        //whn we do all these thing then our UI will be lagging , so to remove this indescrepency, Retrofit has a method
        //enqueue will do these data fetching things in background thread.
        responseNews.enqueue(new Callback<NewsModel>() {
            @Override
            public void onResponse(Call<NewsModel> call, Response<NewsModel> response) {
                if (response.isSuccessful()) {
                    NewsModel mainResponse = response.body();
                    news = mainResponse.getArticles();
                    /*for (ArticlesItem articlesItem : news) {
                        Log.d("tag", articlesItem.getTitle()); //for testing
                    }*/
                    newsRecycler.setLayoutManager(new LinearLayoutManager(MainActivity.this));//default vertical
                    NewsAdapter adapter = new NewsAdapter(MainActivity.this, news);
                    progressBar.setVisibility(View.INVISIBLE);
                    newsRecycler.setVisibility(View.VISIBLE);
                    newsRecycler.setAdapter(adapter);//at this point, the data is set so we make visibility here above it.
                }
            }
            @Override
            public void onFailure(Call<NewsModel> call, Throwable t) {

            }
        });
    }
    public  void setNavigationListener(){
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int id = item.getItemId();
                switch (id){
                    case R.id.general:
                        setNewsRetrofit("general");
                        return true;//by default it eill be true but if we put flase here and click on some another category
                        // then again click to general then it will not highlight it.
                    case R.id.sports:
                        setNewsRetrofit("sports");
                        return true;
                    case R.id.technology:
                        setNewsRetrofit("technology");
                        return true;
                    case R.id.health:
                        setNewsRetrofit("health");
                        return true;
                    case R.id.business:
                        setNewsRetrofit("business");
                        return true;
                    default:
                        return  false;

                }
                 //return true-> focus/highlight on the icon on which user clicked
            }
        });
    }
}