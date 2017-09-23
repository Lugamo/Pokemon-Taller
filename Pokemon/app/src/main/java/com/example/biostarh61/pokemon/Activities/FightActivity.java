package com.example.biostarh61.pokemon.Activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.biostarh61.pokemon.DownloadImageTask;
import com.example.biostarh61.pokemon.R;

public class FightActivity extends Activity {

    TextView TxtStatus,TxtlifeAlly,TxtlifeEnemy;
    Button btnPowerOne, btnPowerTwo;
    String nameAlly,imageAlly,imageAllyFront,powerOneAlly,powerTwoAlly,nameEnemy,imageEnemy,powerOneEnemy;
    int lifeAlly=100,lifeEnemy=100,daño;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fight);
        //Se asocia la variable a cada elemento del layout
        TxtStatus = (TextView) findViewById(R.id.PkmnStatus);
        TxtlifeAlly = (TextView) findViewById(R.id.lifeAlly);
        TxtlifeEnemy = (TextView) findViewById(R.id.lifeEnemy);
        btnPowerOne = (Button) findViewById(R.id.btnPowerOne);
        btnPowerTwo = (Button) findViewById(R.id.btnPowerTwo);
        //Extrayendo la informacion del intent
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
                daño=(int) (Math.random()*20);
                lifeEnemy = lifeEnemy - daño;
                establishLife(lifeAlly,lifeEnemy);
            }
        });
        btnPowerTwo.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                TxtStatus.setText(nameEnemy + " ha usado " + powerOneEnemy + " contra " + nameAlly);
                daño=(int) (Math.random()*20);
                lifeAlly = lifeAlly - daño;
                establishLife(lifeAlly,lifeEnemy);

            }
        });

    }
    //Metodo para establecer y actualizar la vida del aliado y de enemigo
    public void establishLife(int life1, int life2){
        TxtlifeAlly.setText(life1 + "/100");
        TxtlifeEnemy.setText(life2 + "/100");
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
