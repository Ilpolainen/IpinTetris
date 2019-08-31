/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fi.ilmaripohjola.ipitris.gameloop;

import fi.ilmaripohjola.ipitris.gamelogic.commands.GameCommand;
import fi.ilmaripohjola.ipitris.utilities.Renderer;
import java.util.EnumSet;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Ilmari Pohjola
 */
public class MyGameLoop extends GameLoop implements Runnable{
    private boolean paused;
    
    public MyGameLoop(GameCommandDelegator delegator,CommandListener commandListener,Renderer renderer) {
        super(delegator,commandListener,renderer);
        this.paused = false;
    }

    @Override
    public void start() {
        this.commandDelegator.resetGame();
        Thread thread = new Thread(this);
        thread.start();
    }
    
    
    
    private void loop() throws InterruptedException {
        long oldTime=System.currentTimeMillis();
//        this.commandDelegator.resetGame();
        super.running = true;
        while (super.running) {
            this.renderer.updateNow();
            if (this.paused == false) {
                EnumSet<GameCommand> commands = super.commandListener.getInput();
                super.commandDelegator.processInput(commands);
            }
            try {
                Thread.sleep(10);
            } catch (InterruptedException ex) {
                Logger.getLogger(MyGameLoop.class.getName()).log(Level.SEVERE, null, ex);
            }
            if (this.paused == false) {
                long newTime = System.currentTimeMillis();
                long deltaTime = newTime - oldTime;
                super.commandDelegator.addGameTime(deltaTime);
                oldTime = newTime;
            }
        }
        
    }

    @Override
    public void pause() {
        if (this.paused == false) {
            this.paused = true;
        } else {
            this.paused = false;
        } 
    }

    @Override
    public void reset() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void terminate() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void run() {
        try {
            loop();//To change body of generated methods, choose Tools | Templates.
        } catch (InterruptedException ex) {
            Logger.getLogger(MyGameLoop.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void stop() {
        super.running = false;
        this.commandDelegator.resetGame();
    }

    
}
