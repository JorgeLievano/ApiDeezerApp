package com.example.apideezerapp.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.apideezerapp.R;
import com.example.apideezerapp.model.Track;
import com.example.apideezerapp.view.TrackRow;

import java.util.ArrayList;


public class TrackRowAdapter extends RecyclerView.Adapter<TrackRow> {

    private ArrayList<Track> data;
   private View.OnClickListener clickListener;

   public TrackRowAdapter(ArrayList<Track> data){
       this.data=data;
   }

   public void setData(ArrayList<Track> data){
       this.data=data;
       notifyDataSetChanged();
   }

   public void addTrack(Track t){
       data.add(t);
       notifyDataSetChanged();
   }

   public void clearData(){
       data.clear();
   }

   public void setClickListener(View.OnClickListener clickListener){
       this.clickListener=clickListener;
   }


    public Track getTrack(int pos){
       return data.get(pos);
    }

    @NonNull
    @Override
    public TrackRow onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.track_row_adapter,parent,false);
        TrackRow trackRow=new TrackRow(view);
        trackRow.itemView.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        clickListener.onClick(v);
                    }
                }

        );

        return trackRow;
    }

    @Override
    public void onBindViewHolder(@NonNull TrackRow holder, int position) {
        holder.setInfo(data.get(position));
    }

    @Override
    public int getItemCount() {
        return data.size();
    }
}
