package com.example.earaujgi7alumnes.bossgame;

import android.app.Activity;
import android.content.res.AssetManager;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
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
    public static Nivell1 nivellactual;
    public static Model m;
    public static AssetManager assets;
    int clicks = 0;


    ArrayList<Millora> millores;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        player = new Jugador(100,5);
        nivellactual = new Nivell1(100,10);
        m = new Model(nivellactual,player);
        assets = getAssets();
        bossV = new BossView(this, GAME_WIDTH, GAME_HEIGHT,m);
        final TextView clicktext = (TextView)findViewById(R.id.Clicks);

        setContentView(R.layout.boss_vista);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);

        RelativeLayout surface = (RelativeLayout)findViewById(R.id.surfaceBoss);
        surface.addView(bossV);

        /*bossV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //TODO restar vida al bossV
                clicks++;
                clickText.setText(clicks + "clicks");
            }
        });*/



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
