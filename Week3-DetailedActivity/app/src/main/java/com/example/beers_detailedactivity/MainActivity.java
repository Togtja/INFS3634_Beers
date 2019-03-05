package com.example.beers_detailedactivity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void openDetailedActivity(View view){
        ArrayList<Beer> beers =  Beer.getDummyBeers();
        Beer beer_1 = beers.get(2);
        Intent intent = new Intent(this, DetailedActivity.class);

        intent.putExtra("Beer", beer_1);

        startActivity(intent);
    }
}
