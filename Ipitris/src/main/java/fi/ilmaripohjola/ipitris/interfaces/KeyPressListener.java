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
    private boolean down;
    private boolean space;
    private boolean left;
    private boolean right;

    public KeyPressListener(Logic tetris) {
        this.tetris = tetris;
        down = false;
        space = false;
        left = false;
        right = false;
    }

    public void setDown(boolean down) {
        this.down = down;
    }

    public void setSpace(boolean space) {
        this.space = space;
    }

    public void setLeft(boolean left) {
        this.left = left;
    }

    public void setRight(boolean right) {
        this.right = right;
    }

    public boolean isDown() {
        return down;
    }

    public boolean isSpace() {
        return space;
    }

    public boolean isLeft() {
        return left;
    }

    public boolean isRight() {
        return right;
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == VK_DOWN) {
            down = true;
//            tetris.getCommands()[0].runCommand();            
        }
        if (e.getKeyCode() == VK_LEFT) {
            left = true;
//            tetris.getCommands()[1].runCommand();
        }
        if (e.getKeyCode() == VK_RIGHT) {
            right = true;
//            tetris.getCommands()[2].runCommand();
        }
        if (e.getKeyCode() == VK_SPACE) {
            space = true;
//            tetris.getCommands()[3].runCommand();
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
