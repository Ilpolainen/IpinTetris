/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fi.ilmaripohjola.ipitris.gameloop;

/**
 *
 * @author Ilmari Pohjola
 */
public abstract class GameLoop  {
    protected final GameCommandDelegator commandDelegator;
    protected final CommandListener commandListener;
    protected boolean running;
//    protected final Thread thread;

    public GameLoop(GameCommandDelegator commandDelegator,CommandListener commandListener) {
        this.commandDelegator = commandDelegator;
        this.commandListener = commandListener;
        this.running = false;
//        this.thread= new Thread(this);
    }
    
    /**
     *
     */
    public abstract void start();
    public abstract void stop();
    public abstract void pause();
    public abstract void reset();
    public abstract void terminate(); 
}
