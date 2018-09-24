package com.example.axbat.tp_17_09.model;

import java.util.ArrayList;
import java.util.List;

public class MovieManager {

    private static MovieManager INSTANCE = new MovieManager();

    private List<FilmItem> movieList;

    public MovieManager(){
        movieList=new ArrayList<>();
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





}
