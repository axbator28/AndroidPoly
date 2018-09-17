package com.example.axbat.tp_17_09.Adapters;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.axbat.tp_17_09.ViewHolders.CategoryViewHolder;
import com.example.axbat.tp_17_09.R;
import com.example.axbat.tp_17_09.model.Category;

public class CategoryAdapter extends RecyclerView.Adapter {

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View mView= LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.a_category, viewGroup,false);
        CategoryViewHolder cvh = new CategoryViewHolder(mView);
        return cvh;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int i) {
        Category currentCat = Category.values()[i];
        if(holder instanceof CategoryViewHolder && currentCat != null){
            CategoryViewHolder viewholder = (CategoryViewHolder) holder;
            viewholder.layoutForCategory(currentCat);
        }

    }

    @Override
    public int getItemCount() {
        return Category.values().length;
    }
}
