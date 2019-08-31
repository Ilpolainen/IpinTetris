/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fi.ilmaripohjola.ipitris.application.logic;

import fi.ilmaripohjola.ipitris.UI.GameScreen;
import fi.ilmaripohjola.ipitris.entities.GameTable;
import fi.ilmaripohjola.ipitris.gameloop.GameCommandDelegator;
import fi.ilmaripohjola.ipitris.gamelogic.GameState;
import fi.ilmaripohjola.ipitris.gamelogic.utilities.PieceGenerator;
import fi.ilmaripohjola.ipitris.gameloop.CommandListener;
import fi.ilmaripohjola.ipitris.gameloop.GameLoop;
import fi.ilmaripohjola.ipitris.gameloop.MyGameLoop;
import fi.ilmaripohjola.ipitris.utilities.MyFirstRenderer;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Ilmari Pohjola
 */
public class PlayState {
    
    private final GameScreen gameScreen;
    private final GameState gameState;
    private final GameLoop gameLoop;
    private final GameConfiguration configuration;
    private final MyFirstRenderer renderer;
    private final CommandListener commandListener;
    private final GameCommandDelegator gameCommandDelegator;
    private final PieceGenerator pieceGenerator;
    
    
    public PlayState(GameConfiguration configuration) {
        this.configuration = configuration;
        this.commandListener = new CommandListener(this.configuration);
        this.pieceGenerator = new PieceGenerator(this.configuration);
        System.out.println("FROM PlayState() width:" + this.configuration.getBoardWidth());
        this.gameState = new GameState(new GameTable(this.configuration.getBoardWidth(),this.configuration.getBoardHeight()),this.pieceGenerator);
        this.gameState.reset(this.configuration.getBoardWidth(),this.configuration.getBoardHeight());
        this.renderer = new MyFirstRenderer(this.gameState,this.configuration);  
        this.gameScreen = new GameScreen(this.configuration,this.renderer,this.commandListener);
        this.gameCommandDelegator = new GameCommandDelegator(this.gameState,this.configuration);
        this.gameLoop = new MyGameLoop(gameCommandDelegator,commandListener,this.renderer);
    }

    public void start(Application application) {
        try {
            this.gameScreen.start(application);
        } catch (InterruptedException ex) {
            Logger.getLogger(PlayState.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.gameLoop.start();
    }

    public void setInActive(Application application) {
        this.gameScreen.setActive(false);
        this.gameLoop.stop();
    }

    public void setActive(Application app) {
        this.commandListener.getCommands().clear();
        this.gameLoop.start();
        this.gameScreen.setActive(true);
    }
    
       
    public void restart(Application app) {
        this.commandListener.getCommands().clear();
        this.gameCommandDelegator.resetGame();
    }
    

    public void pause() {
        this.gameLoop.pause();
    }
}
