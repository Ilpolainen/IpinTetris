/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fi.ilmaripohjola.ipitris.utilities;

import fi.ilmaripohjola.ipitris.application.logic.GameConfiguration;
import fi.ilmaripohjola.ipitris.gamelogic.GameState;
import javax.swing.JPanel;

/**
 * Abstract class which is meant to be a baseclass for renderers. Only requires
 * updateNow() implementation from the Classes that implement this.
 *
 * @author omistaja
 */
public abstract class Renderer extends JPanel {
    /**
     * Meant to update the screen image.
     */
    
    protected final GameState gameState;
    protected final GameConfiguration configuration;

    public Renderer(GameState gameState, GameConfiguration configuration) {
        this.gameState = gameState;
        this.configuration = configuration;
    }
    
    
    public void updateNow(){};
    
    public GameState getGameState() {
        return this.gameState;
    }

    public GameConfiguration getConfiguration() {
        return configuration;
    }
    
    public void checkConfiguration() {
        
    }
    
}
