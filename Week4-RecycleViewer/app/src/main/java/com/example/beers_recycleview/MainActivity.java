package com.example.beers_recycleview;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import android.view.View;


import com.example.beers_recycleview.RecyclerView.BeersAdapter;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity {
    private List<Beer> beers = new ArrayList<Beer>();
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
        openDetailedActivity(rV);



    }

    public void openDetailedActivity(View view){
        final Intent intent = new Intent(this, DetailedActivity.class);
        rV.addOnItemTouchListener(
                new RecyclerItemClickListener(this, rV ,new RecyclerItemClickListener.OnItemClickListener() {
                    @Override
                    public void onItemClick(View view, int position) {
                        Beer theBeer = beers.get(position);
                        intent.putExtra("Beer", theBeer);
                        startActivity(intent);

                    }

                    @Override
                    public void onLongItemClick(View view, int position) {
                        //Do on long click
                    }
                })
        );
    }

}
