package com.geektech.newsapi.di;


import com.geektech.newsapi.data.remote.NewsApi;
import com.geektech.newsapi.data.repositories.MainRepository;

import dagger.Module;
import dagger.Provides;
import dagger.hilt.InstallIn;
import dagger.hilt.components.SingletonComponent;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

@InstallIn({SingletonComponent.class})
@Module
public class AppModule {

    @Provides
    public static OkHttpClient provideClient(){
        return new OkHttpClient.Builder()
                .addInterceptor(new HttpLoggingInterceptor()
                .setLevel(HttpLoggingInterceptor.Level.BODY)
                ).build();
    }

    @Provides
    public  static Retrofit provideRetrofit(OkHttpClient client){
       return new Retrofit.Builder()
                .baseUrl("https://newsapi.org/v2/")
                .addConverterFactory(GsonConverterFactory.create())
                .client(client)
                .build();
    }

    @Provides
    public static NewsApi provideNewsApi(Retrofit retrofit){
        return retrofit.create(NewsApi.class);
    }

    @Provides
    public static MainRepository provideMainRepository(NewsApi api){
        return new MainRepository(api);

    }


}
