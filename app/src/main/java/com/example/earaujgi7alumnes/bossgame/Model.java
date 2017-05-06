package com.example.earaujgi7alumnes.bossgame;


import com.example.earaujgi7alumnes.bossgame.model.Jugador;

/**
 * Created by earaujgi7.alumnes on 02/05/17.
 */

public class Model {
    private static Nivell1 nivellActual;
    Jugador player;


    public Model(Nivell1 nivell, Jugador player){
        this.nivellActual = nivell;
        this.player = player;
    }

    public static Nivell1 getNivell() {
        return nivellActual;
    }

    public void setNivellActual(Nivell1 nivellActual) {
        this.nivellActual = nivellActual;
    }

    public void setPlayer(Jugador player) {
        this.player = player;
    }

    public Jugador getPlayer() {
        return player;
    }

    public Nivell1 getNivellActual() {
        return nivellActual;
    }

    public void actualizardatos(int dmgjugador){
        this.player.setPuntsmal(dmgjugador);
    }

    public void actualizardatos(int vidajugador,int vidaBoss){
        this.player.setVida(vidajugador);
        this.nivellActual.setVida(vidaBoss - this.player.getPuntsmal());
    }
}