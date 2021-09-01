package com.example.android_project_24_retrofit.models;

import com.google.gson.annotations.SerializedName;

public class BaseResponse<T> {
    @SerializedName("state")
    private boolean state;
    @SerializedName("message")
    private String message;
    @SerializedName("errors")
    private Object errors;
    @SerializedName("data")
    private BaseData<T> data;


    public boolean isState() {
        return state;
    }

    public void setState(boolean state) {
        this.state = state;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getErrors() {
        return errors;
    }

    public void setErrors(Object errors) {
        this.errors = errors;
    }

    public BaseData<T> getData() {
        return data;
    }

    public void setData(BaseData<T> data) {
        this.data = data;
    }
}
