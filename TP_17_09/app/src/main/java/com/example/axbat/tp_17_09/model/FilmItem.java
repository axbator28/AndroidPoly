package com.example.axbat.tp_17_09.model;

public class FilmItem {
    private String Titre;
    private String Description;
    private Integer image;
    private String lettre;
    private Integer nbrMovies;
    private int type;//0=movie, 1=lettre, 2=footer

    public FilmItem(String titre, String description, Integer image,String l, Integer nbr, int t) {
        Titre = titre;
        Description = description;
        this.image = image;
        lettre=l;
        nbrMovies=nbr;
        type=t;

    }

    public String getTitre() {
        return Titre;
    }

    public void setTitre(String titre) {
        Titre = titre;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public Integer getImage() {
        return image;
    }

    public void setImage(Integer image) {
        this.image = image;
    }

    public String getLettre() {
        return lettre;
    }

    public void setLettre(String lettre) {
        this.lettre = lettre;
    }

    public Integer getNbrMovies() {
        return nbrMovies;
    }

    public void setNbrMovies(Integer nbrMovies) {
        this.nbrMovies = nbrMovies;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }
}
