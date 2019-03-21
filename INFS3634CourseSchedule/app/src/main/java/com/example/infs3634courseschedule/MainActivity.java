package com.example.infs3634courseschedule;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {


    private RecyclerView rV;
    private timeTableAdapter mAdapter;
    private ArrayList<INFS3634Info> schedule = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        schedule = INFS3634Info.getSchedule();
        rV = findViewById(R.id.timeTable);
        mAdapter = new timeTableAdapter(schedule);
        rV.setAdapter(mAdapter);
    }
}
