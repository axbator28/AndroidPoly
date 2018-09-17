package com.example.axbat.tp_17_09.ViewHolders;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.example.axbat.tp_17_09.R;
import com.example.axbat.tp_17_09.model.Category;

public class CategoryViewHolder extends RecyclerView.ViewHolder {

    private TextView categoryName;

    public CategoryViewHolder(@NonNull View itemView) {
        super(itemView);
        this.categoryName=itemView.findViewById(R.id.cat_name);
    }

    public void layoutForCategory(Category cat){
        if(cat!=null){
            categoryName.setText(cat.name());
        }
    }
}
