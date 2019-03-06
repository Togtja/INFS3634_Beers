package com.example.directionrandomizer;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    Random rand = new Random();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    //Displays one of the directions
    public void randomDirection(View view){


        //Random number from 0-3
        int rndNr = rand.nextInt(4);
        float angle = 0.f;

        //If rndNr is 0 then we just go past the switch and angle = 0.f
        //Aka same direction
        switch (rndNr){
            case 1:
                angle = 90.f;
                break;
            case 2:
                angle = 180.f;
                break;
            case 3:
                angle = 270.f;
                break;
        }
        ImageView imageView =findViewById(R.id.Arrow);
        imageView.setRotation(angle);

    }
}
