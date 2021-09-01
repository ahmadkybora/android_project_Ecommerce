package com.example.android_project_24_retrofit.httpConnection;

import com.example.android_project_24_retrofit.models.BaseResponse;
import com.example.android_project_24_retrofit.models.Products;

import java.util.List;

import retrofit2.http.GET;
import retrofit2.Call;
import retrofit2.http.Headers;

public interface ApiInterface {

    @Headers({
            "Accept: application/json",
            "Content-Type: application/json"
    })
    @GET("products")
    Call<BaseResponse<List<Products>>> getData();
}
