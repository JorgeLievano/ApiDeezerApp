package com.example.apideezerapp.control;

import android.content.Intent;
import android.util.Log;
import android.view.View;

import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.apideezerapp.R;
import com.example.apideezerapp.adapter.TrackListSearchAdapter;
import com.example.apideezerapp.model.SearchResult;
import com.example.apideezerapp.model.TrackList;
import com.example.apideezerapp.util.Constants;
import com.example.apideezerapp.util.HTTPSWebUtilDomi;
import com.example.apideezerapp.view.TrackListDetailActivity;
import com.example.apideezerapp.view.TrackListSearch;

import com.google.gson.Gson;

public class TrackListSearchControl implements  HTTPSWebUtilDomi.OnResponseListener, View.OnClickListener {

    private TrackListSearch trackListSearch;
    private HTTPSWebUtilDomi httpsWebUtilDomi;
    private TrackListSearchAdapter trackListSearchAdapter;


    public TrackListSearchControl(TrackListSearch trackListSearch){
        this.trackListSearch=trackListSearch;

        this.trackListSearch.getListSearchBtn().setOnClickListener(this);

        httpsWebUtilDomi= new HTTPSWebUtilDomi();
        httpsWebUtilDomi.setListener(this);


        trackListSearchAdapter=new TrackListSearchAdapter(new TrackList[0]);

        this.trackListSearch.getListFoundRV().setAdapter(trackListSearchAdapter);
        this.trackListSearch.getListFoundRV().setLayoutManager(new LinearLayoutManager(this.trackListSearch));

        trackListSearchAdapter.setClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        int pos=  trackListSearch.getListFoundRV().getChildAdapterPosition(v);
                        Intent i = new Intent(trackListSearch, TrackListDetailActivity.class);
                        i.putExtra("trackListId",trackListSearchAdapter.getTrackListID(pos));
                        trackListSearch.startActivity(i);
                    }
                }
        );
    }



    @Override
    public void onResponse(int callbackID, String response) {
        switch (callbackID){
            case Constants.TRACKLIST_SEARCH_CALLBACK:
                Gson gson= new Gson();
                SearchResult searchResult= gson.fromJson(response,SearchResult.class);
                Log.e(">>>>>",searchResult.getData()[0].getTitle());
                trackListSearch.runOnUiThread(
                        ()->{
                            trackListSearchAdapter.setData(searchResult.getData());
                            trackListSearchAdapter.notifyDataSetChanged();
                        }
                );
                break;
        }


    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.listSearchBtn:
                String trackListName=trackListSearch.getListSearchEt().getText().toString();
                new Thread(
                        ()->{
                            httpsWebUtilDomi.GETrequest(Constants.TRACKLIST_SEARCH_CALLBACK,Constants.API_SEARCH_LIST+trackListName+"");
                        }

                ).start();
                break;
        }
    }
}
