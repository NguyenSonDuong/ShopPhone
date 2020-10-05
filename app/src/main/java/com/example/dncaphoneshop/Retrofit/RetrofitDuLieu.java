package com.example.dncaphoneshop.Retrofit;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitDuLieu {

    public static Retrofit retrofit = null;

    public static Retrofit getRetrofit(){

        if(retrofit == null){
            retrofit = new Retrofit.Builder().baseUrl("http://192.168.1.69:8181/")
                                            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                                            .addConverterFactory(GsonConverterFactory.create())
                                            .build();

        }

        return retrofit;
    }
}
