package com.geektech.newsapi.ui.news_list;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.geektech.newsapi.data.models.com.example.Article;
import com.geektech.newsapi.databinding.ItemNewsBinding;

import java.util.ArrayList;
import java.util.List;

public class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.NewsViewHolder> {

    private List<Article> newsList = new ArrayList<>();

    public void setNewsList(List<Article> newsList) {
        this.newsList = newsList;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public NewsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemNewsBinding binding = ItemNewsBinding.inflate(LayoutInflater.from(parent.getContext()),parent,false);
        return new NewsViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull NewsViewHolder holder, int position) {
holder.onBind(newsList.get(position));
    }

    @Override
    public int getItemCount() {
        return newsList.size();
    }

    protected class NewsViewHolder extends RecyclerView.ViewHolder{
        private ItemNewsBinding binding;

        public NewsViewHolder(@NonNull ItemNewsBinding binding) {

            super(binding.getRoot());
            this.binding = binding;
        }

        public void onBind(Article article) {
            binding.tvTitle.setText(article.getTitle());
            binding.tvDescription.setText(article.getDescription());
            Glide.with(binding.getRoot())
                    .load(article.getUrlToImage())
                    .centerCrop()
                    .into(binding.ivNewsImage);
        }
    }

}
