package com.example.beers_network;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.example.beers_network.RecyclerView.BeersAdapter;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity implements MainBeerFragment.OnListFragmentInteractionListener {
    private MainBeerFragment AFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

/*



        //Serialization
        Beer BeerObj = new Beer("TestID","TestName","TestShortDesc","TestDesc",1.0,2,4,5,6,"TestBrewer");
        Gson gson = new Gson();
        String json = gson.toJson(BeerObj);

        Log.d("JSON", json);
        //Deserialization
        Beer BeerObj2 = gson.fromJson(json, Beer.class);

 */



        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        AFragment = new MainBeerFragment();
        getSupportFragmentManager().beginTransaction()
                .add(R.id.ListFragment, AFragment)
                .commit();

    }



    @Override
    public void onListFragmentInteraction(int position){
        Log.d("INSIDE", "We are inside onListFragmentInteraction in MainActivity");
    }

    @Override
    public void onAttachFragment(Fragment fragment) {
        if(fragment instanceof MainBeerFragment){
            MainBeerFragment mainBeerFragment = (MainBeerFragment) fragment;
            mainBeerFragment.OnListFragmentInteractionListener(this);
        }
    }
}
