package com.example.earaujgi7alumnes.bossgame;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.WindowManager;

import com.example.earaujgi7alumnes.bossgame.model.Jugador;
import com.example.earaujgi7alumnes.bossgame.model.Millora;
import com.example.earaujgi7alumnes.bossgame.model.MilloresAdapter;
import com.example.earaujgi7alumnes.bossgame.model.Model;
import com.example.earaujgi7alumnes.bossgame.model.Nivell1;
import com.example.earaujgi7alumnes.bossgame.model.NivellBoss;

import java.util.ArrayList;


/**
 * Created by earaujgi7.alumnes on 02/05/17.
 */

public class BossMain extends Activity {
    //public static final int GAME_WIDTH = 800;
    //public static final int GAME_HEIGHT = 450;
    //public static BossView bossV;
    public static Jugador player;
    public static NivellBoss nivellactual;
    public static Model m;

    ArrayList<Millora> millores;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.boss_vista);
        player = new Jugador(100,5);
        nivellactual = new Nivell1(100,10);
        m = new Model(nivellactual,player);

        RecyclerView rvContacts = (RecyclerView) findViewById(R.id.rvContacts);

        // Initialize millores
        millores = Millora.createMillorasList(20);
        // Create adapter passing in the sample user data
        MilloresAdapter adapter = new MilloresAdapter(this, millores);
        // Attach the adapter to the recyclerview to populate items
        rvContacts.setAdapter(adapter);
        // Set layout manager to position the items
        rvContacts.setLayoutManager(new LinearLayoutManager(this));

       //bossV = new BossView(this, GAME_WIDTH, GAME_HEIGHT,m);

        //getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
        /*bossV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //TODO restar vida al bossV
            }
        });*/
    }

}
