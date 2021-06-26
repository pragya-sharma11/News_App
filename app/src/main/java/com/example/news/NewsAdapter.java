package com.example.news;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.news.modelclasses.ArticlesItem;

import java.util.List;

public class NewsAdapter  extends RecyclerView.Adapter<NewsAdapter.NewsHolder> {
    Context context;
    List<ArticlesItem> newsList;
    //which one should be replicated.
    public NewsAdapter(Context context, List<ArticlesItem> newsList) {
        this.context = context;
        this.newsList = newsList;
    }

    @NonNull
    @Override
    public NewsHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.newsitem, parent,false);
        return new NewsHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull NewsHolder holder, int position) {
        ArticlesItem singleNewsItem = newsList.get(position);
        holder.newsTitle.setText(singleNewsItem.getTitle());
        holder.newsDescription.setText(singleNewsItem.getDescription());
    }

    @Override
    public int getItemCount() {
        return newsList.size();
    }

    public class NewsHolder extends RecyclerView.ViewHolder {
        TextView newsTitle, newsDescription;
        //replicate the data
        public NewsHolder(@NonNull View itemView) {
            super(itemView);
            newsTitle=itemView.findViewById(R.id.title);
            newsDescription=itemView.findViewById(R.id.desc);
        }
    }
}
