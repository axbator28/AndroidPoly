package com.example.axbat.tp_17_09.ViewHolders;

import android.support.annotation.NonNull;
import android.view.View;
import android.widget.TextView;

import com.example.axbat.tp_17_09.R;
import com.example.axbat.tp_17_09.model.FilmItem;

public class ListFooterViewHolder extends ListViewHolder {

    private TextView footer;


    public ListFooterViewHolder(@NonNull View itemView) {
        super(itemView);
        this.footer=itemView.findViewById(R.id.liste_footer);
    }

    @Override
    public void layoutForListe(FilmItem item) {
        if(item.getNbrMovies()!=null){
            footer.setText(item.getNbrMovies() + " films");
        }
    }

}
