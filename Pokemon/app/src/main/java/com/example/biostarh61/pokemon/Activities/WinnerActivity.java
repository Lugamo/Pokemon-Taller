package com.example.biostarh61.pokemon.Activities;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ImageView;

import com.example.biostarh61.pokemon.DownloadImageTask;
import com.example.biostarh61.pokemon.R;

public class WinnerActivity extends Activity {

    String imageWinner;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_winner);
        imageWinner=getIntent().getExtras().getString("winner");
        new DownloadImageTask((ImageView) findViewById(R.id.imageWinner))
                .execute(imageWinner);
    }
}
