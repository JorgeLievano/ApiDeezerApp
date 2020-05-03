package com.example.apideezerapp.model;

import java.io.Serializable;

public class Album implements Serializable {

    private String title,cover;

    public Album() {
    }

    public Album(String title, String cover) {
        this.title = title;
        this.cover = cover;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCover() {
        return cover;
    }

    public void setCover(String cover) {
        this.cover = cover;
    }
}
