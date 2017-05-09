package com.example.earaujgi7alumnes.bossgame.model;

/**
 * Created by earaujgi7.alumnes on 02/05/17.
 */

public class Jugador {
    int vida;
    int puntsmal;
    int diners;

    public Jugador(){
        this.vida = 0;
        this.puntsmal = 0;
        this.diners = 0;
    }
    public void nouNivell(int v, int m, int d) {
        this.vida = v;
        this.puntsmal = m;
        this.diners = d;
    }
    public int getDiners() {
        return diners;
    }

    public int getPuntsmal() {
        return puntsmal;
    }

    public int getVida() {
        return vida;
    }

    public void menysDiners(int diners) {
        this.diners -= diners;
    }

    public void mesDiners(int diners) {
        this.diners += diners;
    }

    public void mesPuntsmal(int puntsmal) {
        this.puntsmal += puntsmal;
    }

    public void mesVida(int vida) {
        this.vida += vida;
    }

    public void menysVida(int vida) {
        this.vida -= vida;
    }

}
