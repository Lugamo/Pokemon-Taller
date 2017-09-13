package com.example.biostarh61.pokemon;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by biostar h61 on 13/09/2017.
 */

public class PokInfo {

    private static String name,front_image_url,back_image_url;
    private static JSONObject infoSprites = null;
    private static JSONObject image = null;
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
}
