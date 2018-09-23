package com.example.axbat.tp_17_09.Adapters;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.axbat.tp_17_09.R;
import com.example.axbat.tp_17_09.ViewHolders.CategoryViewHolder;
import com.example.axbat.tp_17_09.ViewHolders.CommentViewHolder;
import com.example.axbat.tp_17_09.model.Category;
import com.example.axbat.tp_17_09.model.Commentaire;

import java.util.List;

public class CommentAdapter extends RecyclerView.Adapter{

    private List<Commentaire> mComments;

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View mView= LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.a_comment, viewGroup,false);
        CommentViewHolder cvh = new CommentViewHolder(mView);
        return cvh;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int i) {
        Commentaire currentCom = mComments.get(i);
        if(holder instanceof CommentViewHolder && currentCom != null){
            CommentViewHolder viewholder = (CommentViewHolder) holder;
            viewholder.layoutForCategory(currentCom);
        }

    }

    @Override
    public int getItemCount() {
        return mComments.size();
    }

    public void setmComments(List<Commentaire> mComments) {
        this.mComments = mComments;
    }
}
