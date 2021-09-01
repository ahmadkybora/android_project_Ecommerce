package com.example.android_project_24_retrofit.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.android_project_24_retrofit.R;
import com.example.android_project_24_retrofit.activities.DetailProduct;
import com.example.android_project_24_retrofit.models.Products;
import com.squareup.picasso.Picasso;

import org.jetbrains.annotations.NotNull;

import java.util.List;

public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.ViewHolder> {

    Context context;
    List<Products> data;

    public ProductAdapter(Context context, List<Products> data) {
        this.context = context;
        this.data = data;
    }

    @NonNull
    @NotNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup viewGroup, int i) {

        View view = LayoutInflater.from(context).inflate(R.layout.item_books, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull ViewHolder ViewHolder, int i) {
        ViewHolder.txt_name_product.setText(data.get(i).getName());
        ViewHolder.txt_description_product.setText(data.get(i).getDescription());
        ViewHolder.txt_price_product.setText(data.get(i).getPrice());

        Picasso.get().load(data.get(i).getImage()).into(ViewHolder.img_products);
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView txt_name_product, txt_description_product, txt_price_product;
        ImageView img_products;

        public ViewHolder(@NonNull @NotNull View itemView) {
            super(itemView);

            txt_name_product = itemView.findViewById(R.id.txt_name_product);
            txt_description_product = itemView.findViewById(R.id.txt_description_product);
            txt_price_product = itemView.findViewById(R.id.txt_price_product);
            img_products = itemView.findViewById(R.id.img_products);

            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            Intent intent = new Intent(context, DetailProduct.class);
            intent.putExtra(DetailProduct.ID, data.get(getAdapterPosition()).getId());
            intent.putExtra("name", data.get(getAdapterPosition()).getName());
            intent.putExtra("description", data.get(getAdapterPosition()).getDescription());
            intent.putExtra("price", data.get(getAdapterPosition()).getPrice());
            //intent.putExtra("category", data.get(getAdapterPosition()).getCategoryId());
            //intent.putExtra("category", data.get(getAdapterPosition()).getProductCategory());
            intent.putExtra("image", data.get(getAdapterPosition()).getImage());
            intent.putExtra("createdAt", data.get(getAdapterPosition()).getCreatedAt());
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            context.startActivity(intent);
            //startActivity(new Intent(context, DetailProduct.class));
        }
    }
}
