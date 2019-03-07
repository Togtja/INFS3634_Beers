package com.example.beers_recycleview.RecyclerView;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.beers_recycleview.Beer;
import com.example.beers_recycleview.R;

import java.util.ArrayList;

public class BeersAdapter extends RecyclerView.Adapter<BeersAdapter.BeersViewHolder> {
    private ArrayList<Beer> beers = Beer.getDummyBeers();
    public static class BeersViewHolder extends RecyclerView.ViewHolder {
        public TextView textView;
        public  BeersViewHolder (TextView v){
            super(v);
            textView = v;
        }
    }
    public BeersAdapter(ArrayList<Beer> b){
        beers = b;
    }
    @Override
    public BeersAdapter.BeersViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
        TextView v = (TextView) LayoutInflater.from(parent.getContext())
                .inflate(R.layout.activity_main, parent, false);

        BeersViewHolder vh = new BeersViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(BeersViewHolder holder, int pos) {
        holder.textView.setText(beers.get(pos).getName());

    }

    @Override
    public int getItemCount() {
        return beers.size();
    }


}
