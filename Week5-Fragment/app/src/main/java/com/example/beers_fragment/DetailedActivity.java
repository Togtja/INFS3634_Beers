package com.example.beers_fragment;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;


public class DetailedActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detailed);

        //get the intent
        Intent intent = getIntent();
        Beer theBeer = (Beer) intent.getSerializableExtra("Beer");
        //The Beer name
        TextView beerName =findViewById(R.id.BeerName);
        beerName.setText(theBeer.getName());
        //The title
        setTitle(theBeer.getName());
        //The beer short desc
        TextView beerShortDesc = findViewById(R.id.BeerShortDesc);
        beerShortDesc.setText(theBeer.getShortDescription());
        //The beer description
        TextView beerDesc = findViewById(R.id.BeerDesc);
        beerDesc.setText(theBeer.getDescription() + '\n');
        //The ABV nr
        TextView ABVnr = findViewById(R.id.ABV_Nr);
        ABVnr.setText(Double.toString(theBeer.getAbv())+"%");
        //The IBU
        TextView ibu = findViewById(R.id.BeerIBU);
        ibu.setText("IBU: " + theBeer.getIbuMin() + " - " + theBeer.getIbuMax());
        //The SRM (I know I spelled it SMR but don't bother to fix it now)
        TextView smr = findViewById(R.id.BeerSMR);
        smr.setText("SRM: " + theBeer.getSrmMin() + " - " + theBeer.getSrmMax());
        //The brand name
        TextView brandName = findViewById(R.id.BrandName);
        brandName.setText(theBeer.getBrewery());
    }
}
