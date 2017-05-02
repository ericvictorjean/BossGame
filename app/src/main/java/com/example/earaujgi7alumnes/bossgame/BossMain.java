package com.example.earaujgi7alumnes.bossgame;

import android.app.Activity;
import android.content.res.AssetManager;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;

/**
 * Created by earaujgi7.alumnes on 02/05/17.
 */

class BossMain extends Activity {
    public static final int GAME_WIDTH = 800;
    public static final int GAME_HEIGHT = 450;
    public static BossView boss;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        boss = new BossView(this, GAME_WIDTH, GAME_HEIGHT);
        setContentView(boss);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
        boss.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //TODO restar vida al boss
            }
        });
    }

}
