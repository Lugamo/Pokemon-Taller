package com.example.biostarh61.pokemon.Factory;

import org.json.JSONObject;

/**
 * Created by eduardo on 21/09/17.
 */

public interface PokeApi {
        String getInfo(JSONObject info);
        String name();
        String front_image();
        String back_image();
        String weight();
        String powerOne();
        String powerTwo();
        String id();

}
