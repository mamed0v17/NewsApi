package com.geektech.newsapi.ui.news_list;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.geektech.newsapi.common.Resource;
import com.geektech.newsapi.data.models.com.example.MainResponse;
import com.geektech.newsapi.data.repositories.MainRepository;

import javax.inject.Inject;

import dagger.hilt.android.lifecycle.HiltViewModel;

@HiltViewModel
public class NewsListViewModel extends ViewModel {

    private MainRepository repository;
    public LiveData<Resource<MainResponse>> newsLiveData;
    public LiveData<Resource<MainResponse>> newsKeyLiveData;

    @Inject
    public NewsListViewModel(MainRepository repository) {
        this.repository = repository;
    }
    public void getTopNews(){

        newsLiveData = repository.getTopNews();

    }

    public void getNewsByKeyWord(String s){
        newsKeyLiveData = repository.getNewsByWord(s);
    }

}
