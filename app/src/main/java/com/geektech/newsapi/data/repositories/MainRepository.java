package com.geektech.newsapi.data.repositories;

import androidx.lifecycle.MutableLiveData;

import com.geektech.newsapi.common.Resource;
import com.geektech.newsapi.data.models.com.example.MainResponse;
import com.geektech.newsapi.data.remote.NewsApi;

import javax.inject.Inject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainRepository {
    private final String API_KEY = "1cbeb979e984402297862ae437592b89";
    private NewsApi api;
    private MutableLiveData<Resource<MainResponse>> liveData = new MutableLiveData<>();

    @Inject
    public MainRepository(NewsApi api) {
        this.api = api;
    }

    public MutableLiveData<Resource<MainResponse>> getTopNews() {
        liveData.setValue(Resource.loading());
        api.getTopNews("ru", API_KEY).enqueue(new Callback<MainResponse>() {
            @Override
            public void onResponse(Call<MainResponse> call, Response<MainResponse> response) {
                if (response.isSuccessful() && response.body() != null) {
                    liveData.setValue(Resource.success(response.body()));
                } else {
                    liveData.setValue(Resource.error(response.message(), null));

                }
            }

            @Override
            public void onFailure(Call<MainResponse> call, Throwable t) {
                liveData.setValue(Resource.error(t.getLocalizedMessage(), null));

            }
        });
        return liveData;

    }

    public MutableLiveData<Resource<MainResponse>> getNewsByCategory(String category) {
        liveData.setValue(Resource.loading());
        api.getNewsByCategory("ru", category, API_KEY).enqueue(new Callback<MainResponse>() {
            @Override
            public void onResponse(Call<MainResponse> call, Response<MainResponse> response) {
                if (response.isSuccessful() && response.body() != null) {
                    liveData.setValue(Resource.success(response.body()));
                } else {
                    liveData.setValue(Resource.error(response.message(), null));

                }
            }

            @Override
            public void onFailure(Call<MainResponse> call, Throwable t) {
                liveData.setValue(Resource.error(t.getLocalizedMessage(), null));

            }
        });
        return liveData;

    }

    public MutableLiveData<Resource<MainResponse>> getNewsByWord(String keyWord) {
        liveData.setValue(Resource.loading());
        api.getNewsByKeyWord(keyWord, API_KEY).enqueue(new Callback<MainResponse>() {
            @Override
            public void onResponse(Call<MainResponse> call, Response<MainResponse> response) {
                if (response.isSuccessful() && response.body() != null) {
                    liveData.setValue(Resource.success(response.body()));
                } else {
                    liveData.setValue(Resource.error(response.message(), null));

                }
            }

            @Override
            public void onFailure(Call<MainResponse> call, Throwable t) {
                liveData.setValue(Resource.error(t.getLocalizedMessage(), null));

            }
        });
        return liveData;

    }

}
