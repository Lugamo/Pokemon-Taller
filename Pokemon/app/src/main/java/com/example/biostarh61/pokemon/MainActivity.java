package com.example.biostarh61.pokemon;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.view.View;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.JsonObjectRequest;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;

public class MainActivity extends Activity {
    TextView mTxtDisplay,mTxtDisplay2;
    String nombre,imagen,poder1A,poder2A;
    Button btnAttackOne, btnAttackTwo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mTxtDisplay = (TextView) findViewById(R.id.pkmNameBack);
        mTxtDisplay2 = (TextView) findViewById(R.id.pkmNameFront);
        btnAttackOne = (Button) findViewById(R.id.AttackOne);
        btnAttackTwo = (Button) findViewById(R.id.AttackTwo);
        String url = "http://pokeapi.co/api/v2/pokemon/4";
        String url2 = "http://pokeapi.co/api/v2/pokemon/5";

        JsonObjectRequest jsObjRequest = new JsonObjectRequest
                (Request.Method.GET, url, null, new Response.Listener<JSONObject>() {

                    @Override
                    public void onResponse(JSONObject response) {

                        nombre = PokInfo.getID(response);
                        imagen = PokInfo.getImageBack(response);
                        poder1A = PokInfo.getPowerOne(response);
                        poder2A = PokInfo.getPowerTwo(response);
                        mTxtDisplay.setText("Response: " + nombre);
                        btnAttackOne.setText(poder1A);
                        btnAttackTwo.setText(poder2A);
                        new DownloadImageTask((ImageView) findViewById(R.id.imageBack))
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
