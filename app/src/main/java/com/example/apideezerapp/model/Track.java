package com.example.apideezerapp.model;

import java.io.Serializable;
import java.util.Date;

public class Track implements Serializable {


    private String title;
    private Artist artist;
    private Album album;
    private int duration;
    private Date release_date;
    private String link;

    public Track() {
    }

    public Track(String title, Artist artist, Album album, int duration, Date release_date, String link) {
        this.title = title;
        this.artist = artist;
        this.album = album;
        this.duration = duration;
        this.release_date = release_date;
        this.link = link;
    }


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Artist getArtist() {
        return artist;
    }

    public void setArtist(Artist artist) {
        this.artist = artist;
    }

    public Album getAlbum() {
        return album;
    }

    public void setAlbum(Album album) {
        this.album = album;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public Date getRelease_date() {
        return release_date;
    }

    public void setRelease_date(Date release_date) {
        this.release_date = release_date;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getYearRelease(){
        return release_date.toString().split(" ")[5];
    }
}
