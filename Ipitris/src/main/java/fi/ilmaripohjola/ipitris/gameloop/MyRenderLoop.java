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
 *
 * @author omistaja
 */
public class MyRenderLoop implements Runnable {

    private TetrisLogic tetris;
    private Renderer renderer;
    private Thread t;
    private boolean continues;

    public MyRenderLoop(Renderer renderer, TetrisLogic tetris) {
        this.renderer = renderer;
        this.tetris = tetris;
    }

    @Override
    public void run() {
        boolean[] keys = new boolean[4];
        this.continues = true;
        try {
            Thread.sleep(700);
        } catch (InterruptedException ex) {
            Logger.getLogger(MyGameLoop.class.getName()).log(Level.SEVERE, null, ex);
        }

        Date date = new Date();
        long currentTime = date.getTime();
        long lastUpdate = date.getTime();
        long deltaTime = currentTime - lastUpdate;
        int rounds = 0;
        while (continues) {
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
            this.renderer.updateNow();
            
        } //To change body of generated methods, choose Tools | Templates.
    }

    public void start() {
        System.out.println("Starting renderloop");
        if (t == null) {
            t = new Thread(this, "3");
            t.start();
//       
        }
    }
}
