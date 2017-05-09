package com.example.earaujgi7alumnes.bossgame;

import android.app.Activity;
import android.content.res.AssetManager;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.earaujgi7alumnes.bossgame.model.Jugador;
import com.example.earaujgi7alumnes.bossgame.model.Millora;
import com.example.earaujgi7alumnes.bossgame.model.MilloresAdapter;

import java.util.ArrayList;


/**
 * Created by earaujgi7.alumnes on 02/05/17.
 */

public class BossMain extends Activity implements CanalCallBack {
    public static final int GAME_WIDTH = 10;
    public static final int GAME_HEIGHT = 10;
    public static BossView bossV;
    public static Jugador player;
    public static Boss1 nivellactual;
    public static Model m;
    public int contador = 0;


    ArrayList<Millora> millores;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.boss_vista);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);

        player = new Jugador();
        player.nouNivell(500,1,1000);
        nivellactual = new Boss1(100,10);
        m = new Model(nivellactual,player);

        bossV = new BossView(this,m);
        bossV.initGame();

        TextView vida = (TextView)findViewById(R.id.vidaBoss);
        vida.setText(String.valueOf(m.getBoss().getVida()));


        LinearLayout surface = (LinearLayout)findViewById(R.id.surfaceBoss);
        surface.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ImageView mImageViewSelector = (ImageView)findViewById(R.id.imageview_animated_selector);
                mImageViewSelector.setActivated(!mImageViewSelector.isActivated());

                m.getBoss().treureVida(m.getPlayer().getPuntsmal());

                TextView vida = (TextView)findViewById(R.id.vidaBoss);
                vida.setText(String.valueOf(m.getBoss().getVida()));

                if(m.getBoss().getVida() < 0){
                    setContentView(R.layout.youwin);
                }
            }
        });



        // Lookup the recyclerview in activity layout
        RecyclerView rvContacts = (RecyclerView) findViewById(R.id.rvBossShop);
        // Initialize millores
        millores = Millora.createMillorasLevel(1);
        // Create adapter passing in the sample user data
        final MilloresAdapter adapter = new MilloresAdapter(this, millores);
        // Attach the adapter to the recyclerview to populate items
        rvContacts.setAdapter(adapter);
        // Set layout manager to position the items
        rvContacts.setLayoutManager(new LinearLayoutManager(this));

        adapter.setOnItemClickListener(new MilloresAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                Millora currentMillora = millores.get(position);
                Jugador player = m.getPlayer();

                int preu = currentMillora.getCost();
                if (player.getDiners() < preu) {
                    Toast.makeText(BossMain.this, "Not enought points", Toast.LENGTH_SHORT).show();
                }
                else {
                    player.menysDiners(preu);
                    switch (currentMillora.getTipus()){
                        case 1:
                            player.mesVida(currentMillora.getValor());
                            Toast.makeText(BossMain.this, "vida total "+player.getVida(), Toast.LENGTH_SHORT).show(); //mostra la vida
                            break;

                        case 2:
                            player.mesPuntsmal(currentMillora.getValor());
                            break;
                    }

                    millores.remove(position);
                    adapter.notifyItemRemoved(position);
                }
            }
        });
    }

    @Override
    public void UpdateTextBoss(String vidaJ, String puntsJ) {
        /*TextView vidaJugador = (TextView)findViewById(R.id.vidaJugador);
        vidaJugador.setText(vidaJ);

        TextView puntsJugador = (TextView)findViewById(R.id.diners);
        puntsJugador.setText(puntsJ);*/
    }

}
