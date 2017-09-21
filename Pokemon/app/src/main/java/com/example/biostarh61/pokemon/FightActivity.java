package com.example.biostarh61.pokemon;

import android.app.Activity;
import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class FightActivity extends Activity {

    TextView TxtStatus,TxtlifeAlly,TxtlifeEnemy;
    Button btnPowerOne, btnPowerTwo;
    String nameAlly,imageAlly,imageAllyFront,powerOneAlly,powerTwoAlly,nameEnemy,imageEnemy,powerOneEnemy;
    int lifeAlly=30,lifeEnemy=30;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fight);
        TxtStatus = (TextView) findViewById(R.id.PkmnStatus);
        TxtlifeAlly = (TextView) findViewById(R.id.lifeAlly);
        TxtlifeEnemy = (TextView) findViewById(R.id.lifeEnemy);
        btnPowerOne = (Button) findViewById(R.id.btnPowerOne);
        btnPowerTwo = (Button) findViewById(R.id.btnPowerTwo);
        nameAlly=getIntent().getExtras().getString("nameOne");
        imageAlly=getIntent().getExtras().getString("imageOne");
        imageAllyFront=getIntent().getExtras().getString("imageOneFront");
        powerOneAlly=getIntent().getExtras().getString("powerOne");
        powerTwoAlly=getIntent().getExtras().getString("powerTwo");


        new DownloadImageTask((ImageView) findViewById(R.id.imageAlly))
                .execute(imageAlly);
        btnPowerOne.setText(nameAlly+": "+powerOneAlly);


        nameEnemy=getIntent().getExtras().getString("nameTwo");
        imageEnemy=getIntent().getExtras().getString("imageTwo");
        powerOneEnemy=getIntent().getExtras().getString("powerOne2");

        new DownloadImageTask((ImageView) findViewById(R.id.imageEnemy))
                .execute(imageEnemy);
        btnPowerTwo.setText(nameEnemy+": "+powerOneEnemy);

        establishLife(lifeAlly,lifeEnemy);
        btnPowerOne.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                TxtStatus.setText(nameAlly + " ha usado " + powerOneAlly + " contra " + nameEnemy);
                lifeEnemy = lifeEnemy -10;
                establishLife(lifeAlly,lifeEnemy);


            }
        });
        btnPowerTwo.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                TxtStatus.setText(nameEnemy + " ha usado " + powerOneEnemy + " contra " + nameAlly);
                lifeAlly = lifeAlly - 10;
                establishLife(lifeAlly,lifeEnemy);

            }
        });

    }
    public void establishLife(int life1, int life2){
        TxtlifeAlly.setText(life1 + "/30");
        TxtlifeEnemy.setText(life2 + "/30");
        if(life1<= 0)
        {
            Intent WinnerActivityIntent = new Intent(FightActivity.this,WinnerActivity.class);
            WinnerActivityIntent.putExtra("winner",imageEnemy);
            startActivity(WinnerActivityIntent);
        }
        if(life2<= 0)
        {
            Intent WinnerActivityIntent = new Intent(FightActivity.this,WinnerActivity.class);
            WinnerActivityIntent.putExtra("winner",imageAllyFront);
            startActivity(WinnerActivityIntent);
        }

    }
}
