package com.example.axbat.tp_17_09.Activities;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import com.example.axbat.tp_17_09.Adapters.CategoryAdapter;
import com.example.axbat.tp_17_09.Adapters.ListeAdapter;
import com.example.axbat.tp_17_09.R;
import com.example.axbat.tp_17_09.model.Category;
import com.example.axbat.tp_17_09.model.FilmItem;
import com.example.axbat.tp_17_09.model.MovieManager;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ListeActivity extends Activity{

    private RecyclerView mRecyclerView;
    private List<FilmItem> mFilmItems;
    private ImageButton cross;
    private Button backButton;
    private Category[] mCategories;
    private Button cateBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        mCategories=Category.values();

        this.cross=findViewById(R.id.widget_Cross);
        this.cross.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v){
                finish();
            }
        });
        this.backButton=findViewById(R.id.widget_Button);
        this.backButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v){
                finish();
            }
        });

        mFilmItems = new ArrayList<>();

        mFilmItems = MovieManager.getInstance().getSortedMovieList();


        this.mRecyclerView=findViewById(R.id.recycler_list);
        ListeAdapter cAdapter = new ListeAdapter();
        cAdapter.setmListe(mFilmItems);
        this.mRecyclerView.setAdapter(cAdapter);
        this.mRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        this.cateBtn=findViewById(R.id.to_cate);

        this.cateBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ListeActivity.this, CategoriesActivity.class);
                startActivity(intent);
            }
        });



    }

    @TargetApi(Build.VERSION_CODES.N)
    public void sortList(){
         mFilmItems = mFilmItems
                .stream()
                .sorted((object1, object2) -> object1.getTitre().compareTo(object2.getTitre())).collect(Collectors.toList());

         String letter=null;
         int nbrMovies=0;
         for(int i=0; i<mFilmItems.size();i++){
             if(mFilmItems.get(i).getType()==0){
                 String currentLetter = mFilmItems.get(i).getLettre();
                 if(letter == null){
                     letter = currentLetter;
                     mFilmItems.add(i,new FilmItem("","", null, letter, null, 1));
                 }else if(letter==currentLetter){
                     nbrMovies++;
                 }else if(letter!=currentLetter){
                     mFilmItems.add(i,new FilmItem("","", null, null, nbrMovies, 2));
                     mFilmItems.add(i+1,new FilmItem("","", null, currentLetter, null, 1));
                     letter = currentLetter;
                     nbrMovies=0;
                 }
            }
         }
         mFilmItems.add(mFilmItems.size(), new FilmItem("","",null,null,nbrMovies,2));
    }
}
