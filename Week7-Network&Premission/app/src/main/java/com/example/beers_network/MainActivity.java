package com.example.beers_network;


import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class MainActivity extends AppCompatActivity implements MainBeerFragment.OnListFragmentInteractionListener {
    private MainBeerFragment AFragment;
    private List<Beer> beers;

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
        //Deserialization
        Type type =  new TypeToken<List<Beer>>(){}.getType();

        Gson gsonBuilder = new GsonBuilder()
                .registerTypeAdapter(type, new BeerDeserializer())
                .create();


        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://sandbox-api.brewerydb.com/v2/")
                .addConverterFactory(GsonConverterFactory.create(gsonBuilder))
                .build();


        BeerService client = retrofit.create(BeerService.class);
        Call<List<Beer>> call = client.keyOfUser("0cafa2ad34d6df8c2e863a59c773394e", "Y");
        call.enqueue(new Callback<List<Beer>>(){

            @Override
            public void onResponse(Call<List<Beer>> call, Response<List<Beer>> response) {
                beers = new ArrayList<>();
                beers = response.body();
                setContentView(R.layout.activity_main);

                Bundle bundle = new Bundle();
                                                    //A cheat class to easily serialize a bundle
                bundle.putSerializable("key_beer", new BundleBeerArray((ArrayList<Beer>) beers).getmlist());
                AFragment = new MainBeerFragment();
                AFragment.setArguments(bundle);
                getSupportFragmentManager().beginTransaction()
                        .add(R.id.ListFragment, AFragment)
                        .commit();

            }

            @Override
            public void onFailure(Call<List<Beer>> call, Throwable t) {
                beers = Beer.getDummyBeers();
                t.printStackTrace();
                Log.d("NAY", "We called wrong func");
            }
        });


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
