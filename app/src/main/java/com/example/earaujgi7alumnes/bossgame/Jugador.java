package com.example.earaujgi7alumnes.bossgame;

/**
 * Created by earaujgi7.alumnes on 02/05/17.
 */

public class Jugador {
    int vida;
    int puntsmal;

    public void init(int vida,int puntsmal){
        this.vida = vida;
        this.puntsmal = puntsmal;
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
}
