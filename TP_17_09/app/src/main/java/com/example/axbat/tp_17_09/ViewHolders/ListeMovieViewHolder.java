package com.example.axbat.tp_17_09.ViewHolders;

import android.annotation.TargetApi;
import android.app.ListActivity;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.axbat.tp_17_09.Activities.CategoriesActivity;
import com.example.axbat.tp_17_09.Activities.ListeActivity;
import com.example.axbat.tp_17_09.Activities.MainActivity;
import com.example.axbat.tp_17_09.R;
import com.example.axbat.tp_17_09.model.FilmItem;

public class ListeMovieViewHolder extends ListViewHolder{

    private ImageView image;
    private TextView title;
    private TextView description;
    private ImageButton linkButton;

    private Context context;

    public ListeMovieViewHolder(@NonNull View itemView) {
        super(itemView);
        this.context=itemView.getContext();
        this.image=itemView.findViewById(R.id.liste_image);
        this.title=itemView.findViewById(R.id.liste_title);
        this.description=itemView.findViewById(R.id.liste_desc);
        this.linkButton=itemView.findViewById(R.id.movie_btn);
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public void layoutForListe(FilmItem f){
        Intent btnIntent = new Intent(context, MainActivity.class);
        if(f!=null) {
            if (f.getDescription() != null) {
                description.setText(f.getDescription());
                btnIntent.putExtra("DESC", f.getDescription());
            }
            if (f.getTitre() != null) {
                title.setText(f.getTitre());
                btnIntent.putExtra("TITRE", f.getTitre());
            }
            if (f.getImage() != null) {
                image.setImageResource(f.getImage());
                image.setImageTintList(null);
                btnIntent.putExtra("IMAGE", f.getImage());
            }
            this.linkButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    context.startActivity(btnIntent);
                }
            });
        }


    }

    public Context getContext(){
        return context;
    }


}
