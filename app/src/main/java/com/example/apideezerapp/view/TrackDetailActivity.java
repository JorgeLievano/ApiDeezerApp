package com.example.apideezerapp.view;

import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.apideezerapp.R;
import com.example.apideezerapp.control.TrackControl;


public class TrackDetailActivity extends AppCompatActivity {

    private ImageView trackImgIV;
    private TextView trackNameTV,trackArtistTV,trackAlbumTV,trackDurationTV;
    private Button trackHearBtn;
    private TrackControl control;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_track_detail);

        trackImgIV=findViewById(R.id.trackImgIV);
        trackNameTV=findViewById(R.id.trackNameTV);
        trackArtistTV=findViewById(R.id.trackArtistTV);
        trackAlbumTV=findViewById(R.id.trackAlbumTV);
        trackDurationTV=findViewById(R.id.trackDurationTV);
        trackHearBtn=findViewById(R.id.trackHearBtn);


        control=new TrackControl(this);
    }

    public ImageView getTrackImgIV() {
        return trackImgIV;
    }

    public TextView getTrackNameTV() {
        return trackNameTV;
    }

    public TextView getTrackArtistTV() {
        return trackArtistTV;
    }

    public TextView getTrackAlbumTV() {
        return trackAlbumTV;
    }

    public TextView getTrackDurationTV() {
        return trackDurationTV;
    }

    public Button getTrackHearBtn() {
        return trackHearBtn;
    }
}
