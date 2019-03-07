package com.example.beers_recycleview;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import android.view.View;


import com.example.beers_recycleview.RecyclerView.BeersAdapter;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {
    private ArrayList<Beer> beers;
    private RecyclerView rV;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager layoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        beers =  Beer.getDummyBeers();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rV = findViewById(R.id.beerViewer);
        rV.setHasFixedSize(true);

        layoutManager = new LinearLayoutManager(this);
        rV.setLayoutManager(layoutManager);
        mAdapter = new BeersAdapter(beers);
        rV.setAdapter(mAdapter);



    }
    public void openDetailedActivity(View view){

        Beer beer_1 = beers.get(2);
        Intent intent = new Intent(this, DetailedActivity.class);

        intent.putExtra("Beer", beer_1);

        startActivity(intent);
    }

}
