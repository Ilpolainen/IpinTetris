/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fi.ilmaripohjola.ipitris.application.logic;

import fi.ilmaripohjola.ipitris.UI.StartingScreen;
import java.awt.event.ActionListener;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Ilmari Pohjola
 */
public class ConfigurationState {
    
    private final StartingScreen startingScreen;
    private final GameConfiguration configuration;
    
    public ConfigurationState() {
        this.configuration = new GameConfiguration(10,25,30);
        this.startingScreen = new StartingScreen(this.configuration);
    }

    public StartingScreen getStartingScreen() {
        return startingScreen;
    }
    
    public void start(Application app) {
        try {
            this.startingScreen.start(app);
        } catch (InterruptedException ex) {
            Logger.getLogger(ConfigurationState.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void setActive(Application app) {
        this.startingScreen.setActive(true);
    }

    public GameConfiguration getConfiguration() {
        return configuration;
    }
    
    

    public void setInActive(Application app) {
        this.startingScreen.setActive(false);
    }
    
}
