package com.example.apideezerapp.model;

public class TrackResumeContainer {

    TrackResume[] data;

    public TrackResumeContainer() {
    }

    public TrackResumeContainer(TrackResume[] data) {
        this.data = data;
    }

    public TrackResume[] getData() {
        return data;
    }

    public void setData(TrackResume[] data) {
        this.data = data;
    }
}
