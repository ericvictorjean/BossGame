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

class BossView extends SurfaceView implements Runnable{
    private Bitmap gameImage;
    private Rect gameImageSrc;
    private Rect gameImageDst;
    private Canvas gameCanvas;
    private Painter graphics;
    private Model model;

    private Thread gameThread;
    private volatile boolean running = false;


    public BossView(Context context, int gameWidth, int gameHeight,Model m) {
        super(context);
        gameImage = Bitmap.createBitmap(gameWidth, gameHeight, Bitmap.Config.RGB_565);
        gameImageSrc = new Rect(0, 0, gameImage.getWidth(), gameImage.getHeight());
        gameImageDst = new Rect();
        gameCanvas = new Canvas(gameImage);
        graphics = new Painter(gameCanvas);
        model = m;
        SurfaceHolder holder = getHolder();
        holder.addCallback(new SurfaceHolder.Callback() {

            @Override
            public void surfaceCreated(SurfaceHolder holder) {
                //Assets.load();
                initGame();
            }

            @Override
            public void surfaceChanged(SurfaceHolder holder, int format,
                                       int width, int height) {
                // TODO Auto-generated method stub
            }

            @Override
            public void surfaceDestroyed(SurfaceHolder holder) {
                pauseGame();
            }

        });
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
        nivellAct.updateBoss((delta / 1000f),1);
        nivellAct.renderBoss(graphics);
        renderGameImage();
    }

    private void renderGameImage() {
        Canvas screen = getHolder().lockCanvas();
        if (screen != null) {
            screen.getClipBounds(gameImageDst);
            screen.drawBitmap(gameImage, gameImageSrc, gameImageDst,null);
            getHolder().unlockCanvasAndPost(screen);
        }
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
