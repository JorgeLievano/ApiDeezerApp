package com.example.apideezerapp.model;

public class SearchResult {

    private TrackList[] data;

    public SearchResult() {
    }

    public SearchResult(TrackList[] data) {
        this.data = data;
    }

    public TrackList[] getData() {
        return data;
    }

    public void setData(TrackList[] data) {
        this.data = data;
    }
}
