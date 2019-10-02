package com.example.misdaqia.Adapters;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.misdaqia.Helper.MainFontTextview;
import com.example.misdaqia.Model.Category;
import com.example.misdaqia.Model.MainCategory;
import com.example.misdaqia.R;
import com.example.misdaqia.View.Buldings;
import com.example.misdaqia.View.Cars;
import com.example.misdaqia.View.CategoryDetailsActivity;
import com.example.misdaqia.View.Jewerly;
import com.example.misdaqia.View.MazadItemDetailsActivity;
import com.example.misdaqia.View.Other;
import com.example.misdaqia.View.Vichle;
import com.squareup.picasso.Picasso;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class MainCategoriesAdapter extends RecyclerView.Adapter<MainCategoriesAdapter.MyViewHolder> {

    List<MainCategory> categories;
    Context context;
    Intent intent;

    public MainCategoriesAdapter(Context context, List<MainCategory> categories) {
        this.categories = categories;
        this.context = context;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater inflater = LayoutInflater.from(viewGroup.getContext());
        View view = inflater.inflate(R.layout.category_item, viewGroup, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, final int i) {

        holder.itemname.setText(categories.get(i).getName());

        Picasso.get().load(categories.get(i).getImage()).into(holder.imageHeader);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                intent = new Intent(context, CategoryDetailsActivity.class);

                if (i==0){
                    intent = new Intent(context, Jewerly.class);

                }else if (i==1){
                    intent = new Intent(context, Vichle.class);

                }else if (i==2){
                    intent = new Intent(context, Cars.class);

                }else if (i==3){
                    intent = new Intent(context, Buldings.class);

                }else if (i==4){
                    intent = new Intent(context, Other.class);

                }
//                intent.putExtra("category", categories.get(i));
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return categories.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        ImageView imageHeader;
        MainFontTextview itemname;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            itemname = itemView.findViewById(R.id.itemname);
            imageHeader = itemView.findViewById(R.id.imageHeader);

        }
    }
}
