package com.example.earaujgi7alumnes.bossgame;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.view.SurfaceHolder;
import android.view.SurfaceView;


/**
 * Created by earaujgi7.alumnes on 02/05/17.
 */

class BossView implements Runnable{
    private Model model;

    private Thread gameThread;
    private volatile boolean running = false;


    public BossView(Model m) {
        model = m;
    }

    private void initGame() {
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
        Boss1 nivellAct = model.getBoss();
        nivellAct.updateBoss((delta / 1000f),1);//segundos
        renderBoss();
        renderGameImage();
    }

    private void renderBoss() {

    }

    private void renderGameImage() {

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
