package com.ngdroidapp;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.widget.GridLayout;

import istanbul.gamelab.ngdroid.base.BaseCanvas;
import istanbul.gamelab.ngdroid.util.Log;


/**
 * Created by noyan on 24.06.2016.
 * Nitra Games Ltd.
 */


public class GameCanvas extends BaseCanvas {

    private static final int GRIDSIZE = 24;

    private int width, height;
    private boolean[] grid;

    private Paint paint;

    public GameCanvas(NgApp ngApp) {
        super(ngApp);
    }

    public void setup() {
        width = getWidth() / GRIDSIZE;
        height = getHeight() / GRIDSIZE;
        grid = new boolean[width * height];

        paint = new Paint();
        paint.setColor(Color.WHITE);
    }

    public void update() {

    }

    public void draw(Canvas canvas) {
        canvas.drawColor(Color.BLACK);
        for(int x = 0; x < width; x++) {
            for(int y = 0; y < height; y++) {
                if(grid[y * width + x]) {
                    canvas.drawRect(x * GRIDSIZE, y * GRIDSIZE, x * GRIDSIZE + GRIDSIZE, y * GRIDSIZE + + GRIDSIZE, paint);
                }
            }
        }
    }

    public void keyPressed(int key) {

    }

    public void keyReleased(int key) {

    }

    public boolean backPressed() {
        return true;
    }

    public void surfaceChanged(int width, int height) {

    }

    public void surfaceCreated() {

    }

    public void surfaceDestroyed() {

    }

    public void touchDown(int x, int y, int id) {
    }

    public void touchMove(int x, int y, int id) {
    }

    public void touchUp(int x, int y, int id) {
    }


    public void pause() {

    }


    public void resume() {

    }


    public void reloadTextures() {

    }


    public void showNotify() {
    }

    public void hideNotify() {
    }

}
