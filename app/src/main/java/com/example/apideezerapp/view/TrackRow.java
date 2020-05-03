package com.example.apideezerapp.view;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.apideezerapp.R;
import com.example.apideezerapp.model.Track;


public class TrackRow extends RecyclerView.ViewHolder {

    private ImageView trackImgRowIV;
    private TextView trackNameRowTV,trackArtisRowTV,trackYearRowTV;


    public TrackRow(@NonNull View itemView) {
        super(itemView);
        trackImgRowIV=itemView.findViewById(R.id.trackImgRowIV);
        trackNameRowTV=itemView.findViewById(R.id.trackNameRowTV);
        trackArtisRowTV=itemView.findViewById(R.id.trackArtisRowTV);
        trackYearRowTV=itemView.findViewById(R.id.trackYearRowTV);
    }


    public void setInfo(Track item){
        trackNameRowTV.setText(item.getTitle());
        trackArtisRowTV.setText(item.getArtist().getName());
        trackYearRowTV.setText(item.getYearRelease());
        Glide.with(itemView).load(item.getAlbum().getCover()).fitCenter().into(trackImgRowIV);
    }
}
