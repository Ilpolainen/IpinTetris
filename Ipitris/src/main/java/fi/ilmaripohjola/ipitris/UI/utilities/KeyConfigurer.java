/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fi.ilmaripohjola.ipitris.UI.utilities;

import fi.ilmaripohjola.ipitris.application.logic.GameConfiguration;
import fi.ilmaripohjola.ipitris.gamelogic.commands.GameCommand;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 *
 * @author Ilmari Pohjola
 */
public class KeyConfigurer implements ActionListener, KeyListener {
    
    private final GameConfiguration configuration;
    private GameCommand commandToConfigure;
    
    public KeyConfigurer(GameConfiguration configuration) {
        this.configuration = configuration;
        this.commandToConfigure = null;
    }   

    @Override
    public void actionPerformed(ActionEvent e) {
        this.commandToConfigure = GameCommand.valueOf(e.getActionCommand());
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (this.commandToConfigure != null) {
            configuration.setKey(e.getExtendedKeyCode(), commandToConfigure);
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }    
}
