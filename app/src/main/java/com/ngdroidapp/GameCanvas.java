package com.ngdroidapp;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

import istanbul.gamelab.ngdroid.base.BaseCanvas;


/**
 * Created by noyan on 24.06.2016.
 * Nitra Games Ltd.
 */


public class GameCanvas extends BaseCanvas {
    private static final int GRIDSIZE = 6;

    private int width, height;
    private int[] grid, state;
    private Paint paint;

    private boolean istouched;
    private long touchcounter, maxtime;

    public GameCanvas(NgApp ngApp) {
        super(ngApp);
    }

    public void setup() {
        width = getWidth() / GRIDSIZE;
        height = getHeight() / GRIDSIZE;
        grid = new int[width * height];
        state = new int[width * height];

        for(int i = 0; i < width * height; i++) state[i] = Math.random() > 0.5f ? 1 : 0;

        paint = new Paint();
        paint.setColor(Color.WHITE);

        maxtime = 1000;
    }

    public void update() {
        for(int i = 0; i < width * height; i++) grid[i] = state[i];
        for(int x = 1; x < width - 1; x++) {
            for(int y = 1; y < height - 1; y++) {
                int neighbors = getNeighbors(x, y);

                if(grid[y * width + x] == 1) {
                    state[y * width + x] = (neighbors == 2 || neighbors == 3) ? 1 : 0;
                } else {
                    state[y * width + x] = (neighbors == 3) ? 1 : 0;
                }
            }
        }
    }

    public void draw(Canvas canvas) {
        canvas.drawColor(Color.BLACK);
        for(int x = 1; x < width - 1; x++) {
            for(int y = 1; y < height - 1; y++) {
                if (grid[y * width + x] == 1) {
                    canvas.drawRect(x * GRIDSIZE, y * GRIDSIZE, x * GRIDSIZE + GRIDSIZE, y * GRIDSIZE + GRIDSIZE, paint);
                }
            }
        }
    }

    private int getNeighbors(int x, int y) {
        return grid[(y - 1) * width + (x - 1)] + grid[(y - 1) * width + x] +
               grid[(y - 1) * width + (x + 1)] + grid[y * width + (x - 1)] +
               grid[y * width + (x + 1)] + grid[(y + 1) * width + (x - 1)] +
               grid[(y + 1) * width + x] + grid[(y + 1) * width + (x + 1)];
    }

    private void set(int x, int y, String s) {
        int pos = 0;
        for(char c : s.toCharArray()) {
            state[y * width + x + pos++] = c == '#' ? 1 : 0;
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
        if(!istouched) {
            istouched = true;
            touchcounter = System.currentTimeMillis();
        } else if(System.currentTimeMillis() - touchcounter < maxtime) {
            for(int i = 0; i < width * height; i++) state[i] = 0;
            // Gosper Glider Gun
            set(60, 45, "........................#............");
            set(60, 46, "......................#.#............");
            set(60, 47, "............##......##............##.");
            set(60, 48, "...........#...#....##............##.");
            set(60, 49, "##........#.....#...##...............");
            set(60, 50, "##........#...#.##....#.#............");
            set(60, 51, "..........#.....#.......#............");
            set(60, 52, "...........#...#.....................");
            set(60, 53, "............##.......................");
        } else {
            touchcounter = System.currentTimeMillis();
        }
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
