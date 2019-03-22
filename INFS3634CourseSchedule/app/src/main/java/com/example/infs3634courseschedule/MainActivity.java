package com.example.infs3634courseschedule;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import java.text.ParseException;
import java.util.ArrayList;

//Inspiration taken from JacobSamro's Expandable RecyclerView
// https://github.com/Aroliant/Expandable-RecyclerView-Android

public class MainActivity extends AppCompatActivity {


    private RecyclerView rV;
    private TimeTableAdapter mAdapter;
    private ArrayList<INFS3634Info> schedule = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        try {
            schedule = INFS3634Info.getSchedule();
        } catch (ParseException e) {
            e.printStackTrace();
        }

        rV = findViewById(R.id.timeTable);
        rV.setHasFixedSize(true);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        rV.setLayoutManager(layoutManager);
        mAdapter = new TimeTableAdapter(schedule);
        rV.setAdapter(mAdapter);
    }
}
