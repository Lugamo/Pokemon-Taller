package com.example.biostarh61.pokemon.Factory;

import com.example.biostarh61.pokemon.Pokemon.Pokemon;

/**
 * Created by eduardo on 21/09/17.
 */

public class PokeApiFactory {
    public PokeApi getResource(String resource){

        if (resource == "Pokemon"){
            return new Pokemon();
        }
        return null;
    }
}
