package com.example.beers_api;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;

import java.lang.reflect.Type;

public class BeerSerializer implements JsonSerializer<Beer> {
    @Override
    public JsonElement serialize(Beer src, Type typeOfSrc, JsonSerializationContext context) {
        JsonObject beer = new JsonObject();
        beer.addProperty("id", src.getId());

        beer.addProperty("name", src.getName());
        beer.addProperty("shortdesc", src.getShortDescription());
        beer.addProperty("longdesc", src.getDescription());
        beer.addProperty("abv", src.getAbv());
        beer.addProperty("ibumin", src.getIbuMin());
        beer.addProperty("ibumax", src.getIbuMax());
        beer.addProperty("srmmin", src.getSrmMin());
        beer.addProperty("srmmax", src.getSrmMax());
        beer.addProperty("brewery", src.getBrewery());
        return beer;
    }
}
