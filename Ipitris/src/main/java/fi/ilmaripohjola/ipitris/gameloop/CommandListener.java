/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fi.ilmaripohjola.ipitris.gameloop;

import fi.ilmaripohjola.ipitris.application.logic.GameConfiguration;
import fi.ilmaripohjola.ipitris.gamelogic.commands.GameCommand;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.EnumSet;

/**
 *
 * @author Ilmari Pohjola
 */
public class CommandListener implements KeyListener {
    
    private final GameConfiguration gameConfiguration;
    private final EnumSet commands;
    
    
    public CommandListener(GameConfiguration gameConfiguration) {
        this.gameConfiguration = gameConfiguration;
        this.commands = EnumSet.allOf(GameCommand.class);
        this.commands.clear();
    }
    

    @Override
    public void keyTyped(KeyEvent e) {
        
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int keyCode = e.getExtendedKeyCode();
        if (this.gameConfiguration.keyConfiguration.get(keyCode) != null) {
            GameCommand command = this.gameConfiguration.getGameCommand(keyCode);
            this.commands.add(command);
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        //To change body of generated methods, choose Tools | Templates.
    }
    
    public EnumSet<GameCommand> getInput() {
        EnumSet<GameCommand> currentCommands = this.commands.clone();
        this.commands.clear();
        return currentCommands;
    } 

    public EnumSet getCommands() {
        return commands;
    }
    
    
}
