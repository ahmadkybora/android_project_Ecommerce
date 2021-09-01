package com.example.android_project_24_retrofit.models;

import com.google.gson.annotations.SerializedName;

public class BaseData<T>{
    @SerializedName("data")
    private T data;

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
