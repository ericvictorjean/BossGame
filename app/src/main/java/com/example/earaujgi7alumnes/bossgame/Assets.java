package com.example.earaujgi7alumnes.bossgame;

import java.io.IOException;
import java.io.InputStream;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;



import java.io.IOException;
import java.io.InputStream;

public class Assets {

	public static Bitmap jefe;

	public static void load() {
		jefe = loadBitmap("images.jpg", false);
	}

	private static Bitmap loadBitmap(String filename, boolean transparency) {
		InputStream inputStream = null;
		try {
			inputStream = BossMain.assets.open(filename);
		} catch (IOException e) {
			e.printStackTrace();
		}
		Options options = new Options();
		if (transparency) {
			options.inPreferredConfig = Config.ARGB_8888;
		} else {
			options.inPreferredConfig = Config.RGB_565;
		}
		Bitmap bitmap = BitmapFactory.decodeStream(inputStream, null, options);
		return bitmap;
	}

	private static int loadSound(String filename) {
		int soundID = 0;
		return soundID;
	}

	public static void playSound(int soundID) {

	}
}