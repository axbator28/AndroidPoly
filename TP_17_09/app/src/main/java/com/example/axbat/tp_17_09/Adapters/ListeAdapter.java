package com.example.axbat.tp_17_09.Adapters;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.axbat.tp_17_09.R;
import com.example.axbat.tp_17_09.ViewHolders.ListFooterViewHolder;
import com.example.axbat.tp_17_09.ViewHolders.ListeLetterViewHolder;
import com.example.axbat.tp_17_09.ViewHolders.ListeMovieViewHolder;
import com.example.axbat.tp_17_09.ViewHolders.ListViewHolder;
import com.example.axbat.tp_17_09.model.FilmItem;

import java.util.List;

public class ListeAdapter extends RecyclerView.Adapter {


    final int MOVIE = 0;
    final int LETTER = 1;
    final int FOOTER = 2;

    private List<FilmItem> mListe;

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        if (viewType == MOVIE) {
            View mView = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.a_listmovie, viewGroup, false);
            ListeMovieViewHolder vh = new ListeMovieViewHolder(mView);
            return vh;
        } else if (viewType == LETTER) {
            View mView = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.a_listletter, viewGroup, false);
            ListeLetterViewHolder vh = new ListeLetterViewHolder(mView);
            return vh;
        } else if (viewType == FOOTER) {
            View mView = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.a_listfooter, viewGroup, false);
            ListFooterViewHolder vh = new ListFooterViewHolder(mView);
            return vh;
        }
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int i) {
        FilmItem currentMovieList = mListe.get(i);
        if (holder instanceof ListViewHolder && currentMovieList != null) {
            ListViewHolder viewHolder = (ListViewHolder) holder;
            viewHolder.layoutForListe(currentMovieList);
        }
    }

    @Override
    public int getItemCount() {
        return mListe.size();
    }


    @Override

    public int getItemViewType(int position) {
        if (mListe != null) {
            FilmItem f = mListe.get(position);
            switch (f.getType()) {
                case 0:
                    return MOVIE;
                case 1:
                    return LETTER;
                case 2:
                    return FOOTER;
            }
        }
        return 0;
    }

    public void setmListe(List<FilmItem> mListe) {
        this.mListe = mListe;
    }
}
