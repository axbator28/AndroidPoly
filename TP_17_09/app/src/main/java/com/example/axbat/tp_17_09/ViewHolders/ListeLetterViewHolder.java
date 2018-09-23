package com.example.axbat.tp_17_09.ViewHolders;

import android.support.annotation.NonNull;
import android.view.View;
import android.widget.TextView;

import com.example.axbat.tp_17_09.R;
import com.example.axbat.tp_17_09.model.FilmItem;

public class ListeLetterViewHolder extends ListViewHolder {

    private TextView letter;

    public ListeLetterViewHolder(@NonNull View itemView) {
        super(itemView);
        this.letter=itemView.findViewById(R.id.liste_letter);
    }


    @Override
    public void layoutForListe(FilmItem f) {
        if(f.getLettre()!=null){
            letter.setText(f.getLettre());
        }
    }
}
