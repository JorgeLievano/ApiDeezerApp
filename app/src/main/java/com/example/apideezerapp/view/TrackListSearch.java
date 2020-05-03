package com.example.apideezerapp.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.ImageButton;

import com.example.apideezerapp.R;
import com.example.apideezerapp.control.TrackListSearchControl;

public class TrackListSearch extends AppCompatActivity {

    private EditText listSearchEt;
    private ImageButton listSearchBtn;
    private RecyclerView listFoundRV;
    private TrackListSearchControl trackListSearchControl;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listSearchEt=findViewById(R.id.listSearchET);
        listSearchBtn=findViewById(R.id.listSearchBtn);
        listFoundRV=findViewById(R.id.listFoundRV);
        listFoundRV.setHasFixedSize(true);

        trackListSearchControl=new TrackListSearchControl(this);
    }

    public EditText getListSearchEt() {
        return listSearchEt;
    }

    public ImageButton getListSearchBtn() {
        return listSearchBtn;
    }

    public RecyclerView getListFoundRV() {
        return listFoundRV;
    }
}
