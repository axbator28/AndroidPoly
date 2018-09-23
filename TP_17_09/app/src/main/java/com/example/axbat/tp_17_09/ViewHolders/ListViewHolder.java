package com.example.axbat.tp_17_09.ViewHolders;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.example.axbat.tp_17_09.model.FilmItem;

public abstract class ListViewHolder extends RecyclerView.ViewHolder {

    public ListViewHolder(@NonNull View itemView) {
        super(itemView);
    }

    public abstract void layoutForListe(FilmItem item);

}
