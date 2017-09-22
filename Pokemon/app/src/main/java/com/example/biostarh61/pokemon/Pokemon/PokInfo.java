package com.example.biostarh61.pokemon.Pokemon;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by biostar h61 on 13/09/2017.
 */

public class PokInfo {

    private static String name,front_image_url,back_image_url,power,peso,numero;
    private static String[] namepower = new String[2];
    private static JSONObject infoSprites = null;
    private static JSONObject image = null;
    private static JSONArray abilities = null;
    public static String getID(JSONObject info){
        try {
            name = info.getString("name");
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return name;
    }
    public static JSONObject getSprites(JSONObject info){
        infoSprites = null;
        try {
            infoSprites = info.getJSONObject("sprites");
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return infoSprites;
    }
    public static String getImageFront(JSONObject info){
        image = null;
        image = PokInfo.getSprites(info);
        try {
            front_image_url = image.getString("front_default");
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return front_image_url;
    }
    public static String getImageBack(JSONObject info){
        image = null;
        image = PokInfo.getSprites(info);
        try {
            back_image_url = image.getString("back_default");
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return back_image_url;
    }
    public static String getAbilities(JSONObject info, int num){
        try {
            abilities = info.getJSONArray("abilities");

            for (int i = 0; i < 2; i++) {
                JSONObject c = abilities.getJSONObject(i);
                // Ability node is JSON Object
                JSONObject ability = c.getJSONObject("ability");
                namepower[i] = ability.getString("name");


            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return namepower[num];
    }
    public static String getPowerOne (JSONObject info){
        power = PokInfo.getAbilities(info,0);

        return power;
    }
    public static String getPowerTwo (JSONObject info){
        power = PokInfo.getAbilities(info,1);

        return power;
    }
    public static String getWeight(JSONObject info){
        try {
            peso = info.getString("weight");
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return peso;
    }
    public static  String getNumero(JSONObject info)
    {
        try {
            numero = info.getString("id");
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return numero;
    }

}
