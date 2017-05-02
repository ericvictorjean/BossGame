package com.example.earaujgi7alumnes.bossgame;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;

/**
 * Created by earaujgi7.alumnes on 02/05/17.
 */

class BossMain extends Activity {
    public static final int GAME_WIDTH = 800;
    public static final int GAME_HEIGHT = 450;
    public static BossView bossV;
    public static Jugador player;
    public static NivellBoss nivellactual;
    public static Model m;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        player = new Jugador(100,5);
        nivellactual = new Nivell1(100,10);
        m = new Model(nivellactual,player);

        bossV = new BossView(this, GAME_WIDTH, GAME_HEIGHT,m);
        setContentView(bossV);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
        bossV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //TODO restar vida al bossV
            }
        });
    }

}
