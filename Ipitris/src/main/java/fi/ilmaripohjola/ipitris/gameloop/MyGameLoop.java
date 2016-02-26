package fi.ilmaripohjola.ipitris.gameloop;

import fi.ilmaripohjola.ipitris.gamelogic.Logic;
import fi.ilmaripohjola.ipitris.interfaces.KeyPressListener;
import fi.ilmaripohjola.ipitris.utilities.MyFirstRenderer;
import fi.ilmaripohjola.ipitris.utilities.Renderer;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Runnable class that loops and updates the TetrisLogic's state within it's own
 * thread.
 *
 * @author omistaja
 */
public class MyGameLoop implements Runnable {

    private boolean continues;
    private KeyPressListener listener;
    private Logic tetris;
    private Thread t;

    /**
     * Constructs MyGameLoop with given values.
     *
     * @param listener KeyPressListener for ending the game. Currently not
     * needed.
     * @param tetris The GameLogic to update.
     */
    public MyGameLoop(KeyPressListener listener, Logic tetris) {
        this.continues = false;
        this.listener = listener;
        this.tetris = tetris;
    }

    /**
     * A getter for continues boolean.
     *
     * @return continues boolen
     */
    public boolean continues() {
        return this.continues;
    }

    public Thread getT() {
        return t;
    }

    @Override
    public void run() {
        System.out.println("Game On");
        boolean[] keys = new boolean[4];
        this.tetris.restart();
        this.continues = true;
        try {
            Thread.sleep(400);
        } catch (InterruptedException ex) {
            Logger.getLogger(MyGameLoop.class.getName()).log(Level.SEVERE, null, ex);
        }

        int rounds = 0;
        while (continues) {
            if (tetris.getContinues()) {
                getKeys(keys);
                if (rounds > 40 - 2 * tetris.getLevel()) {
                    keys[0] = true;
                    rounds = 0;
                }
                rounds++;
                this.tetris.update(keys[0], keys[1], keys[2], keys[3]);
                emptyKeys();

                try {
                    Thread.sleep(10);
                } catch (InterruptedException ex) {
                    Logger.getLogger(MyGameLoop.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException ex) {
                    Logger.getLogger(MyGameLoop.class.getName()).log(Level.SEVERE, null, ex);
                }
            }            
        }
    }

    /**
     * Starts the thread for this loop.
     */
    public void createThreadAndStart() {
        System.out.println("Starting gameloop");
        if (t == null) {
            t = new Thread(this, "3");
        }
        t.start();
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
