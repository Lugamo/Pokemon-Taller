package com.example.biostarh61.pokemon;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;

import org.json.JSONObject;

import java.util.Random;

public class MainActivity extends Activity {
    TextView mTxtDisplay,mTxtDisplay2,mTxtPeso1,mTxtPeso2,mTxtNum1,mTxtNum2;
    String nombre,imagen,peso,numPkmn,nombre2,imagen2,peso2,numPkmn2;
    Button btnGRandom, btnPelear;

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

    }
    public void getJson(String url) {
        JsonObjectRequest jsObjRequest = new JsonObjectRequest
                (Request.Method.GET, url, null, new Response.Listener<JSONObject>() {

                    @Override
                    public void onResponse(JSONObject response) {
                        numPkmn = PokInfo.getNumero(response);
                        nombre = PokInfo.getID(response);
                        peso = PokInfo.getWeight(response);
                        imagen = PokInfo.getImageFront(response);
                        mTxtDisplay.setText(nombre);
                        mTxtPeso1.setText(peso);
                        mTxtNum1.setText("#Pokedex: " + numPkmn1);
                        new DownloadImageTask((ImageView) findViewById(R.id.imagePkmnOne))
                                .execute(imagen);

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
                        numPkmn2 = PokInfo.getNumero(response);
                        nombre2 = PokInfo.getID(response);
                        peso2 = PokInfo.getWeight(response);
                        imagen2 = PokInfo.getImageFront(response);
                        mTxtDisplay2.setText(nombre2);
                        mTxtPeso2.setText(peso2);
                        mTxtNum2.setText("#Pokedex: " + numPkmn2);
                        new DownloadImageTask((ImageView) findViewById(R.id.imagePkmnTwo))
                                .execute(imagen);

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
