package com.example.dncaphoneshop.Common;

import com.example.dncaphoneshop.Retrofit.API;
import com.example.dncaphoneshop.Retrofit.RetrofitDuLieu;
import retrofit2.Retrofit;

public class Common {

    public static API getAPI(){
        return RetrofitDuLieu.getRetrofit().create(API.class);
    }
}
