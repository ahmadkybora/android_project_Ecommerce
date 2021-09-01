package com.example.android_project_24_retrofit.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.example.android_project_24_retrofit.R;
import com.example.android_project_24_retrofit.adapter.ProductAdapter;
import com.example.android_project_24_retrofit.httpConnection.ApiClient;
import com.example.android_project_24_retrofit.httpConnection.ApiInterface;
import com.example.android_project_24_retrofit.models.BaseResponse;
import com.example.android_project_24_retrofit.models.Products;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    ProductAdapter adapter;
    List<Products> list = new ArrayList<>();
    ApiInterface request;
    String url = "http://192.168.1.103:3001/api/";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
    }

    private void initViews() {
        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        request = ApiClient.getAPiClient(url).create(ApiInterface.class);

        request.getData().enqueue(new Callback<BaseResponse<List<Products>>>() {
            @Override
            public void onResponse(Call<BaseResponse<List<Products>>> call, Response<BaseResponse<List<Products>>> response) {
                if (response.code() == 200 && response.body() != null) {
                    list = response.body().getData().getData();
                    adapter = new ProductAdapter(getApplicationContext(), list);
                    recyclerView.setAdapter(adapter);
                } else {
                    Toast.makeText(MainActivity.this, response.code() + "", Toast.LENGTH_SHORT).show();
                    Log.e("Error", response.message());
                }
            }

            @Override
            public void onFailure(Call<BaseResponse<List<Products>>> call, Throwable t) {
                Toast.makeText(MainActivity.this, t.getMessage(), Toast.LENGTH_SHORT).show();
                Log.e("Error", t.getMessage() + "");
            }
        });
    }
}