package com.example.earaujgi7alumnes.bossgame;


/**
 * Created by earaujgi7.alumnes on 02/05/17.
 */

public class Boss1 {
    int vida;
    int puntsmal;

    public Boss1(int vida, int puntsmal){
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

    public void treureVida(int mal) {
        this.vida -= mal;
    }
}
