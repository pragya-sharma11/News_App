package com.example.news;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class NewsAdapter  extends RecyclerView.Adapter<NewsAdapter.NewsHolder> {
    Context context;
    List<News> newsList;

    public NewsAdapter(Context context, List<News> newsList) {
        this.context = context;
        this.newsList = newsList;
    }

    @NonNull
    @Override
    public NewsHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from();
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull NewsHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class NewsHolder extends RecyclerView.ViewHolder {
        TextView newsTitle, newsDescription;

        public NewsHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}
