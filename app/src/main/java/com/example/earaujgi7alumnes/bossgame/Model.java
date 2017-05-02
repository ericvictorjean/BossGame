package com.example.earaujgi7alumnes.bossgame;

/**
 * Created by earaujgi7.alumnes on 02/05/17.
 */

public class Model {
    NivellBoss nivellActual;
    Jugador player;

    public void init(NivellBoss nivell, Jugador player){
        this.nivellActual = nivell;
        this.player = player;
    }

    public void setNivellActual(NivellBoss nivellActual) {
        this.nivellActual = nivellActual;
    }

    public void setPlayer(Jugador player) {
        this.player = player;
    }

    public Jugador getPlayer() {
        return player;
    }

    public NivellBoss getNivellActual() {
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
