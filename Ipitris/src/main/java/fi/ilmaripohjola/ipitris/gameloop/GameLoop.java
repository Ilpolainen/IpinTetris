/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fi.ilmaripohjola.ipitris.gameloop;

import fi.ilmaripohjola.ipitris.gamelogic.GameCommandDelegator;
import fi.ilmaripohjola.ipitris.utilities.Renderer;

/**
 *
 * @author Ilmari Pohjola
 */
public abstract class GameLoop  {
    protected final GameCommandDelegator commandDelegator;
    protected final GameCommandListener commandListener;
    protected final Renderer renderer;
    protected boolean running;
    protected boolean paused;


    public GameLoop(GameCommandDelegator commandDelegator,GameCommandListener commandListener,Renderer renderer) {
        this.commandDelegator = commandDelegator;
        this.commandListener = commandListener;
        this.renderer = renderer; 
        this.running = false;
        this.paused = false;
//        this.thread= new Thread(this);
    }
    
    /**
     *
     */
    public abstract void start();
    public abstract void stop();
    public abstract void pause();
}
