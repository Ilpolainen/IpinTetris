/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fi.ilmaripohjola.ipitris.interfaces;

import java.awt.Color;
import java.awt.event.KeyEvent;
import static java.awt.event.KeyEvent.VK_DOWN;
import static java.awt.event.KeyEvent.VK_LEFT;
import static java.awt.event.KeyEvent.VK_RIGHT;
import static java.awt.event.KeyEvent.VK_SPACE;
import java.awt.event.KeyListener;
import javax.swing.JButton;
import javax.swing.JPanel;

/**
 *
 * @author omistaja
 */
public class KeyConfigurer implements KeyListener {

    private int[] keys;
    private StartingScreen ss;

    public KeyConfigurer(StartingScreen ss) {
        System.out.println("KeyConfigurer Luotu");
        this.ss = ss;
        this.keys = new int[4];
        keys[0] = VK_DOWN;
        keys[1] = VK_LEFT;
        keys[2] = VK_RIGHT;
        keys[3] = VK_SPACE;
    }

    public int[] getKeys() {
        return keys;
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (ss.getKeyToConfigure() >= 0 && ss.getKeyToConfigure() <= 3) {
            JPanel keyPanel = (JPanel) this.ss.getFrame().getContentPane().getComponent(5);
            JPanel buttons = (JPanel) keyPanel.getComponent(1);
            for (int i = 0; i < 4; i++) {
                JButton button = (JButton) buttons.getComponent(i);
                button.setForeground(buttons.getForeground());
            }            
            keys[ss.getKeyToConfigure()] = e.getKeyCode();
            System.out.println(e.getKeyCode());
            ss.setKeyToConfigure(-1);
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }

}
