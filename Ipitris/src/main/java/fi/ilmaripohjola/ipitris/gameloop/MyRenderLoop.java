/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fi.ilmaripohjola.ipitris.gameloop;

import fi.ilmaripohjola.ipitris.gamelogic.TetrisLogic;
import fi.ilmaripohjola.ipitris.utilities.MyFirstRenderer;
import fi.ilmaripohjola.ipitris.utilities.Renderer;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * A Runnable loop that updates the GameScreen's Renderer.
 *
 * @author omistaja
 */
public class MyRenderLoop implements Runnable {

    private TetrisLogic tetris;
    private Renderer renderer;
    private Thread t;
    private boolean continues;

    /**
     * Constructs the renderloop with given variables.
     *
     * @param renderer Given updatable Renderer.
     * @param tetris The GameLogic attached to the renderloop.
     */
    public MyRenderLoop(Renderer renderer, TetrisLogic tetris) {
        this.renderer = renderer;
        this.tetris = tetris;
    }

    @Override
    public void run() {
        this.tetris.reset();
        this.continues = true;
        try {
            Thread.sleep(700);
        } catch (InterruptedException ex) {
            Logger.getLogger(MyGameLoop.class.getName()).log(Level.SEVERE, null, ex);
        }
        int rounds = 0;
        while (continues) {
            try {
                Thread.sleep(20);
            } catch (InterruptedException ex) {
                Logger.getLogger(MyGameLoop.class.getName()).log(Level.SEVERE, null, ex);
            }
            if (!this.tetris.getContinues()) {
                this.continues = false;
            }
            this.renderer.updateNow();
        }
    }

    /**
     * Starts the thread if not yet started.
     */
    public void start() {
        System.out.println("Starting renderloop");
        if (t == null) {
            t = new Thread(this, "3");
            t.start();
        }
    }
}
