package com.example.dncaphoneshop.Retrofit;

import com.example.dncaphoneshop.Model.DataResponce;
import com.example.dncaphoneshop.Model.User;
import io.reactivex.Observable;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;

public interface API {

    @GET("/login")
    @FormUrlEncoded
    Observable<DataResponce> login(@Field("username") String user,
                                   @Field("password") String passWorld);

    @GET("/register")
    Observable<DataResponce> register(@Body User account);
}
