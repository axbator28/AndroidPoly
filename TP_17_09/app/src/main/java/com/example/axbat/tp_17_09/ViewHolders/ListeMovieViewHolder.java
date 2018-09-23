package com.example.axbat.tp_17_09.ViewHolders;

import android.annotation.TargetApi;
import android.os.Build;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.axbat.tp_17_09.R;
import com.example.axbat.tp_17_09.model.FilmItem;

public class ListeMovieViewHolder extends ListViewHolder{

    private ImageView image;
    private TextView title;
    private TextView description;

    public ListeMovieViewHolder(@NonNull View itemView) {
        super(itemView);
        this.image=itemView.findViewById(R.id.liste_image);
        this.title=itemView.findViewById(R.id.liste_title);
        this.description=itemView.findViewById(R.id.liste_desc);
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public void layoutForListe(FilmItem f){
            if(f.getDescription()!=null){
                description.setText(f.getDescription());
            }
            if(f.getTitre()!=null){
                title.setText(f.getTitre());
            }
            if(f.getImage()!=null){
                image.setImageResource(f.getImage());
                image.setImageTintList(null);
            }
    }


}
