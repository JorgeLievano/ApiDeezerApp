package com.example.apideezerapp.view;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.apideezerapp.R;
import com.example.apideezerapp.model.TrackList;

public  class TrackListRow extends RecyclerView.ViewHolder {

    private TextView listNameTV,userNameTV,listItemsTV;
    private ImageView listImgSmallIV;


    public TrackListRow(@NonNull View itemView) {
        super(itemView);
        listNameTV= itemView.findViewById(R.id.listNameTV);
        userNameTV=itemView.findViewById(R.id.userNameTv);
        listItemsTV=itemView.findViewById(R.id.listItemsTV);
        listImgSmallIV=itemView.findViewById(R.id.listImgSmallIV);
        this.itemView.setTag(this);
    }


    public void setInfo(TrackList item){
        listNameTV.setText(item.getTitle());
        userNameTV.setText(item.getUser().getName());
        listItemsTV.setText(""+item.getNb_tracks());
        Glide.with(itemView).load(item.getPicture()).fitCenter().into(listImgSmallIV);
    }
}
