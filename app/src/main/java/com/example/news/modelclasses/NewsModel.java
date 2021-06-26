package com.example.news.modelclasses;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class NewsModel{
    //this is a response class where response from server will be held.
	@SerializedName("totalResults")
	private int totalResults;

	@SerializedName("articles")
	private List<ArticlesItem> articles;

	@SerializedName("status")
	private String status;

	public int getTotalResults(){
		return totalResults;
	}

	public List<ArticlesItem> getArticles(){
		return articles;
	}

	public String getStatus(){
		return status;
	}
}