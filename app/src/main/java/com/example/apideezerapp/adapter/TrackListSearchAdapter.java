package com.example.apideezerapp.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.apideezerapp.R;
import com.example.apideezerapp.model.TrackList;
import com.example.apideezerapp.view.TrackListRow;


public class TrackListSearchAdapter extends RecyclerView.Adapter<TrackListRow> {

    private TrackList[] data;
    private View.OnClickListener clickListener;

    public TrackListSearchAdapter(TrackList[] data){
        this.data=data;
    }

    public void setData(TrackList[] data) {
        this.data = data;
        notifyDataSetChanged();
    }



    public void setClickListener(View.OnClickListener clickListener) {
        this.clickListener = clickListener;
    }

    public long getTrackListID(int pos){
        return data[pos].getId();
    }

    @NonNull
    @Override
    public TrackListRow onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.track_list_row_adapter,parent,false);
        TrackListRow trackListRow= new TrackListRow(view);
        trackListRow.itemView.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        clickListener.onClick(v);
                    }
                }
        );

        return trackListRow;
    }

    @Override
    public void onBindViewHolder(@NonNull TrackListRow holder, int position) {
        holder.setInfo(data[position]);

    }

    @Override
    public int getItemCount() {
        return data.length;
    }





}
