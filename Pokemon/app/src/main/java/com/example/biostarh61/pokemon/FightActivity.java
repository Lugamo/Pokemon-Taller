package com.example.biostarh61.pokemon;

import android.app.Activity;
import android.media.Image;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class FightActivity extends Activity {

    TextView TxtStatus;
    Button btnPowerOne, btnPowerTwo;
    String nameAlly,imageAlly,powerOneAlly,powerTwoAlly,nameEnemy,imageEnemy,powerOneEnemy;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fight);
        TxtStatus = (TextView) findViewById(R.id.PkmnStatus);
        btnPowerOne = (Button) findViewById(R.id.btnPowerOne);
        btnPowerTwo = (Button) findViewById(R.id.btnPowerTwo);
        nameAlly=getIntent().getExtras().getString("nameOne");
        imageAlly=getIntent().getExtras().getString("imageOne");
        powerOneAlly=getIntent().getExtras().getString("powerOne");
        powerTwoAlly=getIntent().getExtras().getString("powerTwo");


        new DownloadImageTask((ImageView) findViewById(R.id.imageAlly))
                .execute(imageAlly);
        btnPowerOne.setText(powerOneAlly);
        btnPowerTwo.setText(powerTwoAlly);

        nameEnemy=getIntent().getExtras().getString("nameTwo");
        imageEnemy=getIntent().getExtras().getString("imageTwo");
        powerOneEnemy=getIntent().getExtras().getString("powerOne2");

        new DownloadImageTask((ImageView) findViewById(R.id.imageEnemy))
                .execute(imageEnemy);


    }
}
