/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fi.ilmaripohjola.ipitris.gameloop;

import fi.ilmaripohjola.ipitris.gamelogic.Logic;
import fi.ilmaripohjola.ipitris.interfaces.KeyPressListener;
import fi.ilmaripohjola.ipitris.utilities.Renderer;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author omistaja
 */
public class MyGameLoop implements Runnable {

    private boolean continues;
    private KeyPressListener listener;
    private Logic tetris;
    private Renderer renderer;
    private Thread t;

    public MyGameLoop(Renderer renderer, KeyPressListener listener, Logic tetris) {
        this.continues = false;
        this.listener = listener;
        this.tetris = tetris;
        this.renderer = renderer;
    }

    @Override
    public void run() {
        boolean[] keys = new boolean[4];
        this.continues = true;
        try {
            Thread.sleep(400);
        } catch (InterruptedException ex) {
            Logger.getLogger(MyGameLoop.class.getName()).log(Level.SEVERE, null, ex);
        }

        Date date = new Date();
        long currentTime = date.getTime();
        long lastUpdate = date.getTime();
        long deltaTime = currentTime - lastUpdate;
        int rounds = 0;
        while (continues) {
            getKeys(keys);
            if (rounds > 20) {
                keys[0] = true;
                rounds = 0;
            }
            rounds++;
            this.tetris.update(keys[0], keys[1], keys[2], keys[3]);
            emptyKeys();

            currentTime = date.getTime();
            deltaTime = currentTime - lastUpdate;
            lastUpdate = currentTime;

            try {
                Thread.sleep(20 - deltaTime);
            } catch (InterruptedException ex) {
                Logger.getLogger(MyGameLoop.class.getName()).log(Level.SEVERE, null, ex);
            }
            if (!this.tetris.getContinues()) {
                this.continues = false;
            }

        }
    }

    public void start() {
        System.out.println("Starting loop");
        if (t == null) {
            t = new Thread(this, "3");
            t.start();
//       
        }
        MyRenderLoop renderloop = new MyRenderLoop(this.renderer, this.tetris); 
        renderloop.start();
    }

    private void getKeys(boolean[] keys) {
        keys[0] = this.listener.isDown();
        keys[1] = this.listener.isLeft();
        keys[2] = this.listener.isRight();
        keys[3] = this.listener.isSpace();
    }

    private void emptyKeys() {
        this.listener.setDown(false);
        this.listener.setLeft(false);
        this.listener.setRight(false);
        this.listener.setSpace(false);
    }
}
