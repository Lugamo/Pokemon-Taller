package com.example.biostarh61.pokemon;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.view.View;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.JsonObjectRequest;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;

public class MainActivity extends Activity {
    TextView mTxtDisplay;
    ImageView mImageView,backPokemon;
    String nombre,imagen;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mTxtDisplay = (TextView) findViewById(R.id.pkmNameBack);
        String url = "http://pokeapi.co/api/v2/pokemon/4";
        String url2 = "http://pokeapi.co/api/v2/pokemon/5";

        JsonObjectRequest jsObjRequest = new JsonObjectRequest
                (Request.Method.GET, url, null, new Response.Listener<JSONObject>() {

                    @Override
                    public void onResponse(JSONObject response) {

                        /*try {
                            nombre = response.getString("name");
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                        JSONObject imagen = null;
                        try {
                            imagen = response.getJSONObject("sprites");
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                        try {
                            mobile = imagen.getString("back_default");
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }*/

                        nombre = PokInfo.getID(response);
                        imagen = PokInfo.getImageBack(response);
                        mTxtDisplay.setText("Response: " + nombre);
                        new DownloadImageTask((ImageView) findViewById(R.id.imageBack))
                                .execute("http://imagenpng.com/wp-content/uploads/2016/09/Pikachu-png-2.png");

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
