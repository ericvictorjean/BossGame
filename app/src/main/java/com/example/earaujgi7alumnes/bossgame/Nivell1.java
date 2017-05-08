package com.example.earaujgi7alumnes.bossgame;


import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.drawable.Drawable;

import com.example.earaujgi7alumnes.bossgame.Assets;
import com.example.earaujgi7alumnes.bossgame.BossMain;
import com.example.earaujgi7alumnes.bossgame.Painter;
import com.example.earaujgi7alumnes.bossgame.R;

/**
 * Created by earaujgi7.alumnes on 02/05/17.
 */

public class Nivell1 {
    int vida;
    int puntsmal;

    public Nivell1(int vida,int puntsmal){
        this.vida = 100;
        this.puntsmal = 10;
    }

    public int getPuntsmal() {
        return puntsmal;
    }

    public int getVida() {
        return vida;
    }

    public void setPuntsmal(int puntsmal) {
        this.puntsmal = puntsmal;
    }

    public void setVida(int vida) {
        this.vida = vida;
    }


    public void updateBoss(float v,int dmg) { // v -> segundos des de la ultima update
        this.setVida(this.getVida()-1); //TODO vida be
    }

    public void renderBoss(Painter g) {
        g.setColor(Color.rgb(208, 244, 247));
        g.fillRect(0, 0, BossMain.GAME_WIDTH, BossMain.GAME_HEIGHT);
        g.drawImage(Assets.jefe, 0, 405);

    }
}
