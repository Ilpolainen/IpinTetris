/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fi.ilmaripohjola.ipitris.gameloop;

import fi.ilmaripohjola.ipitris.utilities.Renderer;

/**
 *
 * @author Ilmari Pohjola
 */
public abstract class GameLoop  {
    protected final GameCommandDelegator commandDelegator;
    protected final CommandListener commandListener;
    protected final Renderer renderer;
    protected boolean running;
//    protected final Thread thread;

    public GameLoop(GameCommandDelegator commandDelegator,CommandListener commandListener,Renderer renderer) {
        this.commandDelegator = commandDelegator;
        this.commandListener = commandListener;
        this.renderer = renderer; 
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
