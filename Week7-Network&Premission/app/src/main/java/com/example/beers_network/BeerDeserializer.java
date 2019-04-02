package com.example.beers_network;

import android.os.Debug;
import android.util.Log;

import com.example.beers_network.Beer;
import com.google.gson.JsonArray;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.google.gson.JsonSerializer;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;


public class BeerDeserializer implements JsonDeserializer<List<Beer>> {
    /*
    Tips an tricks for future self:
    Can do array of Beers
    Remember to check if it nr exist


     */
    @Override
    //Make this
    public List<Beer> deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        List<Beer> beers = new ArrayList<>();
        JsonObject jobj = json.getAsJsonObject();
        JsonArray jsarr = jobj.get("data").getAsJsonArray();
        //JsonArray jsarr = jobj.getAsJsonArray("breweries");
        for (int i = 0; i < jsarr.size(); i++){
            JsonObject aBeer = jsarr.get(i).getAsJsonObject();

            if(aBeer == null ){
                continue;
            }
            if(aBeer.getAsJsonObject("style") == null ){
                continue;
            }

             beers.add(new Beer(
                     aBeer.get("id").getAsString(),
                     aBeer.get("name").getAsString(),
                     aBeer.getAsJsonObject("style").get("name").getAsString(), //ShortDescription
                     aBeer.getAsJsonObject("style").get("description").getAsString(),
                     aBeer.get("abv").getAsDouble(),
                     aBeer.getAsJsonObject("style").get("ibuMin").getAsInt(),
                     aBeer.getAsJsonObject("style").get("ibuMax").getAsInt(),
                     aBeer.getAsJsonObject("style").get("srmMin").getAsInt(),
                     aBeer.getAsJsonObject("style").get("srmMax").getAsInt(),
                     aBeer.getAsJsonArray("breweries").get(0).getAsJsonObject().get("name").getAsString()
                    //jsarr.get(0).getAsJsonObject().get("name").getAsString()
            ));
        }
        return beers;
    }
}
