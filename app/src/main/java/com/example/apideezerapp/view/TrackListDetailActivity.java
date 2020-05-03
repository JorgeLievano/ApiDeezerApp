package com.example.apideezerapp.view;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.example.apideezerapp.R;
import com.example.apideezerapp.control.TrackListControl;


public class TrackListDetailActivity extends AppCompatActivity {


    private ImageView listImgIV;
    private TextView listTitleTV,listDescrptionTV,lisItemsTV,listFansTV;
    private RecyclerView listTracksRV;
    private TrackListControl control;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_track_list_detail);

        listImgIV=findViewById(R.id.listImgIV);
        listTitleTV=findViewById(R.id.listTitleTV);
        listDescrptionTV= findViewById(R.id.listDescrptionTV);
        lisItemsTV=findViewById(R.id.listItemsTV);
        listFansTV=findViewById(R.id.listFansTV);
        listTracksRV=findViewById(R.id.listTracksRV);
        listTracksRV.setHasFixedSize(true);

        control= new TrackListControl(this);
    }

    public ImageView getListImgIV() {
        return listImgIV;
    }

    public TextView getListTitleTV() {
        return listTitleTV;
    }

    public TextView getListDescrptionTV() {
        return listDescrptionTV;
    }

    public TextView getLisItemsTV() {
        return lisItemsTV;
    }

    public TextView getListFansTV() {
        return listFansTV;
    }

    public RecyclerView getListTracksRV() {
        return listTracksRV;
    }
}
