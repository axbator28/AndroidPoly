package com.example.axbat.tp_17_09.model;


public class Commentaire {
    private String username;
    private Integer userImage;
    private String comment;

    public Commentaire(String name, int image, String com){
        this.username=name;
        this.userImage=image;
        this.comment=com;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Integer getUserImage() {
        return userImage;
    }

    public void setUserImage(int userImage) {
        this.userImage = userImage;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}
