/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fi.ilmaripohjola.ipitris.interfaces;

import fi.ilmaripohjola.ipitris.gamelogic.Logic;
import java.awt.event.KeyEvent;
import static java.awt.event.KeyEvent.VK_DOWN;
import static java.awt.event.KeyEvent.VK_LEFT;
import static java.awt.event.KeyEvent.VK_RIGHT;
import static java.awt.event.KeyEvent.VK_SPACE;
import static java.awt.event.KeyEvent.VK_UP;
import java.awt.event.KeyListener;

/**
 *
 * @author omistaja
 */
public class KeyPressListener implements KeyListener {
    
    private Logic tetris;

    public KeyPressListener(Logic tetris) {
        this.tetris = tetris;
    }
    
    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == VK_SPACE) {
            tetris.rotateRight();
        }
        if (e.getKeyCode() == VK_DOWN) {
            tetris.moveDown();
        }
        if (e.getKeyCode() == VK_LEFT) {
            tetris.moveLeft();
        }
        if (e.getKeyCode() == VK_RIGHT) {
            tetris.moveRight();
        }
    }
    
    @Override
    public void keyReleased(KeyEvent e) {
         //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void keyTyped(KeyEvent e) {
         //To change body of generated methods, choose Tools | Templates.
    }
    
}
