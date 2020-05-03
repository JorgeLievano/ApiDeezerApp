package com.example.apideezerapp.model;

public class TrackList {
    private String title,picture_medium,picture_small,picture;
    private int nb_tracks;
    private User user;
    private long id;
    private String tracklist;

    public TrackList() {
    }

    public TrackList(String title, String picture_medium, String picture_small, String picture, int nb_tracks, User user, int id, String tracklist) {
        this.title = title;
        this.picture_medium = picture_medium;
        this.picture_small = picture_small;
        this.picture = picture;
        this.nb_tracks = nb_tracks;
        this.user = user;
        this.id = id;
        this.tracklist = tracklist;
    }

    public String getTracklist() {
        return tracklist;
    }

    public void setTracklist(String tracklist) {
        this.tracklist = tracklist;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPicture_medium() {
        return picture_medium;
    }

    public void setPicture_medium(String picture_medium) {
        this.picture_medium = picture_medium;
    }

    public String getPicture_small() {
        return picture_small;
    }

    public void setPicture_small(String picture_small) {
        this.picture_small = picture_small;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public int getNb_tracks() {
        return nb_tracks;
    }

    public void setNb_tracks(int nb_tracks) {
        this.nb_tracks = nb_tracks;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
