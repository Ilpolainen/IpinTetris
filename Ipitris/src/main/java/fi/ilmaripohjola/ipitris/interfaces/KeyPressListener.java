package fi.ilmaripohjola.ipitris.interfaces;

import fi.ilmaripohjola.ipitris.gamelogic.TetrisLogic;
import fi.ilmaripohjola.ipitris.gameloop.MyGameLoop;
import java.awt.event.KeyEvent;
import static java.awt.event.KeyEvent.VK_DOWN;
import static java.awt.event.KeyEvent.VK_ENTER;
import static java.awt.event.KeyEvent.VK_LEFT;
import static java.awt.event.KeyEvent.VK_RIGHT;
import static java.awt.event.KeyEvent.VK_SPACE;
import static java.awt.event.KeyEvent.VK_UP;
import java.awt.event.KeyListener;

/**
 * Get's the input from user and sets boolean values for pressed keys.
 *
 * @author omistaja
 */
public class KeyPressListener implements KeyListener {

    private StateCoordinator stateCoordinator;
    private boolean down;
    private boolean space;
    private boolean left;
    private boolean right;

    /**
     * Sets the StateCoordinator which boolean values are meant to be changed.
     *
     * @param stateCoordinator the StateCoordinator which boolean values are
     * meant to be changed.
     */
    public KeyPressListener(StateCoordinator stateCoordinator) {
        this.stateCoordinator = stateCoordinator;
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
        }
        if (e.getKeyCode() == VK_LEFT) {
            left = true;
        }
        if (e.getKeyCode() == VK_RIGHT) {
            System.out.println("Right");
            right = true;
        }
        if (e.getKeyCode() == VK_SPACE) {
            space = true;
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
