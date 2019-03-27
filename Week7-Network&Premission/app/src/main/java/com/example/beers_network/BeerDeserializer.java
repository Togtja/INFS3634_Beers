package com.example.beers_network;

import com.example.beers_network.Beer;
import com.google.gson.JsonArray;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.google.gson.JsonSerializer;

import java.lang.reflect.Type;


public class BeerDeserializer implements JsonDeserializer<Beer> {
    /*
    Tips an tricks for future self:
    Can do array of Beers
    Remember to check if it nr exist


     */
    @Override
    public Beer deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        JsonObject jobj = json.getAsJsonObject();
       //JsonArray jsarr = jobj.getAsJsonArray("breweries");
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
            jobj.getAsJsonArray("breweries").get(0).getAsJsonObject().get("name").getAsString()
            //jsarr.get(0).getAsJsonObject().get("name").getAsString()
        );
    }
}
