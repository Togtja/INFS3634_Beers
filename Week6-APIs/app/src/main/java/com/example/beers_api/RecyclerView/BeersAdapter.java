package com.example.beers_api.RecyclerView;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.beers_api.Beer;
import com.example.beers_api.R;
import com.google.gson.JsonArray;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;

import java.lang.reflect.Type;
import java.util.List;


public class BeersAdapter extends RecyclerView.Adapter<BeersAdapter.BeersViewHolder> implements JsonDeserializer<Beer> {
    private List<Beer> beers;


    @Override
    public Beer deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        JsonObject jobj = json.getAsJsonObject();
        JsonArray jsarr = jobj.getAsJsonArray("breweries");
        return new Beer(
                jobj.get("id").getAsString(),
                jobj.get("name").getAsString(),
                jobj.getAsJsonObject("style").get("name").getAsString(), //ShortDescription
                jobj.getAsJsonObject("style").get("description").getAsString(),
                jobj.get("abv").getAsDouble(),
                jobj.getAsJsonObject("style").get("ibuMin").getAsInt(),
                jobj.getAsJsonObject("style").get("ibuMax").getAsInt(),
                jobj.getAsJsonObject("style").get("srmMin").getAsInt(),
                jobj.getAsJsonObject("style").get("srmMax").getAsInt(),
                jsarr.get(0).getAsJsonObject().get("name").getAsString()
        );
    }


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
