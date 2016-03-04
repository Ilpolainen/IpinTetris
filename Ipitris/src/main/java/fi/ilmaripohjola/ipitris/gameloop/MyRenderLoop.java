/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fi.ilmaripohjola.ipitris.gameloop;

import fi.ilmaripohjola.ipitris.gamelogic.Logic;
import fi.ilmaripohjola.ipitris.utilities.Renderer;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * A Runnable loop that updates the GameScreen's Renderer.
 *
 * @author omistaja
 */
public class MyRenderLoop implements Runnable {

    private Logic tetris;
    private Renderer renderer;
    private Thread t;
    private boolean continues;

    /**
     * Constructs the renderloop with given variables.
     *
     * @param renderer Given updatable Renderer.
     * @param tetris The GameLogic attached to the renderloop.
     */
    public MyRenderLoop(Renderer renderer, Logic tetris) {
        this.renderer = renderer;
        this.tetris = tetris;
    }

    @Override
    public void run() {
        this.tetris.start();
        this.continues = true;
        try {
            Thread.sleep(700);
        } catch (InterruptedException ex) {
            Logger.getLogger(UpdateLoop.class.getName()).log(Level.SEVERE, null, ex);
        }
        int rounds = 0;
        while (continues) {
            if (tetris.getContinues()) {
                try {
                    Thread.sleep(20);
                } catch (InterruptedException ex) {
                    Logger.getLogger(UpdateLoop.class.getName()).log(Level.SEVERE, null, ex);
                }
                this.renderer.updateNow();
            } else {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException ex) {
                    Logger.getLogger(MyRenderLoop.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

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
