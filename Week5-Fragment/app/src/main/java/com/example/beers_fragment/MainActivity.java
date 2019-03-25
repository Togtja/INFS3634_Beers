package com.example.beers_fragment;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity implements MainBeerFragment.OnListFragmentInteractionListener {
    private List<Beer> beers = new ArrayList<>();
    private MainBeerFragment AFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        beers = Beer.getDummyBeers();
        setContentView(R.layout.activity_main);

        AFragment = new MainBeerFragment();
        getSupportFragmentManager().beginTransaction()
                .add(R.id.ListFragment, AFragment)
                .commit();

    }



    @Override
    public void onListFragmentInteraction(int position){
        Log.d("INSIDE", "We are inside onListFragmentInteraction in MainActivity");
        Intent intent = new Intent(this, DetailedActivity.class);
        Beer theBeer = beers.get(position);
        intent.putExtra("Beer", theBeer);
        startActivity(intent);
    }

    @Override
    public void onAttachFragment(Fragment fragment) {
        if(fragment instanceof MainBeerFragment){
            MainBeerFragment mainBeerFragment = (MainBeerFragment) fragment;
            mainBeerFragment.OnListFragmentInteractionListener(this);
        }
    }
}
