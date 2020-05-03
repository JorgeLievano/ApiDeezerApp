package com.example.apideezerapp.model;

public class TrackListDetail {

    private String title;
    private String picture;
    private String description;
    private int nb_tracks;
    private int fans;
    private String tracklist;
    private TrackResumeContainer tracks;

    public TrackListDetail() {
    }

    public TrackListDetail(String title, String picture, String description, int nb_tracks, int fans, String tracklist, TrackResumeContainer tracks) {
        this.title = title;
        this.picture = picture;
        this.description = description;
        this.nb_tracks = nb_tracks;
        this.fans = fans;
        this.tracklist = tracklist;
        this.tracks = tracks;
    }

    public TrackResumeContainer getTracks() {
        return tracks;
    }

    public void setTracks(TrackResumeContainer tracks) {
        this.tracks = tracks;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getNb_tracks() {
        return nb_tracks;
    }

    public void setNb_tracks(int nb_tracks) {
        this.nb_tracks = nb_tracks;
    }

    public int getFans() {
        return fans;
    }

    public void setFans(int fans) {
        this.fans = fans;
    }

    public String getTracklist() {
        return tracklist;
    }

    public void setTracklist(String tracklist) {
        this.tracklist = tracklist;
    }
}
