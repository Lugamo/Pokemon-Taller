package com.example.biostarh61.pokemon.Activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.example.biostarh61.pokemon.DownloadImageTask;
import com.example.biostarh61.pokemon.Factory.PokeApi;
import com.example.biostarh61.pokemon.Factory.PokeApiFactory;
import com.example.biostarh61.pokemon.Volley.MySingleton;
import com.example.biostarh61.pokemon.R;

import org.json.JSONObject;

public class MainActivity extends Activity {
    TextView mTxtDisplay,mTxtDisplay2,mTxtPeso1,mTxtPeso2,mTxtNum1,mTxtNum2;
    //String nombre,imagen,peso,power1,power2,numPkmn,nombre2,imagen2,imagenBack,peso2,numPkmn2,power1_2;
    Button btnGRandom, btnPelear;
    PokeApiFactory pokeApiFactory = new PokeApiFactory();
    PokeApi pokemonOne = pokeApiFactory.getResource("Pokemon");
    PokeApi pokemonTwo = pokeApiFactory.getResource("Pokemon");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mTxtDisplay = (TextView) findViewById(R.id.pkmNameOne);
        mTxtDisplay2 = (TextView) findViewById(R.id.pkmNameTwo);
        mTxtPeso1 = (TextView) findViewById(R.id.PkmnWeightOne);
        mTxtPeso2 = (TextView) findViewById(R.id.PkmnWeightTwo);
        mTxtNum1 = (TextView) findViewById(R.id.PkmnNumOne);
        mTxtNum2 = (TextView) findViewById(R.id.PkmnNumTwo);


        btnGRandom = (Button) findViewById(R.id.btnRandom);
        btnGRandom.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                int indicePokemon=(int) (Math.random()*200);
                int indicePokemon2=(int) (Math.random()*200);
                String url = ("http://pokeapi.co/api/v2/pokemon/"+indicePokemon);
                String url2 = ("http://pokeapi.co/api/v2/pokemon/"+indicePokemon2);
                getJson(url);
                getJson2(url2);

            }
        });
        btnPelear = (Button) findViewById(R.id.btnFight);
        btnPelear.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent FightActivityIntent = new Intent(MainActivity.this,FightActivity.class);
                FightActivityIntent.putExtra("nameOne",pokemonOne.name());
                FightActivityIntent.putExtra("nameTwo",pokemonTwo.name());
                FightActivityIntent.putExtra("imageOne",pokemonOne.back_image());
                FightActivityIntent.putExtra("imageOneFront",pokemonOne.front_image());
                FightActivityIntent.putExtra("imageTwo",pokemonTwo.front_image());
                FightActivityIntent.putExtra("powerOne",pokemonOne.powerOne());
                FightActivityIntent.putExtra("powerTwo",pokemonOne.powerTwo());
                FightActivityIntent.putExtra("powerOne2",pokemonTwo.powerOne());
                startActivity(FightActivityIntent);

            }
        });


    }
    public void getJson(String url) {
        JsonObjectRequest jsObjRequest = new JsonObjectRequest
                (Request.Method.GET, url, null, new Response.Listener<JSONObject>() {

                    @Override
                    public void onResponse(JSONObject response) {
                        /*numPkmn = PokInfo.getNumero(response);
                        nombre = PokInfo.getID(response);
                        peso = PokInfo.getWeight(response);
                        imagen = PokInfo.getImageFront(response);
                        imagenBack = PokInfo.getImageBack(response);
                        power1 = PokInfo.getPowerOne(response);
                        power2 = PokInfo.getPowerTwo(response);*/
                        pokemonOne.getInfo(response);
                        mTxtDisplay.setText("Nombre: "+pokemonOne.name());
                        mTxtPeso1.setText("Peso: "+pokemonOne.weight());
                        mTxtNum1.setText("#Pokedex: "+pokemonOne.id());
                        new DownloadImageTask((ImageView) findViewById(R.id.imagePkmnOne))
                                .execute(pokemonOne.front_image());

                    }
                }, new Response.ErrorListener() {

                    @Override
                    public void onErrorResponse(VolleyError error) {
                        // TODO Auto-generated method stub

                    }
                });


        // Access the RequestQueue through your singleton class.
        MySingleton.getInstance(this).addToRequestQueue(jsObjRequest);
    }
    public void getJson2(String url) {
        JsonObjectRequest jsObjRequest = new JsonObjectRequest
                (Request.Method.GET, url, null, new Response.Listener<JSONObject>() {

                    @Override
                    public void onResponse(JSONObject response) {
                        /*numPkmn2 = PokInfo.getNumero(response);
                        nombre2 = PokInfo.getID(response);
                        peso2 = PokInfo.getWeight(response);
                        imagen2 = PokInfo.getImageFront(response);
                        power1_2 = PokInfo.getPowerOne(response);*/
                        pokemonTwo.getInfo(response);
                        mTxtDisplay2.setText("Nombre: "+pokemonTwo.name());
                        mTxtPeso2.setText("Peso: "+ pokemonTwo.weight());
                        mTxtNum2.setText("#Pokedex: "+ pokemonTwo.id());
                        new DownloadImageTask((ImageView) findViewById(R.id.imagePkmnTwo))
                                .execute(pokemonTwo.front_image());

                    }
                }, new Response.ErrorListener() {

                    @Override
                    public void onErrorResponse(VolleyError error) {
                        // TODO Auto-generated method stub

                    }
                });


        // Access the RequestQueue through your singleton class.
        MySingleton.getInstance(this).addToRequestQueue(jsObjRequest);
    }
}
