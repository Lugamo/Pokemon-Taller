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
    String nombre,imagen,peso;
    Button btnGRandom, btnPelear;
    JSONObject respuesta;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mTxtDisplay = (TextView) findViewById(R.id.pkmNameOne);
        mTxtDisplay2 = (TextView) findViewById(R.id.pkmNameTwo);
        mTxtPeso1 = (TextView) findViewById(R.id.PkmnWeightOne);
        mTxtNum1 = (TextView) findViewById(R.id.PkmnNumOne);

        btnGRandom = (Button) findViewById(R.id.btnRandom);
        btnGRandom.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Random rand = new Random();
                final int numPkmn1 = rand.nextInt(800);
                int numPkmn2 = rand.nextInt(800);
                String url = ("http://pokeapi.co/api/v2/pokemon/"+numPkmn1);
                String url2 = ("http://pokeapi.co/api/v2/pokemon/"+numPkmn2);
                JsonObjectRequest jsObjRequest = new JsonObjectRequest
                        (Request.Method.GET, url, null, new Response.Listener<JSONObject>() {

                            @Override
                            public void onResponse(JSONObject response) {
                                nombre=PokInfo.getID(response);
                                peso=PokInfo.getWeight(response);
                                imagen = PokInfo.getImageFront(response);
                                mTxtDisplay.setText("Nombre: "+nombre);
                                mTxtPeso1.setText("Peso: "+peso);
                                mTxtNum1.setText("#Pokedex: "+numPkmn1);
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
        });



    }
}
