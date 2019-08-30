/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fi.ilmaripohjola.ipitris.application.logic;


import fi.ilmaripohjola.ipitris.application.logic.actions.ApplicationCommand;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author Ilmari Pohjola
 */
public class Application implements ActionListener {
    
    private final ConfigurationState configurationState;
    private final PlayState playState;
    
    public Application() {
        this.configurationState = new ConfigurationState();
        this.playState = new PlayState(this.configurationState.getConfiguration());
    }
    
    public void run() {
        this.configurationState.start(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        ApplicationCommand.valueOf(e.getActionCommand()).getApplicationAction().runAction(this);
    }

    public ConfigurationState getConfigurationState() {
        return configurationState;
    }

    public PlayState getPlayState() {
        return playState;
    }
}