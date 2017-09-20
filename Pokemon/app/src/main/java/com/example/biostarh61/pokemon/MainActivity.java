package com.example.biostarh61.pokemon;

import android.app.Activity;
import android.content.Intent;
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
    String nombre,imagen,peso,power1,power2,numPkmn,nombre2,imagen2,imagenBack,peso2,numPkmn2,power1_2;
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
        btnPelear = (Button) findViewById(R.id.btnFight);
        btnPelear.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent FightActivityIntent = new Intent(MainActivity.this,FightActivity.class);
                FightActivityIntent.putExtra("nameOne",nombre);
                FightActivityIntent.putExtra("nameTwo",nombre2);
                FightActivityIntent.putExtra("imageOne",imagenBack);
                FightActivityIntent.putExtra("imageTwo",imagen2);
                FightActivityIntent.putExtra("powerOne",power1);
                FightActivityIntent.putExtra("powerTwo",power2);
                FightActivityIntent.putExtra("powerOne2",power1_2);
                startActivity(FightActivityIntent);

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
                        imagenBack = PokInfo.getImageBack(response);
                        power1 = PokInfo.getPowerOne(response);
                        power2 = PokInfo.getPowerTwo(response);
                        mTxtDisplay.setText(nombre);
                        mTxtPeso1.setText(peso);
                        mTxtNum1.setText(numPkmn);
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
                        //power1_2 = PokInfo.getPowerOne(response);
                        mTxtDisplay2.setText(nombre2);
                        mTxtPeso2.setText(peso2);
                        mTxtNum2.setText(numPkmn2);
                        new DownloadImageTask((ImageView) findViewById(R.id.imagePkmnTwo))
                                .execute(imagen2);

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
