package com.example.earaujgi7alumnes.bossgame;

import android.app.Activity;
import android.content.res.AssetManager;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.WindowManager;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.earaujgi7alumnes.bossgame.model.Jugador;
import com.example.earaujgi7alumnes.bossgame.model.Millora;
import com.example.earaujgi7alumnes.bossgame.model.MilloresAdapter;

import java.util.ArrayList;


/**
 * Created by earaujgi7.alumnes on 02/05/17.
 */

public class BossMain extends Activity {
    public static final int GAME_WIDTH = 10;
    public static final int GAME_HEIGHT = 10;
    public static BossView bossV;
    public static Jugador player;
    public static Boss1 nivellactual;
    public static Model m;
    public static AssetManager assets;
    int clicks = 0;


    ArrayList<Millora> millores;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        player = new Jugador(100,5);
        nivellactual = new Boss1(100,10);
        m = new Model(nivellactual,player);
        assets = getAssets();
        Assets.load();
        bossV = new BossView(this, GAME_WIDTH, GAME_HEIGHT,m);

        setContentView(R.layout.boss_vista);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);


        TextView vida = (TextView)findViewById(R.id.vidaBoss);
        vida.setText(String.valueOf(m.getBoss().getVida()));


        RelativeLayout surface = (RelativeLayout)findViewById(R.id.surfaceBoss);
        //surface.addView(bossV);

        surface.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                m.getBoss().treureVida(m.getPlayer().getPuntsmal());
                TextView vida = (TextView)findViewById(R.id.vidaBoss);
                vida.setText(String.valueOf(m.getBoss().getVida()));
            }
        });



        // Lookup the recyclerview in activity layout
        RecyclerView rvContacts = (RecyclerView) findViewById(R.id.rvBossShop);
        // Initialize millores
        millores = Millora.createMillorasLevel(1);
        // Create adapter passing in the sample user data
        MilloresAdapter adapter = new MilloresAdapter(this, millores);
        // Attach the adapter to the recyclerview to populate items
        rvContacts.setAdapter(adapter);
        // Set layout manager to position the items
        rvContacts.setLayoutManager(new LinearLayoutManager(this));
    }

}
