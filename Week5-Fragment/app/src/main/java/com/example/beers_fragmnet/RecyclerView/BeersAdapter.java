package com.example.beers_fragmnet.RecyclerView;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.beers_fragmnet.Beer;
import com.example.beers_fragmnet.R;

import java.util.List;


public class BeersAdapter extends RecyclerView.Adapter<BeersAdapter.BeersViewHolder> {
    private List<Beer> beers;
    public static class BeersViewHolder extends RecyclerView.ViewHolder {
        public ImageView beerImage;
        public  TextView beerName;
        public  TextView beerDesc;
        public  BeersViewHolder (View itemView){
            super(itemView);
            beerImage = itemView.findViewById(R.id.beerImageLayout);
            beerName = itemView.findViewById(R.id.beerNameLayout);
            beerDesc = itemView.findViewById(R.id.beerDescLayout);
        }
    }
    public BeersAdapter(List<Beer> b){
        beers = b;
    }
    @Override
    public BeersAdapter.BeersViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View itemView = inflater.inflate(R.layout.beer, parent,false);
        return new BeersViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(BeersViewHolder holder, int pos) {
        holder.beerName.setText(beers.get(pos).getName());
        holder.beerDesc.setText(beers.get(pos).getShortDescription());

    }

    @Override
    public int getItemCount() {
        return beers.size();
    }


}
