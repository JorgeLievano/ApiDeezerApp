package com.example.apideezerapp.control;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

import com.bumptech.glide.Glide;
import com.example.apideezerapp.R;
import com.example.apideezerapp.model.Track;
import com.example.apideezerapp.view.TrackDetailActivity;

public class TrackControl implements View.OnClickListener {

    private TrackDetailActivity activity;
    Uri uri;

    public TrackControl(TrackDetailActivity trackDetailActivity){
        activity=trackDetailActivity;
        uri= Uri.parse("https://www.deezer.com/es/");
        init();
    }

    private void init(){
        Bundle bundle=activity.getIntent().getExtras();
        Track track= null;
        if(bundle!=null){
            track=(Track) bundle.getSerializable("track");


            activity.getTrackNameTV().setText(""+track.getTitle());
            activity.getTrackAlbumTV().setText("Album: "+track.getAlbum().getTitle());
            activity.getTrackArtistTV().setText("Artista: "+track.getArtist().getName());
            activity.getTrackDurationTV().setText("Duración: "+track.durantionMinSec());
            Glide.with(activity).load(track.getAlbum().getCover()).fitCenter().into(activity.getTrackImgIV());
            activity.getTrackHearBtn().setOnClickListener(this);
            uri=Uri.parse(track.getLink());
        }


    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.trackHearBtn:
                Intent i =new Intent(Intent.ACTION_VIEW,uri);
                activity.startActivity(i);
                break;
        }
    }
}
