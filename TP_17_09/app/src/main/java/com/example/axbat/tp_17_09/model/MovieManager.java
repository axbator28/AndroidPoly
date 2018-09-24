package com.example.axbat.tp_17_09.model;

import android.annotation.TargetApi;
import android.os.Build;

import com.example.axbat.tp_17_09.R;

import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


public class MovieManager {

    private static MovieManager INSTANCE = new MovieManager();
    private int currentId;

    private List<FilmItem> movieList;

    public MovieManager(){
        movieList=new ArrayList<>();
        movieList.add(new FilmItem("Bonjour 3", "Bienvenue, on a sauté le 2", R.drawable.tp_goe, "B", 0, 0));
        movieList.add(new FilmItem("Allo1", "Le maître chef sur un anno", R.drawable.tp_movie2, "A", 0, 0));
        movieList.add(new FilmItem("Dumb and dumberer 2", "Pas malins", R.drawable.tp_goe, "D", 0, 0));
        movieList.add(new FilmItem("Allo2", "Le maître chef sur terre et un anno après", R.drawable.tp_movie2, "A", 0, 0));
        movieList.add(new FilmItem("Allo3", "Le maître chef sur un anno puis perdu dans l'espace", R.drawable.tp_movie2, "A", 0, 0));
        movieList.add(new FilmItem("Allo4", "Le maître chef se retrouve son chemin", R.drawable.tp_movie2, "A", 0, 0));
        movieList.add(new FilmItem("Bonjour", "Bienvenue", R.drawable.tp_goe, "B", 0, 0));
        movieList.add(new FilmItem("Dumb and dumberer", "Pas malins", R.drawable.tp_goe, "D", 0, 0));
    }

    public static synchronized MovieManager getInstance(){
        if(INSTANCE==null){
            INSTANCE=new MovieManager();
        }
        return INSTANCE;
    }

    public void add(FilmItem fi){
        movieList.add(fi);
    }

    public List<FilmItem> getMovies(){
        return movieList;
    }

    public FilmItem getMovieById(int id){
        return movieList.get(id);
    }

    @TargetApi(Build.VERSION_CODES.N)
    public List<FilmItem> getSortedMovieList(){

        List<FilmItem> sortedList = movieList
                .stream()
                .sorted((object1, object2) -> StringUtils.capitalize(object1.getTitre()).compareTo(StringUtils.capitalize(object2.getTitre()))).collect(Collectors.toList());
        String letter=null;
        int nbrMovies=0;
        for(int i=0; i<sortedList.size();i++){
            if(sortedList.get(i).getType()==0){
                String currentLetter = sortedList.get(i).getLettre();
                if(letter == null){
                    letter = currentLetter;
                    sortedList.add(i,new FilmItem("","", null, letter, null, 1));
                }else if(letter==currentLetter){
                    nbrMovies++;
                }else if(letter!=currentLetter){
                    sortedList.add(i,new FilmItem("","", null, null, nbrMovies, 2));
                    sortedList.add(i+1,new FilmItem("","", null, currentLetter, null, 1));
                    letter = currentLetter;
                    nbrMovies=0;
                }
            }
        }
        sortedList.add(sortedList.size(), new FilmItem("","",null,null,nbrMovies,2));
        return sortedList;

    }








}
