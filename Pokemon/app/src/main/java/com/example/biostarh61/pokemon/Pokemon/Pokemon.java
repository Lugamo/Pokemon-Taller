package com.example.biostarh61.pokemon.Pokemon;

import com.example.biostarh61.pokemon.Factory.PokeApi;
import com.example.biostarh61.pokemon.Pokemon.PokInfo;

import org.json.JSONObject;

import java.io.Serializable;

/**
 * Created by eduardo on 21/09/17.
 */

public class Pokemon implements PokeApi{

    JSONObject data;
    @Override
    public String getInfo(JSONObject info) {
        data =info;
        return null;
    }

    @Override
    public String name() {
        return PokInfo.getID(data);
    }

    @Override
    public String front_image() {
        return PokInfo.getImageFront(data);
    }

    @Override
    public String back_image() {
        return PokInfo.getImageBack(data);
    }

    @Override
    public String weight() {
        return PokInfo.getWeight(data);
    }

    @Override
    public String powerOne() {
        return PokInfo.getPowerOne(data);
    }

    @Override
    public String powerTwo() {
        return PokInfo.getPowerTwo(data);
    }

    @Override
    public String id() {
        return PokInfo.getNumero(data);
    }
}
