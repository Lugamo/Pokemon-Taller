package com.example.biostarh61.pokemon.Pokemon;

import android.nfc.Tag;

import org.json.JSONObject;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by eduardo on 3/10/17.
 */
public class PokInfoTest {

    @Test
    public void getID() throws Exception {
        String js = "{\"forms\":[{\"url\":\"https:\\/\\/pokeapi.co\\/api\\/v2\\/pokemon-form\\/1\\/\",\"name\":\"bulbasaur\"}],\"abilities\":[{\"slot\":3,\"is_hidden\":true,\"ability\":{\"url\":\"https:\\/\\/pokeapi.co\\/api\\/v2\\/ability\\/34\\/\",\"name\":\"chlorophyll\"}},{\"slot\":1,\"is_hidden\":false,\"ability\":{\"url\":\"https:\\/\\/pokeapi.co\\/api\\/v2\\/ability\\/65\\/\",\"name\":\"overgrow\"}}],\"stats\":[{\"stat\":{\"url\":\"https:\\/\\/pokeapi.co\\/api\\/v2\\/stat\\/6\\/\",\"name\":\"speed\"},\"effort\":0,\"base_stat\":45},{\"stat\":{\"url\":\"https:\\/\\/pokeapi.co\\/api\\/v2\\/stat\\/5\\/\",\"name\":\"special-defense\"},\"effort\":0,\"base_stat\":65},{\"stat\":{\"url\":\"https:\\/\\/pokeapi.co\\/api\\/v2\\/stat\\/4\\/\",\"name\":\"special-attack\"},\"effort\":1,\"base_stat\":65},{\"stat\":{\"url\":\"https:\\/\\/pokeapi.co\\/api\\/v2\\/stat\\/3\\/\",\"name\":\"defense\"},\"effort\":0,\"base_stat\":49},{\"stat\":{\"url\":\"https:\\/\\/pokeapi.co\\/api\\/v2\\/stat\\/2\\/\",\"name\":\"attack\"},\"effort\":0,\"base_stat\":49},{\"stat\":{\"url\":\"https:\\/\\/pokeapi.co\\/api\\/v2\\/stat\\/1\\/\",\"name\":\"hp\"},\"effort\":0,\"base_stat\":45}],\"name\":\"bulbasaur\",\"weight\":69}";
        JSONObject input = new JSONObject(js);
        String output;
        String expected= "bulbasaur";
        PokInfo PokeInfo = new PokInfo();
        output = PokeInfo.getID(input);
        assertEquals(expected, output);
    }

    @Test
    public void getSprites() throws Exception {

    }

    @Test
    public void getImageFront() throws Exception {

    }

    @Test
    public void getImageBack() throws Exception {

    }

    @Test
    public void getAbilities() throws Exception {

    }

    @Test
    public void getPowerOne() throws Exception {

    }

    @Test
    public void getPowerTwo() throws Exception {

    }

    @Test
    public void getWeight() throws Exception {

    }

    @Test
    public void getNumero() throws Exception {

    }

}