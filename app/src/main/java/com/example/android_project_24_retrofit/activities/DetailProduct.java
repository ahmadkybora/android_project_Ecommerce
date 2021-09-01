package com.example.android_project_24_retrofit.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.android_project_24_retrofit.R;
import com.squareup.picasso.Picasso;

public class DetailProduct extends AppCompatActivity {

    public static final String ID = "id";
    int id;
    Bundle bundle;
    TextView txt_name_product, txt_description_product, txt_price_product, txt_category, txt_create_product;
    ImageView img_product;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_product);
        id = Integer.parseInt(getIntent().getStringExtra(ID));

        Toast.makeText(this, "" + id, Toast.LENGTH_SHORT).show();
        initViews();
    }

    private void initViews() {
        bundle = getIntent().getExtras();
        txt_name_product = findViewById(R.id.txt_name_product);
        txt_description_product = findViewById(R.id.txt_description_product);
        txt_price_product = findViewById(R.id.txt_price_product);
        txt_category = findViewById(R.id.txt_category);
        img_product = findViewById(R.id.img_product);
        txt_create_product = findViewById(R.id.txt_create_product);

        txt_name_product.setText(bundle.getString("name"));
        txt_description_product.setText(bundle.getString("description"));
        txt_price_product.setText(new StringBuilder("Price: ") + bundle.getString("price"));
        txt_category.setText(bundle.getString("category"));
        txt_create_product.setText(new StringBuilder("CreatedAt: ") + bundle.getString("createdAt"));

        Picasso.get().load(bundle.getString("image")).into(img_product);
    }
}