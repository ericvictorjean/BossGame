package com.example.earaujgi7alumnes.bossgame;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;


/**
 * Created by earaujgi7.alumnes on 02/05/17.
 */

class BossView implements Runnable{
    private Model model;
    private Activity context;

    private Thread gameThread;
    private volatile boolean running = false;


    public BossView(Activity context, Model model) {
        this.model = model;
        this.context = context;
    }

    public void initGame() {
        running = true;
        gameThread = new Thread(this, "Game Thread");
        gameThread.start();
    }

    private void pauseGame() {
        running = false;
        while (gameThread.isAlive()) {
            try {
                gameThread.join();
                break;
            } catch (InterruptedException e) {
            }
        }
    }

    private void updateAndRender(long delta) {
        model.actualizardatos(delta,model.getBoss().getPuntsmal());

        TextView vidaJugador = (TextView)context.findViewById(R.id.vidaJugador);
        vidaJugador.setText(String.valueOf(model.getPlayer().getVida()));

        TextView puntsJugador = (TextView)context.findViewById(R.id.punts);
        puntsJugador.setText(String.valueOf(model.getPlayer().getDiners()));

    }

    public void run() {
        long updateDurationMillis = 0;
        long sleepDurationMillis = 0;
        while (running) {
            long beforeUpdateRender = System.nanoTime();
            long deltaMillis = sleepDurationMillis + updateDurationMillis;
            updateAndRender(deltaMillis);
            updateDurationMillis = (System.nanoTime() - beforeUpdateRender) / 1000000L;//milisegundos
            sleepDurationMillis = Math.max(2, 40 - updateDurationMillis);
            try {
                Thread.sleep(sleepDurationMillis);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

}
