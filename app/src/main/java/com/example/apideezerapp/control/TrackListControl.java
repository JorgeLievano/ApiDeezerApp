package com.example.apideezerapp.control;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.recyclerview.widget.LinearLayoutManager;

import com.bumptech.glide.Glide;
import com.example.apideezerapp.adapter.TrackRowAdapter;
import com.example.apideezerapp.model.Track;
import com.example.apideezerapp.model.TrackListDetail;
import com.example.apideezerapp.model.TrackResume;
import com.example.apideezerapp.model.TrackResumeContainer;
import com.example.apideezerapp.util.Constants;
import com.example.apideezerapp.util.HTTPSWebUtilDomi;
import com.example.apideezerapp.view.TrackDetailActivity;
import com.example.apideezerapp.view.TrackListDetailActivity;

import com.google.gson.Gson;

import java.util.ArrayList;

public class TrackListControl implements  HTTPSWebUtilDomi.OnResponseListener{

    private TrackListDetailActivity activity;
    private HTTPSWebUtilDomi utilDomi;
    private TrackRowAdapter adapter;
    private ArrayList<Track> data;

    public TrackListControl(TrackListDetailActivity trackDetailActivity){
        activity=trackDetailActivity;
        utilDomi= new HTTPSWebUtilDomi();
        utilDomi.setListener(this);
        data=new ArrayList<Track>();
        adapter=new TrackRowAdapter(data);

        activity.getListTracksRV().setAdapter(adapter);
        activity.getListTracksRV().setLayoutManager(new LinearLayoutManager(activity));
        adapter.setClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        int pos = activity.getListTracksRV().getChildAdapterPosition(v);
                        Track track =adapter.getTrack(pos);
                        Intent i= new Intent(activity, TrackDetailActivity.class);
                        Bundle bundle= new Bundle();
                        bundle.putSerializable("track",track);
                        i.putExtras(bundle);
                        activity.startActivity(i);

                    }
                }
        );

        init();
    }

    private void init(){
        long tracklistId=(long)activity.getIntent().getExtras().get("trackListId");
        new Thread(
                ()->{
                    utilDomi.GETrequest(Constants.TRACKLIST_SEARCH_DETAIL_CALLBACK,Constants.API_SEARCH_LIST_DETAILS+tracklistId);
                }
        ).start();
    }


    private void seacrhTracks(TrackResumeContainer container){
        adapter.clearData();
        new Thread(
                ()->{
                    for (TrackResume r :container.getData()) {
                        utilDomi.GETrequest(Constants.TRACK_SEARCH_DETAIL_CALLBACK,Constants.API_SEARCH_TRACK_DETAILS+r.getId());
                    }

                }
        ).start();

    }

    @Override
    public void onResponse(int callbackID, String response) {
        Gson gson=new Gson();
        switch (callbackID){
            case Constants.TRACKLIST_SEARCH_DETAIL_CALLBACK:
                TrackListDetail list=gson.fromJson(response,TrackListDetail.class);
                seacrhTracks(list.getTracks());
                activity.runOnUiThread(
                        ()->{
                            activity.getListTitleTV().setText(list.getTitle());
                            String description=(list.getDescription().equals(""))? "No Description":list.getDescription();
                            activity.getListDescrptionTV().setText(description);
                            activity.getListFansTV().setText("Fans "+list.getFans());
                            activity.getLisItemsTV().setText("Tracks "+list.getNb_tracks());
                            Glide.with(activity).load(list.getPicture()).fitCenter().into(activity.getListImgIV());
                        }
                );
                break;
            case Constants.TRACK_SEARCH_DETAIL_CALLBACK:
                Track t=gson.fromJson(response,Track.class);
                activity.runOnUiThread(
                        ()->{
                            adapter.addTrack(t);
                        }
                );

                break;
        }
    }
}
