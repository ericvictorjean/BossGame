package com.example.earaujgi7alumnes.bossgame;


import com.example.earaujgi7alumnes.bossgame.model.Jugador;

/**
 * Created by earaujgi7.alumnes on 02/05/17.
 */

public class Model {
    private static Boss1 bossActual;
    Jugador player;


    public Model(Boss1 nivell, Jugador player){
        this.bossActual = nivell;
        this.player = player;
    }

    public static Boss1 getBoss() {
        return bossActual;
    }

    public void setBossActual(Boss1 nivellActual) {
        this.bossActual = nivellActual;
    }

    public void setPlayer(Jugador player) {
        this.player = player;
    }

    public Jugador getPlayer() {
        return player;
    }

    public void actualizardatos(int dmgjugador){
        this.player.mesPuntsmal(dmgjugador);
    }

    public void actualizardatos(int vidajugador,int vidaBoss){
        this.player.mesVida(vidajugador);
        this.bossActual.setVida(vidaBoss - this.player.getPuntsmal());
    }
}
